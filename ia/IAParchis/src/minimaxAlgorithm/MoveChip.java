package minimaxAlgorithm;

import parchis.Casilla;
import parchis.Casillero;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;
import formulation.Action;
import formulation.State;

public class MoveChip extends Action {
	
	
	public MoveChip(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected State effect(State state, int dice) {
		//La ficha se mueve hacia delante el número de casillas correspondiente
		Partida currentPartida = (Partida)state.getPartida();
		Pieza piezaSelect = (Pieza)state.getPieza();
		int nuevaCasilla = piezaSelect.getCasilla() + dice;
		Casillero casillero = currentPartida.getTablero().getCasillero();
		casillero.getCasillas()[nuevaCasilla].addPiezaToCasilla(piezaSelect);
		currentPartida.getTablero().setCasillero(casillero); //el state cambiado, falta devolverlo
		State newState = new State(currentPartida);
		newState.setRating(1);
		
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
		Casilla[] casillas = casillero.getCasillas();
		Pieza piezaSelec = (Pieza)state.getPieza(); //la pieza que se va a mover
		int casilla = piezaSelec.getCasilla();
		
		//Si la ficha no está en el pasillo final y Si la ficha no está en la casilla final	
		switch (piezaSelec.getColor())
		//miro si la ficha está en su pasillo
		{
		case 0:		
			if(!(casilla >= 72 && casilla <= 79))
			{
				isApplicable = true;
			}
			break;
		case 1:
			if(!(casilla >= 80 && casilla <= 89))
			{
				isApplicable = true;
			}
			break;
		case 2:
			if(!(casilla >= 88 && casilla <= 95))
			{
				isApplicable = true;
			}
			break;
		case 3:
			if(!(casilla >= 93 && casilla <= 103))
			{
				isApplicable = true;
			}
			break;
		default:
				isApplicable = false;
		};
		
		//Si no hay barreras de otro color en la distancia a recorrer.
		for (int i = casilla; i <= casilla + dice; i++)
		{
			if (!(casillas[i].getPiezas().size() == 2))
			{
				isApplicable = true;
			}
			else
			{
				isApplicable = false;
			}
		}
		
		//Si la ficha está fuera de casa
		if(!(piezaSelec.getCasilla() == 104)) //la casilla 104 no existe, por lo que la ficha esta en casa sin salir aun
		{
			isApplicable = true;
		}
		else
		{
			isApplicable = false;
		}
		
		return isApplicable;
	}

}
