package minimaxAlgorithm;

import java.util.ArrayList;
import java.util.List;

import parchis.Partida;
import parchis.Pieza;
import parchis.Tablero;

import minimax.MinimaxAlgorithm;
import minimax.Node;
import formulation.Action;
import formulation.Problem;
import formulation.State;

public class ParchisProblem extends Problem {
	private static ParchisProblem instance = null;
	
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
	
	public static ParchisProblem getInstance(int playerNumber, List<Boolean> cpu)
	{
		if (instance == null) {
			instance = new ParchisProblem(playerNumber, cpu);
		}
		
		return instance;
	}
	
	private ParchisProblem(int playerNumber, List<Boolean> cpu)
	{
		this.createInitialState(playerNumber, cpu);
		this.createFinalState(playerNumber, cpu);
	}
	
	public void createInitialState(int playerNumber, List<Boolean> cpu)
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
					for(int k = 0; k < 4; k++) //4
					{
						piezas.add(new Pieza(0, 0, 101));
					}
					break;
				case 1:
					for(int k = 0; k < 4; k++) //4
					{
						piezas.add(new Pieza(1, 0, 101));
					}
					break;
				case 2:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(2, 0, 101));
					}
					break;
				case 3:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(3, 0, 101));
					}
					break;
			};
		}
		
		Tablero tablero = new Tablero();
		//tablero.setCasillero(casillero);
		tablero.iniciarTablero(playerNumber, cpu);
		
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
	
	public void createFinalState(int playerNumber, List<Boolean> cpu)
	{				
		List<Pieza> piezas = new ArrayList<Pieza>();
		for(int i = 0; i < playerNumber; i++)
		{
			switch(i)
			{
				case 0:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(0, 0, 76));
					}
					break;
				case 1:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(1, 0, 84));
					}
					break;
				case 2:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(2, 0, 92));
					}
					break;
				case 3:
					for(int k = 0; k < 4; k++)
					{
						piezas.add(new Pieza(3, 0, 100));
					}
					break;
			};
		}
				
		Tablero tablero = new Tablero();
		//tablero.setCasillero(casillero);
		tablero.iniciarTablero(playerNumber, cpu);
		
		tablero.getCasillero().setPiezas(piezas); //metemos las piezas en la variable de todas las piezas.
		//casillero.iniciarCasillero(); //iniciamos el casillero con las casillas seguras
		
		Partida partida = new Partida(tablero, 0);
		
		State finalState = new State("finalState");
		finalState.setPartida(partida);
		this.addFinalState(finalState);
	}
	
	public State getBestMovement()
	{
		int player = this.getCurrentState().getPlayer();
		//MIN is playing
		//if(this.getCurrentState().getPlayer() == 1)
		{
			MinimaxAlgorithm minimaxAlgorithm = MinimaxAlgorithm.getInstance();
			//System.out.println(this.getCurrentState().getPartida().getTablero().getCasillero().getPiezas().size());
			Node node = new Node(this.getCurrentState());
			//System.out.println("llamamos minimax");
			int dado = this.getCurrentState().getPartida().getTablero().getDado().throwDice();
			System.out.println(player + " --> " +"dado: " + dado);
			Node bestMovement = minimaxAlgorithm.Minimax(this, dado, node);
			//System.out.println(bestMovement.getState().getRating());
			State returnedState = null;
			if(bestMovement != null)
			{
				returnedState = bestMovement.getState();
				System.out.println(player + " --> " + dado + ", "+bestMovement.getState().getRating() + ", " + bestMovement.getAction());
			}
			else
			{
				//System.out.println(player + " --> " +"dado: " + dado);
			}
			return returnedState;
			//this.setCurrentState(bestMovement.getState());
			//System.out.println("Selected node's value 1: " + bestMovement.getState().getRating());
		}
		//MAX is playing
		//change the player
	/*	if(player == (playerNumber - 1))
		{
			System.out.println("if 1");
			this.getCurrentState().setPlayer(0);
		}
		else
		{
			System.out.println("if 2");
			this.getCurrentState().setPlayer(player + 1);
		}*/
	}

	protected void createActions()
	{
		final List<Action> actionList = new ArrayList<Action>();
		
		//acciones que funcionan
		
		actionList.add(new GetOutOfHome("GetOutOfHome_1", 1));
		actionList.add(new GetOutOfHome("GetOutOfHome_2", 2));
		actionList.add(new GetOutOfHome("GetOutOfHome_3", 3));
		actionList.add(new GetOutOfHome("GetOutOfHome_4", 4));
		
		actionList.add(new MoveChip("MoveChip_1", 1));
		actionList.add(new MoveChip("MoveChip_2", 2));
		actionList.add(new MoveChip("MoveChip_3", 3));
		actionList.add(new MoveChip("MoveChip_4", 4));
		
		/*
		actionList.add(new DestroyABarrier("DestroyABarrier_1", 1));
		actionList.add(new DestroyABarrier("DestroyABarrier_2", 2));
		actionList.add(new DestroyABarrier("DestroyABarrier_3", 3));
		actionList.add(new DestroyABarrier("DestroyABarrier_4", 4));
		
		actionList.add(new EatChip("EatChip_1", 1));
		actionList.add(new EatChip("EatChip_2", 2));
		actionList.add(new EatChip("EatChip_3", 3));
		actionList.add(new EatChip("EatChip_4", 4));
		
		actionList.add(new EnterFinalCorridor("EnterFinalCorridor_1", 1));
		actionList.add(new EnterFinalCorridor("EnterFinalCorridor_2", 2));
		actionList.add(new EnterFinalCorridor("EnterFinalCorridor_3", 3));
		actionList.add(new EnterFinalCorridor("EnterFinalCorridor_4", 4));
		
		actionList.add(new EnterFinalSquare("EnterFinalSquare_1", 1));
		actionList.add(new EnterFinalSquare("EnterFinalSquare_2", 2));
		actionList.add(new EnterFinalSquare("EnterFinalSquare_3", 3));
		actionList.add(new EnterFinalSquare("EnterFinalSquare_4", 4));
		
		actionList.add(new MakeABarrier("MakeABarrier_1", 1));
		actionList.add(new MakeABarrier("MakeABarrier_2", 2));
		actionList.add(new MakeABarrier("MakeABarrier_3", 3));
		actionList.add(new MakeABarrier("MakeABarrier_4", 4));
		
		actionList.add(new MoveChipInCorridor("MoveChipInCorridor_1", 1));
		actionList.add(new MoveChipInCorridor("MoveChipInCorridor_2", 2));
		actionList.add(new MoveChipInCorridor("MoveChipInCorridor_3", 3));
		actionList.add(new MoveChipInCorridor("MoveChipInCorridor_4", 4));
		
		actionList.add(new ReturnChipToHome("ReturnChipToHome_1", 1));
		actionList.add(new ReturnChipToHome("ReturnChipToHome_2", 2));
		actionList.add(new ReturnChipToHome("ReturnChipToHome_3", 3));
		actionList.add(new ReturnChipToHome("ReturnChipToHome_4", 4));
		*/
		
		this.addActions(actionList);		
	}

}
