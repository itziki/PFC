package minimaxAlgorithm;

import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class ReturnChipToHome extends Action {

	public ReturnChipToHome(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected State effect(State state, int dice) {
		
		Partida currentPartida = (Partida)state.getPartida();
		Pieza piezaSelect = (Pieza)state.getPieza();
		
		//La ficha vuelve a la casa del principio
		currentPartida.getTablero().getCasillero().getCasillas()[piezaSelect.getCasilla() + dice].getPiezas().get(0).setCasilla(104);
		State newState = new State(currentPartida);
		newState.setRating(9);
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	{		
		boolean isApplicable = false;
		//cogemos el information, que sera el tablero
		Partida currentPartida = (Partida)state.getPartida();
		Tablero tablero = currentPartida.getTablero();
		Pieza piezaSelec = (Pieza)state.getPieza(); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla();
		
		//Si ha sacado tres 6 seguidos
		if (tablero.getDado().getConsecutive6().size() == 3)
		{
			isApplicable = true;
		}
		else
		{
			isApplicable = false;
		}
		
		//Si está en el circuito
		switch (piezaSelec.getColor())
		{
		case 0:		
			if(casilla != 0 && !(casilla >= 72 && casilla <= 79))
			{
				isApplicable = true;
			}
			break;
		case 1:
			if(casilla != 1 && !(casilla >= 80 && casilla <= 89))
			{
				isApplicable = true;
			}
			break;
		case 2:
			if(casilla != 2 && !(casilla >= 88 && casilla <= 95))
			{
				isApplicable = true;
			}
			break;
		case 3:
			if(casilla != 3 && !(casilla >= 93 && casilla <= 103))
			{
				isApplicable = true;
			}
			break;
		default:
				isApplicable = false;
		};
		
		return isApplicable;
	}

}
