package minimaxAlgorithm;

import java.util.List;

import parchis.Casilla;
import parchis.Casillero;
import parchis.Dado;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class EatChip extends Action {
	private int numeroFicha = 0;

	public EatChip(String name, int numeroFicha) {
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
		Casillero casillero = currentPartida.getTablero().getCasillero();
		
		//Se mueven 20 casillas con la ficha que se quiera
		currentPartida.getTablero().setDado(new Dado(20));
		
		//La ficha comida vuelve a casa
		Pieza fichaComida = casillero.getCasillas().get(nuevaCasilla).getPiezas().get(0);
		//fichaComida.setCasilla(101);
		casillero.getCasillas().get(nuevaCasilla).getPiezas().get(0).setCasilla(101);
		casillero.getCasillas().get(nuevaCasilla).getPiezas().get(0).setRecorrido(0);
		casillero.getCasillas().get(nuevaCasilla).getPiezas().remove(fichaComida);
		
		//System.out.println(currentPartida.getTablero().getCasillero().getCasillas().get(nuevaCasilla).getPiezas().size());
		//currentPartida.getTablero().getCasillero().getCasillas().get(piezaSelec.getCasilla() + dice).getPiezas().get(0).setCasilla(101);
		
		//la ficha se mueve a la casilla
		piezaSelec.setCasilla(nuevaCasilla);
		piezaSelec.setRecorrido(piezaSelec.getRecorrido() + dice);
		casillero.getCasillas().get(nuevaCasilla).addPiezaToCasilla(piezaSelec);
		currentPartida.getTablero().setCasillero(casillero);
		
		State newState = new State("eat_chip");
		newState.setPartida(currentPartida);
		
		//generate rating
		/*double x = piezaSelec.getRecorrido() * 0.16;
		double y = Math.abs(x - 8);*/
		newState.setRating(4);
		
		return newState;
	}

	@Override
	protected boolean isApplicable(State state, int dice)
	{
		
		boolean isApplicable = false;

		Partida currentPartida = (Partida)state.getPartida();
		Tablero tablero = currentPartida.getTablero();
		Casillero casillero = tablero.getCasillero();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla();
		
		//Si la ficha está fuera de casa y en el circuito
		if((casilla < 68) && (casilla > 0))
		{
			//Si en la última casilla del movimiento que toque hay una ficha de otro color distinto al nuestro y no está en seguro
			int numeroNuevaCasilla = casilla + dice;
			Casilla nuevaCasilla = casillero.getCasillas().get(numeroNuevaCasilla);
			//System.out.println(nuevaCasilla.getPiezas().size());
			if((nuevaCasilla.getPiezas().size() == 1) && (!nuevaCasilla.isEsSegura()))
			{
				//System.out.println("primer if");
				if(nuevaCasilla.getPiezas().get(0).getColor() != currentPartida.getColorJugador())
				{
					isApplicable = true;
				}
				else
				{
					isApplicable = false;
				}
			}	
		}
		
		return isApplicable;
	}

}
