package minimaxAlgorithm;

import java.util.List;

import parchis.Casilla;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class DestroyABarrier extends Action {

	public DestroyABarrier(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected State effect(State state, int dice)
	{
		Partida currentPartida = (Partida)state.getPartida();
		Pieza piezaSelect = (Pieza)state.getPieza();
		
		//La barrera se rompe moviendo una ficha, la 0
		currentPartida.getTablero().getCasillero().getCasillas()[piezaSelect.getCasilla() + dice].getPiezas().get(0).setCasilla(piezaSelect.getCasilla() + dice);

		State newState = new State("partida");
		newState.setPartida(currentPartida);
		newState.setRating(10);
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
		
		//Si hay una barrera hecha
		Casilla casillaPieza = tablero.getCasillero().getCasillas()[casilla];
		if(casillaPieza.getPiezas().size() == 2)
		{
			if(casillaPieza.getPiezas().get(0).getColor() == casillaPieza.getPiezas().get(1).getColor())
			{
				isApplicable = true;
			}
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
				case 79:
				{
					piezasEnFinal++;
					break;
				}
				case 89:
				{
					piezasEnFinal++;
					break;
				}
				case 95:
				{
					piezasEnFinal++;
					break;
				}
				case 103:
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
		
		
		
		return isApplicable;
	}

}
