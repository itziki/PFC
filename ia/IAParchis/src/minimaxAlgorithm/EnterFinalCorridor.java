package minimaxAlgorithm;

import parchis.Partida;
import parchis.Pieza;
import formulation.Action;
import formulation.State;

public class EnterFinalCorridor extends Action {

	public EnterFinalCorridor(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected State effect(State state, int dice)
	{		
		Partida currentPartida = (Partida)state.getPartida();
		Pieza piezaSelect = (Pieza)state.getPieza();
		
		//la ficha entra en el pasillo
		currentPartida.getTablero().getCasillero().getCasillas().get(piezaSelect.getCasilla()).getPiezas().get(0).setCasilla(piezaSelect.getCasilla() + dice);
		State newState = new State(currentPartida);
		newState.setRating(7);
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	{
		boolean isApplicable = false;
		Pieza piezaSelec = (Pieza)state.getPieza(); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla() + dice;
		
		//si con el movimiento entramos en el pasillo
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
		return isApplicable;
	}

}
