package minimaxAlgorithm;

import java.util.List;

import parchis.Partida;
import parchis.Pieza;
import formulation.Action;
import formulation.State;

public class MoveChipInCorridor extends Action {
	private int numeroFicha = 0;

	public MoveChipInCorridor(String name, int numeroFicha) {
		super(name);
		this.numeroFicha = numeroFicha;
	}

	@Override
	protected State effect(State state, int dice)
	{
		Partida currentPartida = (Partida)state.getPartida();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1);
		int nuevaCasilla = piezaSelec.getCasilla() + dice;
		
		//la ficha se mueve dentro del pasillo
		currentPartida.getTablero().getCasillero().getCasillas().get(piezaSelec.getCasilla()).removeFicha();
		piezaSelec.setCasilla(nuevaCasilla);
		piezaSelec.setRecorrido(piezaSelec.getRecorrido() + dice);
		currentPartida.getTablero().getCasillero().getCasillas().get(nuevaCasilla).addPiezaToCasilla(piezaSelec);
		currentPartida.getTablero().getCasillero().getCasillas().get(nuevaCasilla).addFicha();
		
		State newState = new State("move_chip_in_corridor");
		newState.setPartida(currentPartida);
		newState.setPieza(piezaSelec);
		/*double x = piezaSelec.getRecorrido() * 0.16;
		double y = Math.abs(x - 1);*/
		newState.setRating(3);
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	{
		boolean isApplicable = false;
		Partida currentPartida = (Partida)state.getPartida();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla();
		int nuevaCasilla = casilla + dice;
		
		//si la ficha está en el pasillo
		switch (piezaSelec.getColor())
		{
			
		case 0:		
			if((casilla >= 69) && (casilla <= 76))
			{//si la tirada es menor que las casillas que le quedan hasta la última casilla (incluida)
				if((nuevaCasilla >= 69) && (nuevaCasilla <= 76))
				{
					isApplicable = true;
				}
			}
			break;
		case 1:
			if((casilla >= 77) && (casilla <= 84))
			{
				if((nuevaCasilla >= 77) && (nuevaCasilla <= 84))
				{
					isApplicable = true;
				}
			}
			break;
		case 2:
			if((casilla >= 85) && (casilla <= 92))
			{
				if((nuevaCasilla >= 85) && (nuevaCasilla <= 92))
				{
					isApplicable = true;
				}
			}
			break;
		case 3:
			if((casilla >= 93) && (casilla <= 100))
			{
				if((nuevaCasilla >= 93) && (nuevaCasilla <= 100))
				{
					isApplicable = true;
				}
			}
			break;
		default:
				isApplicable = false;
		};
		
		return isApplicable;
	}

}
