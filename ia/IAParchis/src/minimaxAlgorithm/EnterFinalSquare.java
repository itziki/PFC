package minimaxAlgorithm;

import parchis.Partida;
import parchis.Pieza;
import formulation.Action;
import formulation.State;

public class EnterFinalSquare extends Action {

	public EnterFinalSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected State effect(State state, int dice)
	{
		Partida currentPartida = (Partida)state.getPartida();
		Pieza piezaSelect = (Pieza)state.getPieza();
		
		//la ficha ha terminado, queda fuera del juego -> en la ultima casilla
		int nuevaCasilla = 0;
		switch (piezaSelect.getColor())
		{
		case 0:		
			nuevaCasilla = 79;
			break;
		case 1:
			nuevaCasilla = 89;
			break;
		case 2:
			nuevaCasilla = 95;
			break;
		case 3:

			nuevaCasilla = 103;
			break;
		};
		
		currentPartida.getTablero().getCasillero().getCasillas().get(piezaSelect.getCasilla()).getPiezas().get(0).setCasilla(nuevaCasilla);
		State newState = new State(currentPartida);
		newState.setRating(9);
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	{
		boolean isApplicable = false;
		Pieza piezaSelec = (Pieza)state.getPieza(); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla() + dice; //futura casilla
		
		//si con la tirada del dado entra en la casilla final
		switch (piezaSelec.getColor())
		{
		case 0:		
			if(casilla == 79)
			{
				isApplicable = true;
			}
			break;
		case 1:
			if(casilla == 89)
			{
				isApplicable = true;
			}
			break;
		case 2:
			if(casilla == 95)
			{
				isApplicable = true;
			}
			break;
		case 3:
			if(casilla == 103)
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
