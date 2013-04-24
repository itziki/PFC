package minimaxAlgorithm;

import java.util.ArrayList;
import java.util.List;

import parchis.Casillero;
import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;

import minimax.MinimaxAlgorithm;
import minimax.Node;
import formulation.Action;
import formulation.Problem;
import formulation.State;

public class ParchisProblem extends Problem {
	
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
	
	public ParchisProblem(int playerNumber)
	{
		this.createInitialState(playerNumber);
		this.createFinalState(playerNumber);
	}
	
	public void createInitialState(int playerNumber)
	{
		//playerNumber variable is the amount of players that are playing. 2 <= playerNumber <= 4
		/*
		 player 1 => Amarillo (0)
		 player 2 => Azul (1)
		 player 3 => Rojo (2)
		 player 4 => Verde (3)
		 */
		List<Pieza> piezas = new ArrayList<Pieza>();
		for(int i = 0; i < playerNumber; i++)
		{
			switch(i)
			{
				case 0:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(0, 0, 104));
					}
					break;
				case 1:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(1, 0, 104));
					}
					break;
				case 2:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(2, 0, 104));
					}
					break;
				case 3:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(3, 0, 104));
					}
					break;
			};
		}
		
		Tablero tablero = new Tablero();
		//tablero.setCasillero(casillero);
		tablero.iniciarTablero(playerNumber);
		
		tablero.getCasillero().setPiezas(piezas); //metemos las piezas en la variable de todas las piezas.
		//casillero.iniciarCasillero(); //iniciamos el casillero con las casillas seguras
		
		Partida partida = new Partida(tablero, 0);
		State initialState = new State("initialState");
		initialState.setPartida(partida);
		initialState.setPieza(piezas.get(0));
		
		initialState.setPlayer(0);
		
		this.addInitialState(initialState);
		this.setCurrentState(initialState);
	}
	
	public void createFinalState(int playerNumber)
	{				
		List<Pieza> piezas = new ArrayList<Pieza>();
		for(int i = 0; i < playerNumber; i++)
		{
			switch(i)
			{
				case 0:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(0, 0, 79));
					}
					break;
				case 1:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(1, 0, 87));
					}
					break;
				case 2:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(2, 0, 95));
					}
					break;
				case 3:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(3, 0, 103));
					}
					break;
			};
		}
				
		Tablero tablero = new Tablero();
		//tablero.setCasillero(casillero);
		tablero.iniciarTablero(playerNumber);
		
		tablero.getCasillero().setPiezas(piezas); //metemos las piezas en la variable de todas las piezas.
		//casillero.iniciarCasillero(); //iniciamos el casillero con las casillas seguras
		
		Partida partida = new Partida(tablero, 0);
		
		State finalState = new State("finalState");
		finalState.setPartida(partida);
		this.addFinalState(finalState);
	}
	
	public void getBestMovement(int playerNumber)
	{
		int player = this.getCurrentState().getPlayer();
		//MIN is playing
		if(this.getCurrentState().getPlayer() == 1)
		{
			MinimaxAlgorithm minimaxAlgorithm = MinimaxAlgorithm.getInstance();
			System.out.println(this.getCurrentState().getPartida().getTablero().getCasillero().getPiezas().size());
			Node node = new Node(this.getCurrentState().clone("player_" + player));
			System.out.println("llamamos minimax");
			Node bestMovement = minimaxAlgorithm.Minimax(this, 5, node);
			System.out.println(bestMovement.getState().getRating());
			this.setCurrentState(bestMovement.getState());
			//System.out.println("Selected node's value 1: " + bestMovement.getState().getRating());
		}
		//MAX is playing
		//change the player
		if(player == (playerNumber - 1))
		{
			System.out.println("if 1");
			this.getCurrentState().setPlayer(0);
		}
		else
		{
			System.out.println("if 2");
			this.getCurrentState().setPlayer(player + 1);
		}
	}

	protected void createActions()
	{
		final List<Action> actionList = new ArrayList<Action>();
		//actionList.add(new DestroyABarrier("DestroyABarrier"));
		//actionList.add(new EatChip("EatChip"));
		//actionList.add(new EnterFinalCorridor("EnterFinalCorridor"));
		//actionList.add(new EnterFinalSquare("EnterFinalSquare"));
		actionList.add(new GetOutOfHome("GetOutOfHome_1", 1));
		actionList.add(new GetOutOfHome("GetOutOfHome_2", 2));
		actionList.add(new GetOutOfHome("GetOutOfHome_3", 3));
		actionList.add(new GetOutOfHome("GetOutOfHome_4", 4));
		//No tiene sentido  //actionList.add(new JumpABarrier("JumpABarrier"));
		//actionList.add(new MakeABarrier("MakeABarrier"));
		//actionList.add(new MoveChip("MoveChip"));
		//actionList.add(new MoveChipInCorridor("MoveChipInCorridor"));
		//actionList.add(new ReturnChipToHome("ReturnChipToHome"));
		this.addActions(actionList);		
	}

}
