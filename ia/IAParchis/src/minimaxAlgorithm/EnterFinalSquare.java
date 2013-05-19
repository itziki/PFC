package minimaxAlgorithm;

import java.util.List;

import parchis.Partida;
import parchis.Pieza;
import formulation.Action;
import formulation.State;

public class EnterFinalSquare extends Action {
	private int numeroFicha = 0;

	public EnterFinalSquare(String name, int numeroFicha) {
		super(name);
		this.numeroFicha = numeroFicha;
	}

	@Override
	protected State effect(State state, int dice)
	{
		Partida currentPartida = (Partida)state.getPartida();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1);
		
		//la ficha ha terminado, queda fuera del juego -> en la ultima casilla
		int nuevaCasilla = 0;
		switch (piezaSelec.getColor())
		{
		case 0:		
			nuevaCasilla = 76;
			break;
		case 1:
			nuevaCasilla = 84;
			break;
		case 2:
			nuevaCasilla = 92;
			break;
		case 3:

			nuevaCasilla = 100;
			break;
		};
		
		currentPartida.getTablero().getCasillero().getCasillas().get(nuevaCasilla).addPiezaToCasilla(piezaSelec);
		currentPartida.getTablero().getCasillero().getCasillas().get(nuevaCasilla).addFicha();
		currentPartida.getTablero().getCasillero().getCasillas().get(piezaSelec.getCasilla()).removeFicha();
		piezaSelec.setCasilla(nuevaCasilla);
		
		State newState = new State("enter_final_square");
		newState.setPartida(currentPartida);
		newState.setPieza(piezaSelec);

		/*double x = piezaSelec.getRecorrido() * 0.16;
		double y = Math.abs(x - 9);*/
		newState.setRating(3);
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	{
		boolean isApplicable = false;
		Partida currentPartida = state.getPartida();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla() + dice; //futura casilla
		
		//si con la tirada del dado entra en la casilla final
		switch (piezaSelec.getColor())
		{
		case 0:		
			if(casilla == 76)
			{
				isApplicable = true;
			}
			break;
		case 1:
			if(casilla == 84)
			{
				isApplicable = true;
			}
			break;
		case 2:
			if(casilla == 92)
			{
				isApplicable = true;
			}
			break;
		case 3:
			if(casilla == 100)
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
