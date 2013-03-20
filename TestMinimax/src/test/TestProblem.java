package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import minimax.MinimaxAlgorithm;
import minimax.Node;

import formulation.Action;
import formulation.Problem;
import formulation.State;

public class TestProblem extends Problem {

	public TestProblem(int player) {
		State initialState = new State("initial state");
		initialState.setPlayer(player);
		this.addInitialState(initialState);
		this.createActions();
	}
	
	public void createInitialState()
	{
		State state = new State("Initial state");
		state.setRating(0);
		this.addInitialState(state);
	}
	
	protected void createActions()
	{
		List<Action> actions = new ArrayList<Action>();
		actions.add(new TestAction("Random1"));
		actions.add(new TestAction("Random2"));
		//actions.add(new TestAction("GenerateRandomNumber3"));
		this.addActions(actions);
	}
	
	public int selectMovement()
	{
		//MIN is playing
		if(this.getCurrentState().getPlayer() == 1)
		{
			MinimaxAlgorithm minimaxAlgorithm = MinimaxAlgorithm.getInstance();
			Node node = new Node(this.getCurrentState());
			Node bestMovement = minimaxAlgorithm.Minimax(this, 9, node);
			System.out.println("Selected node's value 1: " + bestMovement.getState().getRating());
			return 0;
		}
		//MAX is playing
		else if (this.getCurrentState().getPlayer()== 0)
		{
			//MinimaxAlgorithm minimaxAlgorithm = MinimaxAlgorithm.getInstance();
			//Node node = new Node(this.getCurrentState());
			//Node bestMovement = minimaxAlgorithm.Minimax(this, 9, node);
			//System.out.println("Selected node's value 0: " + bestMovement.getState().getRating());
			//aqui debería ir todo el movimiento de las fichas.
			/*int inChar = 0;
		    System.out.println("Enter a Character:");
		    try {
		      inChar = System.in.read();
		      System.out.print("You entered ");
		      System.out.println(inChar);
		    }
		    catch (IOException e){
		      System.out.println("Error reading from user");
		    }*/
			return 1;
		}
		else //in case there are errors
		{
			return 2;
		}
	}

}
