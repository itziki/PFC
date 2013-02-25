package minimaxAlgorithm;

import parchis.Jugador;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;

public class Minimax {
		
	private Boolean EstadoFinal(Partida game)
	{
		Tablero tablero = game.getTablero();
		Jugador jugadorActual = tablero.getJugador()[game.getColorJugador()];
		Pieza piezas[] = tablero.getCasillero().getPiezas();
		boolean estadoFinal = false;
		for(int i = 0; i < piezas.length; i++)
		{
			if(piezas[i].getColor() == jugadorActual.getColorPiezas())
			{
				if (tablero.getCasillero().piezaEnFinal(piezas[i]))
				{
					estadoFinal = true;
				}
				else
				{
					estadoFinal = false;
					break;
				}
			}
		}
		return estadoFinal;		
	}
	
	public Pieza MiniMax (Partida game) {
		Pieza piezaSeleccionada = null;
		int valorMinimax = MaxValue(game);
		boolean existeMejorSucesor = false;
		while (!existeMejorSucesor)
		{
			//sucesor = estado con cada pieza del jugador
			//sucesor = next state's successor
			if (MinimaxValue(sucesor) == valorMinimax)
			{
				existeMejorSucesor = true;
				piezaSeleccionada = sucesor;
			}
		}
		return piezaSeleccionada;
	}
	
	public int MaxValue (Partida game)
	{		
		int valorMinimax = 0;
		if (EstadoFinal(game))
		{
			valorMinimax = UtilytiValue(game, MAX);
			return valorMinimax;
		}
		else
		{
			valorMinimax = -100;
			for (int i = 0; /*numero piezas*/i<10; i++)
			{
				valorMinimax = MAX(valorMinimax, MinValue(sucesor))
			}
			//asign valorMinimax al estado
			return valorMinimax;
		}
	}
	
	public Pieza MinMove (Partida game)
	{
		int valorMinimax = 0;
		if (EstadoFinal(game))
		{
			valorMinimax = UtilytiValue(game, MAX);
			return valorMinimax;
		}
		else
		{
			valorMinimax = +100;
			for (int i = 0; /*numero piezas*/i<10; i++)
			{
				valorMinimax = MIN(valorMinimax, MaxValue(sucesor))
			}
			//asign valorMinimax al estado
			return valorMinimax;
		}
	}

}
