package minimaxAlgorithm;

import minimax.MinimaxAlgorithm;
import formulation.Action;
import formulation.Problem;
import formulation.State;
import parchis.Jugador;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;

public class Minimax{
		
	
	public int MaxValue(State state)
	{
		int minimaxValue = 0;
		if (state)
		{
			minimaxValue = UtilytiValue(state, MAX);
			return minimaxValue;
		}
		else
		{
			minimaxValue = -100;
			for (int i = 0; /*numero piezas*/i<10; i++)
			{
				minimaxValue = MAX(minimaxValue, MinValue(sucesor))
			}
			//asign valorMinimax al estado
			return minimaxValue;
		}
	}

	
	public int MinValue(State arg0) {
		int minimaxValue = 0;
		if (EstadoFinal(game))
		{
			minimaxValue = UtilytiValue(game, MAX);
			return minimaxValue;
		}
		else
		{
			minimaxValue = +100;
			for (int i = 0; /*numero piezas*/i<10; i++)
			{
				minimaxValue = MIN(minimaxValue, MaxValue(sucesor))
			}
			//asign valorMinimax al estado
			return minimaxValue;
		}
	}

	
	public Action Minimax(State arg0) {
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


}
