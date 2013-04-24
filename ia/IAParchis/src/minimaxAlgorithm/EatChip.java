package minimaxAlgorithm;

import parchis.Casilla;
import parchis.Casillero;
import parchis.Dado;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class EatChip extends Action {

	public EatChip(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected State effect(State state, int dice)
	{
		Partida currentPartida = (Partida)state.getPartida();
		Pieza piezaSelect = (Pieza)state.getPieza();
		
		//Se mueven 20 casillas con la ficha que se quiera
		currentPartida.getTablero().setDado(new Dado(20));
		
		//La ficha comida vuelve a casa
		currentPartida.getTablero().getCasillero().getCasillas()[piezaSelect.getCasilla() + dice].getPiezas().get(0).setCasilla(104);
		State newState = new State("partida");
		newState.setPartida(currentPartida);
		newState.setRating(8);	
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	{
		
		boolean isApplicable = false;
		Partida currentPartida = (Partida)state.getPartida();
		Tablero tablero = currentPartida.getTablero();
		Casillero casillero = tablero.getCasillero();
		Pieza piezaSelec = (Pieza)state.getPieza(); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla();
		
		//Si la ficha está fuera de casa
		if((casilla < 104) && (casilla >= 0))
		{
			//Si en la última casilla del movimiento que toque hay una ficha de otro color distinto al nuestro y no está en seguro
			int numeroNuevaCasilla = casilla + dice;
			Casilla nuevaCasilla = casillero.getCasillas()[numeroNuevaCasilla];
			if(nuevaCasilla.getPiezas().size() == 1 && !(nuevaCasilla.isEsSegura()))
			{
				if(nuevaCasilla.getPiezas().get(0).getColor() != currentPartida.getColorJugador())
				{
					isApplicable = true;
				}
				else
				{
					isApplicable = false;
				}
			}	
		}
		
		return isApplicable;
	}

}
