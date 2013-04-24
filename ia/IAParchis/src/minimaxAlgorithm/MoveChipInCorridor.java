package minimaxAlgorithm;

import parchis.Partida;
import parchis.Pieza;
import formulation.Action;
import formulation.State;

public class MoveChipInCorridor extends Action {

	public MoveChipInCorridor(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected State effect(State state, int dice)
	{
		Partida currentPartida = (Partida)state.getPartida();
		Pieza piezaSelect = (Pieza)state.getPieza();
		
		//la ficha se mueve dentro del pasillo
		currentPartida.getTablero().getCasillero().getCasillas()[piezaSelect.getCasilla()].getPiezas().get(0).setCasilla(piezaSelect.getCasilla() + dice);
		State newState = new State(currentPartida);
		newState.setRating(1);
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	{
		boolean isApplicable = false;
		Pieza piezaSelec = (Pieza)state.getPieza(); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla();
		
		//si la ficha está en el pasillo
		switch (piezaSelec.getColor())
		{
		case 0:		
			if((casilla >= 72) && (casilla <= 79))
			{
				isApplicable = true;
			}
			break;
		case 1:
			if((casilla >= 80) && (casilla <= 89))
			{
				isApplicable = true;
			}
			break;
		case 2:
			if((casilla >= 88) && (casilla <= 95))
			{
				isApplicable = true;
			}
			break;
		case 3:
			if((casilla >= 93) && (casilla <= 103))
			{
				isApplicable = true;
			}
			break;
		default:
				isApplicable = false;
		};
		
		//si la tirada es menor que las casillas que le quedan hasta la última casilla (incluida)
		int nuevaCasilla = casilla + dice;
		
		switch (piezaSelec.getColor())
		{
		case 0:		
			if((nuevaCasilla >= 72) && (nuevaCasilla <= 79))
			{
				isApplicable = true;
			}
			break;
		case 1:
			if((nuevaCasilla >= 80) && (nuevaCasilla <= 89))
			{
				isApplicable = true;
			}
			break;
		case 2:
			if((nuevaCasilla >= 88) && (nuevaCasilla <= 95))
			{
				isApplicable = true;
			}
			break;
		case 3:
			if((nuevaCasilla >= 93) && (nuevaCasilla <= 103))
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
