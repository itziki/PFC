package minimaxAlgorithm;

import java.util.List;

import parchis.Casilla;
import parchis.Casillero;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class MakeABarrier extends Action {
	private int numeroFicha = 0;

	public MakeABarrier(String name, int numeroFicha) {
		super(name);
		this.numeroFicha = numeroFicha;
	}

	@Override
	protected State effect(State state, int dice) {
		
		Partida currentPartida = (Partida)state.getPartida();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1);
		int casilla = piezaSelec.getCasilla();
		
		//Las fichas que no sean del color de la barrera no pueden pasar -> se meten las dos fichas en la casilla
		currentPartida.getTablero().getCasillero().getCasillas().get(piezaSelec.getCasilla()).addPiezaToCasilla(piezaSelec);
		piezaSelec.setCasilla(casilla + dice);
		piezaSelec.setRecorrido(piezaSelec.getRecorrido() + dice);
		
		State newState = new State("make_a_barrier");
		newState.setPartida(currentPartida);
		newState.setPieza(piezaSelec);
		
		/*double x = piezaSelec.getRecorrido() * 0.16;
		double y = Math.abs(x - 5);*/
		newState.setRating(3);	
		
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
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla();
		
		
		int numeroNuevaCasilla = casilla + dice;
		//System.out.println(numeroNuevaCasilla);		
		
		//Si la ficha está fuera de casa
		if((casilla > 0) && (casilla < 100))
		{
			Casilla nuevaCasilla = casillero.getCasillas().get(numeroNuevaCasilla);
			//System.out.println(nuevaCasilla.getPiezas().size());
			//Si la ficha no está en la casilla final
			switch (piezaSelec.getColor())
			{
			case 0:		
				if(casilla != 76)
				{
					//Si en la última casilla del movimiento que toque hay SÓLO una ficha de nuestro color
					
					if(nuevaCasilla.getPiezas().size() == 1) //sólo una ficha
					{
						if(nuevaCasilla.getPiezas().get(0).getColor() == currentPartida.getColorJugador()) //es de nuestro color
						{
							isApplicable = true;
						}
					}
				}
				break;
			case 1:
				if(casilla != 84)
				{
					if(nuevaCasilla.getPiezas().size() == 1) //sólo una ficha
					{
						if(nuevaCasilla.getPiezas().get(0).getColor() == currentPartida.getColorJugador()) //es de nuestro color
						{
							isApplicable = true;
						}
					}
				}
				break;
			case 2:
				if(casilla != 93)
				{
					if(nuevaCasilla.getPiezas().size() == 1) //sólo una ficha
					{
						if(nuevaCasilla.getPiezas().get(0).getColor() == currentPartida.getColorJugador()) //es de nuestro color
						{
							isApplicable = true;
						}
					}
				}
				break;
			case 3:
				if(casilla != 100)
				{
					if(nuevaCasilla.getPiezas().size() == 1) //sólo una ficha
					{
						if(nuevaCasilla.getPiezas().get(0).getColor() == currentPartida.getColorJugador()) //es de nuestro color
						{
							isApplicable = true;
						}
					}
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
		//System.out.println(isApplicable);
		
		return isApplicable;
	}

}
