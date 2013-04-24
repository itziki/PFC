package minimaxAlgorithm;

import parchis.Casilla;
import parchis.Casillero;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class JumpABarrier extends Action {

	public JumpABarrier(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected State effect(State state, int dice)
	{
		Partida currentPartida = (Partida)state.getPartida();
		Pieza piezaSelect = (Pieza)state.getPieza();
		
		//la ficha se mueve
		System.out.println(piezaSelect.getCasilla() + dice);
		System.out.println(piezaSelect.getCasilla());
		currentPartida.getTablero().getCasillero().getCasillas()[piezaSelect.getCasilla()].getPiezas().get(0).setCasilla(piezaSelect.getCasilla() + dice);

		State newState = new State(currentPartida);
		newState.setRating(5);
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	{
		boolean isApplicable = false;
		Partida currentPartida = (Partida)state.getPartida();
		Tablero tablero = currentPartida.getTablero();
		Casillero casillero = tablero.getCasillero();
		Casilla[] casillas = casillero.getCasillas();
		Pieza piezaSelec = (Pieza)state.getPieza(); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla();
		
		//si las ficha es del mismo color que las fichas de la barrera
		for (int i = casilla; i <= casilla + dice; i++)
		{
			if ((casillas[i].getPiezas().size() == 2) &&
				(casillas[i].getPiezas().get(0).getColor() == casillas[i].getPiezas().get(1).getColor()) &&
				(casillas[i].getPiezas().get(0).getColor() == currentPartida.getColorJugador()))
			{
				isApplicable = true;
			}
		}
		
		//si con el movimiento no se queda en la casilla de la barrera
		System.out.println((casillas[casilla + dice].getPiezas().size()));
		if((casillas[casilla + dice].getPiezas().size() == 2))
		{
			isApplicable = false;
		}
		else
		{
			isApplicable = false;
		}
		
		return isApplicable;
	}

}
