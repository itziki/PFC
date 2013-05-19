package minimaxAlgorithm;

import java.util.List;

import parchis.Casilla;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class DestroyABarrier extends Action {
	
	int numeroFicha = 0;

	public DestroyABarrier(String name, int numeroFicha) {
		super(name);
		this.numeroFicha = numeroFicha;
	}

	@Override
	protected State effect(State state, int dice)
	{
		Partida currentPartida = (Partida)state.getPartida();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1);
		int casilla = piezaSelec.getCasilla();
		
		//La barrera se rompe moviendo una ficha, la 0
		//currentPartida.getTablero().getCasillero().getCasillas().get(piezaSelec.getCasilla()).getPiezas().get(0).setCasilla(piezaSelec.getCasilla() + dice);
		piezaSelec.setCasilla(piezaSelec.getCasilla() + dice);
		piezaSelec.setRecorrido(piezaSelec.getRecorrido() + dice);
		currentPartida.getTablero().getCasillero().getCasillas().get(casilla + dice).addPiezaToCasilla(piezaSelec);
		currentPartida.getTablero().getCasillero().getCasillas().get(casilla + dice).addFicha();
		currentPartida.getTablero().getCasillero().getCasillas().get(casilla).getPiezas().remove(piezaSelec);
		currentPartida.getTablero().getCasillero().getCasillas().get(casilla).removeFicha();
		
		State newState = new State("destroy_a_barrier");
		newState.setPartida(currentPartida);
		newState.setPieza(piezaSelec);
		
		/*double x = piezaSelec.getRecorrido() * 0.16;
		double y = Math.abs(x - 10);*/
		newState.setRating(5);
		
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
				
		//si la ficha está fuera de casa
		if(casilla != 101)
		{
			//Si hay una barrera hecha
			Casilla casillaPieza = tablero.getCasillero().getCasillas().get(casilla);
			if(casillaPieza.getPiezas().size() == 2)
			{
				if(casillaPieza.getPiezas().get(0).getColor() == casillaPieza.getPiezas().get(1).getColor())
				{
					isApplicable = true;
				}
				//Si en la tirada de dados sale un 6
				if(dice == 6)
				{
					isApplicable = true;
				}
				
				//Si no quedan más fichas en el tablero de ese color
				List<Pieza> piezas = tablero.getCasillero().getPiezasJugador(currentPartida.getColorJugador());
				int piezasEnFinal = 0;
				for(int i = 0; i < piezas.size(); i++)
				{
					switch(piezas.get(i).getCasilla())
					{
						case 76:
						{
							piezasEnFinal++;
							break;
						}
						case 84:
						{
							piezasEnFinal++;
							break;
						}
						case 92:
						{
							piezasEnFinal++;
							break;
						}
						case 100:
						{
							piezasEnFinal++;
							break;
						}
						default:
							break;
					};
				}
				
				if (piezasEnFinal == 2)
				{
					isApplicable = true;
				}
			}
		}
				
		return isApplicable;
	}

}
