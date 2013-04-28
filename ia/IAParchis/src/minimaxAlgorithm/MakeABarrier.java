package minimaxAlgorithm;

import parchis.Casilla;
import parchis.Casillero;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class MakeABarrier extends Action {

	public MakeABarrier(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected State effect(State state, int dice) {
		
		Partida currentPartida = (Partida)state.getPartida();
		Pieza piezaSelect = (Pieza)state.getPieza();
		
		//Las fichas que no sean del color de la barrera no pueden pasar -> se meten las dos fichas en la casilla
		currentPartida.getTablero().getCasillero().getCasillas().get(piezaSelect.getCasilla()).addPiezaToCasilla(piezaSelect);
		State newState = new State(currentPartida);
		newState.setRating(5);	
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	{
		boolean isApplicable = false;
		//cogemos el information, que sera el tablero
		Partida currentPartida = (Partida)state.getPartida();
		Tablero tablero = currentPartida.getTablero();
		Casillero casillero = tablero.getCasillero();
		Pieza piezaSelec = (Pieza)state.getPieza(); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla();
		
		//Si en la última casilla del movimiento que toque hay SÓLO una ficha de nuestro color
		int numeroNuevaCasilla = casilla + dice;
		Casilla nuevaCasilla = casillero.getCasillas().get(numeroNuevaCasilla);
		if(nuevaCasilla.getPiezas().size() == 1) //sólo una ficha
		{
			if(nuevaCasilla.getPiezas().get(0).getColor() == currentPartida.getColorJugador()) //es de nuestro color
			{
				isApplicable = true;
			}
			else
			{
				isApplicable = false;
			}
			
			//Si la ficha no está en la casilla final
			switch (piezaSelec.getColor())
			{
			case 0:		
				if(casilla != 79)
				{
					isApplicable = true;
				}
				break;
			case 1:
				if(casilla != 89)
				{
					isApplicable = true;
				}
				break;
			case 2:
				if(casilla != 95)
				{
					isApplicable = true;
				}
				break;
			case 3:
				if(casilla != 103)
				{
					isApplicable = true;
				}
				break;
			default:
					isApplicable = false;
			};
		}
		
		
		return isApplicable;
	}

}
