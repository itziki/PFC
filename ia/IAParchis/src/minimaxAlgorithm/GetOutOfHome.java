package minimaxAlgorithm;

import java.util.List;

import parchis.Casillero;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class GetOutOfHome extends Action {
	int numeroFicha = 0;

	public GetOutOfHome(String name, int numeroFicha) {
		super(name);
		this.numeroFicha = numeroFicha;
	}

	@Override
	protected State effect(State state, int dice) {
		
		Partida currentPartida = (Partida)state.getPartida();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1);
		Casillero casillero = currentPartida.getTablero().getCasillero();
		
		int casillaSalida = 0;
		
		switch(currentPartida.getColorJugador())
		{
			case 0:
				casillaSalida = 5;
				break;
			case 1:
				casillaSalida = 22;
				break;
			case 2:
				casillaSalida = 39;
				break;
			case 3:
				casillaSalida = 56;
				break;
		}
		
		//La ficha sale y se queda en la casilla de salida
		piezaSelec.setCasilla(casillaSalida);
		
		//Si hay dos fichas de otro color en la casilla se come la última que ha llegado
		List<Pieza> piezas = casillero.getCasillas().get(casillaSalida).getPiezas();
			//piezas->piezas de la casilla de salida
		if (piezas.size() == 2)
		{
			piezas.remove(1);
		}
		
		//Si hay una ficha de mi color hago barrera
		if(piezas.size() == 1)
		{
			int color = piezas.get(0).getColor();
			if(color == currentPartida.getColorJugador())
			{
				piezas.add(piezaSelec);
			}
		}
		
		currentPartida.getTablero().getCasillero().getCasillas().get(casillaSalida).setPiezas(piezas);
		State newState = new State("get_out_of_home");
		newState.setPartida(currentPartida);
		piezaSelec.setRecorrido(1);
		newState.setPieza(piezaSelec);
		//generate rating
		double x = piezaSelec.getRecorrido() * 0.16;
		double y = Math.abs(x - 5);
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
		Casillero casillero = tablero.getCasillero();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1);
		int casilla = piezaSelec.getCasilla();
		
		//Si la ficha está en casa
		if(piezaSelec.getCasilla() == 101)
		{
			//Si el dado ha sacado 5
			if(dice == 5)
			{
				//Si no tengo barrera de mi color en la casilla de salida
				switch (piezaSelec.getColor())
				{
				case 0:		
					if(!(casillero.getCasillas().get(5).getPiezas().size() == 2))
					{
						isApplicable = true;
					}
					
					break;
				case 1:
					if(!(casillero.getCasillas().get(22).getPiezas().size() == 2))
					{
						isApplicable = true;
					}
					break;
				case 2:
					if(!(casillero.getCasillas().get(39).getPiezas().size() == 2))
					{
						isApplicable = true;
					}
					break;
				case 3:
					if(!(casillero.getCasillas().get(56).getPiezas().size() == 2))
					{
						isApplicable = true;
					}					
					break;
				default:
						isApplicable = false;
				};
			}
		}
		else
		{
			isApplicable = false;
		}
		
		
		/*
		 * 0 - Casa amarilla
		 * 1 - Casa azul
		 * 2 - Casa roja
		 * 3 - Casa verde
		 * 12..71 - Tablero
		 * 72..79 - Pasillo amarillo
		 * 80..87 - pasillo azul
		 * 88..95 - pasillo rojo
		 * 96..103 - pasillo verde
		 * además, las casillas seguras para todos son:
		 * 4,5,6,7,8,9,10,11*/
		return isApplicable;
	}

}
