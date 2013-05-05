package minimaxAlgorithm;

import java.util.List;

import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class ReturnChipToHome extends Action {
	private int numeroFicha = 0;

	public ReturnChipToHome(String name, int numeroFicha) {
		super(name);
		this.numeroFicha = numeroFicha;
	}

	@Override
	protected State effect(State state, int dice) {
		
		Partida currentPartida = (Partida)state.getPartida();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1);
		int casilla = piezaSelec.getCasilla();
		int nuevaCasilla = piezaSelec.getCasilla() + dice;
		
		//La ficha vuelve a la casa del principio
		//currentPartida.getTablero().getCasillero().getCasillas().get(piezaSelec.getCasilla() + dice).getPiezas().get(0).setCasilla(101);
		currentPartida.getTablero().getCasillero().getCasillas().get(casilla).getPiezas().clear();
		piezaSelec.setCasilla(101);
		piezaSelec.setRecorrido(0);
		
		State newState = new State("return_chip_to_home");
		newState.setPartida(currentPartida);
		newState.setPieza(piezaSelec);
		
		//double x = piezaSelec.getRecorrido() * 0.16;
		//double y = Math.abs(x - 9);
		//tiene que ser la que tenga rating mas alto, porque si se puede hacer debe hacerse
		newState.setRating(20);
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	{		
		boolean isApplicable = false;

		Partida currentPartida = (Partida)state.getPartida();
		Tablero tablero = currentPartida.getTablero();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla();
		
		//Si ha sacado tres 6 seguidos
		if (tablero.getDado().getConsecutive6().size() == 3)
		{
			//Si está en el circuito
			switch (piezaSelec.getColor())
			{
			case 0:		
				if(casilla != 5 && !(casilla >= 69 && casilla <= 76))
				{
					isApplicable = true;
				}
				break;
			case 1:
				if(casilla != 22 && !(casilla >= 77 && casilla <= 84))
				{
					isApplicable = true;
				}
				break;
			case 2:
				if(casilla != 39 && !(casilla >= 85 && casilla <= 92))
				{
					isApplicable = true;
				}
				break;
			case 3:
				if(casilla != 56 && !(casilla >= 93 && casilla <= 100))
				{
					isApplicable = true;
				}
				break;
			default:
					isApplicable = false;
			};
		}
		else
		{
			isApplicable = false;
		}
		
		return isApplicable;
	}

}
