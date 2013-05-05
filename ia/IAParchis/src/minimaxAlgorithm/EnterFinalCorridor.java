package minimaxAlgorithm;

import java.util.List;

import parchis.Partida;
import parchis.Pieza;
import formulation.Action;
import formulation.State;

public class EnterFinalCorridor extends Action {
	private int numeroFicha = 0;

	public EnterFinalCorridor(String name, int numeroFicha) {
		super(name);
		this.numeroFicha = numeroFicha;
	}

	@Override
	protected State effect(State state, int dice)
	{		
		Partida currentPartida = (Partida)state.getPartida();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1);
		
		//la ficha entra en el pasillo
		/*
		 Restamos la casilla en la que estamos con la casilla del seguro antes de los pasillos para saber
		 cuantos movimientos tenemos dentro del pasillo. Luego sumamos esa cantidad a la primera casilla
		 del pasillo que le corresponda a cada color.
		 */
		int casilla = piezaSelec.getCasilla();
		int casillasHastaSeguro = 0;
		int casillasDentroDePasillo = 0;
		int nuevaCasilla = 0;
		switch (piezaSelec.getColor())
		{
		case 0:		
			casillasHastaSeguro = 68 - casilla;
			casillasDentroDePasillo = dice - casillasHastaSeguro;
			nuevaCasilla = 68 + casillasDentroDePasillo;
			break;
		case 1:
			casillasHastaSeguro = 17 - casilla;
			casillasDentroDePasillo = dice - casillasHastaSeguro;
			nuevaCasilla = 76 + casillasDentroDePasillo;
			break;
		case 2:
			casillasHastaSeguro = 33 - casilla;
			casillasDentroDePasillo = dice - casillasHastaSeguro;
			nuevaCasilla = 84 + casillasDentroDePasillo;
			break;
		case 3:
			casillasHastaSeguro = 51 - casilla;
			casillasDentroDePasillo = dice - casillasHastaSeguro;
			nuevaCasilla = 92 + casillasDentroDePasillo;
			break;
		};
		
		//currentPartida.getTablero().getCasillero().getCasillas().get(piezaSelec.getCasilla()).getPiezas().get(0).setCasilla(piezaSelec.getCasilla() + dice);
		piezaSelec.setCasilla(nuevaCasilla);
		currentPartida.getTablero().getCasillero().getCasillas().get(nuevaCasilla).addPiezaToCasilla(piezaSelec);
		//currentPartida.getTablero().getCasillero().getCasillas().get(casilla).getPiezas().remove(0);
		
		State newState = new State("enter_final_corridor");
		newState.setPartida(currentPartida);
		newState.setPieza(piezaSelec);


		double x = piezaSelec.getRecorrido() * 0.16;
		double y = Math.abs(x - 7);
		newState.setRating(y);
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	
	//si 63 < recorrido < 74
	{
		boolean isApplicable = false;
		Partida currentPartida = state.getPartida();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1);//la pieza que se va a mover
		//int casilla = piezaSelec.getCasilla() + dice;
		
		//si con el movimiento entramos en el pasillo --> si 63 < recorrido < 74
		int recorrido = piezaSelec.getRecorrido();
		int recorridoMasDado = recorrido + dice;
		if((recorridoMasDado > 63) && (recorridoMasDado < 74))
		{
			isApplicable = true;
		}
		
		/*switch (piezaSelec.getColor())
		{
		case 0:		
			if((casilla >= 69) && (casilla <= 76))
			{
				isApplicable = true;
			}
			break;
		case 1:
			if((casilla >= 77) && (casilla <= 84))
			{
				isApplicable = true;
			}
			break;
		case 2:
			if((casilla >= 85) && (casilla <= 92))
			{
				isApplicable = true;
			}
			break;
		case 3:
			if((casilla >= 93) && (casilla <= 100))
			{
				isApplicable = true;
			}
			break;
		default:
				isApplicable = false;
		};*/
		return isApplicable;
	}

}
