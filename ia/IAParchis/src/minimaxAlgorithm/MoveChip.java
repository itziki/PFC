package minimaxAlgorithm;

import java.util.List;

import parchis.Casilla;
import parchis.Casillero;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class MoveChip extends Action {
	
	private int numeroFicha = 0;	
	
	public MoveChip(String name, int numeroFicha) {
		super(name);
		this.numeroFicha = numeroFicha;
	}

	@Override
	protected State effect(State state, int dice) {
		
		Partida currentPartida = (Partida)state.getPartida();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1);
		int nuevaCasilla = piezaSelec.getCasilla() + dice;
		Casillero casillero = currentPartida.getTablero().getCasillero();
		
		//La ficha se mueve hacia delante el número de casillas correspondiente

		piezaSelec.setRecorrido(piezaSelec.getRecorrido() + dice);
		piezaSelec.setCasilla(nuevaCasilla);
		casillero.getCasillas().get(nuevaCasilla).addPiezaToCasilla(piezaSelec);
		//casillero.getCasillas().get(piezaSelec.getCasilla()).getPiezas().remove(piezaSelec);
		currentPartida.getTablero().setCasillero(casillero); //el state cambiado, falta devolverlo
		
		State newState = new State("move_chip");
		newState.setPartida(currentPartida);
		newState.setPieza(piezaSelec);
		
		//generate rating
		/*double x = piezaSelec.getRecorrido() * 0.16;
		double y = Math.abs(x - 10);*/
		int recorrido = piezaSelec.getRecorrido();
		newState.setRating(20/recorrido);
		
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
		List<Casilla> casillas = casillero.getCasillas();
		List<Pieza> piezasJugador = currentPartida.getTablero().getCasillero().getPiezasJugador(currentPartida.getColorJugador());
		Pieza piezaSelec = piezasJugador.get(numeroFicha - 1); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla();
		
		
		//Si la ficha está fuera de casa
		if(casilla != 101) //la casilla 101 no existe, por lo que la ficha esta en casa sin salir aun
		{//Si la ficha no está en el pasillo final y Si la ficha no está en la casilla final	
			switch (piezaSelec.getColor())
			//miro si la ficha está en su pasillo
			{
			case 0:		
				if((casilla <= 69) && (casilla >= 1))
				{
					for (int i = casilla; i <= casilla + dice; i++)
					{
						//System.out.println(i);
						if (!(casillas.get(i).getPiezas().size() == 2))
						{
							isApplicable = true;
						}
						else
						{
							isApplicable = false;
						}
					}
				}
				break;
			case 1:
				if((casilla <= 77) && (casilla >= 1))
				{
					for (int i = casilla; i <= casilla + dice; i++)
					{
						//System.out.println(i);
						if (!(casillas.get(i).getPiezas().size() == 2))
						{
							isApplicable = true;
						}
						else
						{
							isApplicable = false;
						}
					}
				}
				break;
			case 2:
				if((casilla <= 85) && (casilla >= 1))
				{
					for (int i = casilla; i <= casilla + dice; i++)
					{
						//System.out.println(i);
						if (!(casillas.get(i).getPiezas().size() == 2))
						{
							isApplicable = true;
						}
						else
						{
							isApplicable = false;
						}
					}
				}
				break;
			case 3:
				if((casilla <= 93) && (casilla >= 1))
				{
					for (int i = casilla; i <= casilla + dice; i++)
					{
						//System.out.println(i);
						if (!(casillas.get(i).getPiezas().size() == 2))
						{
							isApplicable = true;
						}
						else
						{
							isApplicable = false;
						}
					}
				}
				break;
			default:
					isApplicable = false;
			};
		}
		/*/Si la ficha está fuera de casa
		if(piezaSelec.getCasilla() != 101) //la casilla 101 no existe, por lo que la ficha esta en casa sin salir aun
		{
			//isApplicable = true;
			//Si no hay barreras de otro color en la distancia a recorrer.
			for (int i = casilla; i <= casilla + dice; i++)
			{
				//System.out.println(i);
				if (!(casillas.get(i).getPiezas().size() == 2))
				{
					isApplicable = true;
				}
				else
				{
					isApplicable = false;
				}
			}
		}
		else
		{
			isApplicable = false;
		}*/
		
		//System.out.println(isApplicable+ ", " + casilla + ", " + piezaSelec.getColor());
		return isApplicable;
	}

}
