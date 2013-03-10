package minimax;

import java.util.ArrayList;
import java.util.List;

import formulation.Action;
import formulation.Problem;
import formulation.State;

public class MinimaxAlgorithm {
	
	private boolean isComputersTurn = false;
	private List<State> generatedStates = new ArrayList<State>();
	private List<State> expandedStates = new ArrayList<State>();
	
	
	public boolean isComputersTurn()
	{
		return isComputersTurn;
	}
	public void setComputersTurn(boolean isComputersTurn)
	{
		this.isComputersTurn = isComputersTurn;
	}

	
	/*HAY QUE PASAR EL PROBLEMA PARA COGER EL ESTADO INICIAL Y VER SI ES ESTADO FINAL, SINO NO PODEMOS
	 * COMPROBAR SI ES ESTADO FINAL PORQUE LA CLASE STATE NO TIENE LA FUNCION*/
	/*
	 * 
	IF Terminal-Test(state) THEN
		//It is MAX�s turn to move but game is over
		minimax-value = UtilityValue(state, MAX)
		return minimax-value
	ELSE
		minimax-value = -infinito
		FOR EACH successor of state DO
		minimax-value = MAX(minimax-value, MIN-VALUE(successor))
		assign minimax-value to state
		return minimax-value
	 * */
	
	public String Minimax(Problem problem, int dice, Node node)
	{		
		String action = null;
		int minimaxValue = MaxValue(problem, dice, node);
		boolean bestSuccessorFound = false;
		
		List<Node> successors = this.expand(problem, generatedStates, expandedStates, dice);
		
		while (!bestSuccessorFound)
		{
			//sucesor = estado con cada pieza del jugador
			//sucesor = next state's successor
			for(int i = 0; i < successors.size(); i++)
			{
				if (successors.get(i).getState().getValue() == minimaxValue)
				//if (MinimaxValue(problem, successors.get(i), dice) == minimaxValue)
				{
					bestSuccessorFound = true;
					action = successors.get(i).getAction();
				}
			}
		}
		return action;
	}
	
	public int UtilytiValue(State state)
	{
		return 0;
	}
	
	
	public int MaxValue(Problem problem, int dice, Node node)
	{		
		int minimaxValue = 0;
		if (problem.isFinalState(problem.getInitialState()))
		{
			minimaxValue = UtilytiValue(problem.getInitialState());
			return minimaxValue;
		}
		else
		{
			List<Node> successors = this.expand(problem, generatedStates, expandedStates, dice);
			minimaxValue = -100;
			for (int i = 0; i <= successors.size(); i++)
			{
				Node successor = successors.get(i);
				minimaxValue = MAX(minimaxValue, MinValue(problem, dice, successor));
				successor.getState().setValue(minimaxValue);
			}
			return minimaxValue;
		}
	}
	/*
	  	IF Terminal-Test(state) THEN
			//It is MIN�s turn to move but game is over
			minimax-value = UtilityValue(state, MAX)
			return minimax-value
		ELSE
			minimax-value = +infinito
			FOR EACH successor of state DO
			minimax-value = MIN(minimax-value, MAX-VALUE(successor)) //se saca el valor para el jugador min
			assign minimax-value to state
			return minimax-value*/
	public int MinValue(Problem problem, int dice, Node node)
	{		
		int minimaxValue = 0;
		if (problem.isFinalState(problem.getInitialState()))
		{
			minimaxValue = UtilytiValue(problem.getInitialState());
			return minimaxValue;
		}
		else
		{
			List<Node> successors = this.expand(problem, generatedStates, expandedStates, dice);
			minimaxValue = +100;
			for (int i = 0; i < successors.size() ; i++)
			{
				Node successor = successors.get(i);
				minimaxValue = MIN(minimaxValue, MaxValue(problem, dice, successor));
				successor.getState().setValue(minimaxValue);
			}
			return minimaxValue;
		}
	}
	
	/*
	  	minimax-value = MAX-VALUE(state)
		bestSuccessorFound = false
		WHILE ! bestSuccessorFound DO
			successor = next state�s successor
			IF MinimaxValue(successor) == minimax-value THEN
			bestSuccessorFound = true
			action = successor�s action
			return action
		*/
	
	
	public int MinimaxValue(Problem problem, Node node, int dice)
	{
		int minimaxValue = 0;
		if (problem.isFinalState(problem.getInitialState()))
		{
			minimaxValue = this.UtilytiValue(problem.getInitialState());
		}
		else if (!isComputersTurn)
		{
			minimaxValue = MaxValue(problem, dice, node);
		}
		else if(isComputersTurn)
		{
			minimaxValue = MinValue(problem, dice, node);
		}
		return minimaxValue;
	}
	
	protected List<Node> expand(Problem problem, List<State> generatedStates, List<State> expandedStates, int dice)
	//Node node, Problem problem, List<State> generatedStates, List<State> expandedStates
	{
		List<Node> successorNodes = new ArrayList<Node>();
		Node successorNode = null;
		State currentState = null;
		State successorState = null;
		Node node = new Node(problem.getInitialState());

		//If problem isn't null
		if (problem != null) {
			//The initial state is going to change after every decision
			currentState = problem.getInitialState();
			//Remove current state from the list of generated states.
			generatedStates.remove(currentState);
			//Insert current state to the list of generated states.
			expandedStates.add(currentState);
			//If the state is not null
			if (currentState != null) {
				//Go over the list of problem operators
				for (Action action : problem.getActions()) {
					//Apply the operator to the current state
					successorState = action.apply(currentState, dice);
					//If the operator has been successfully applied and the resulting successor
					//state hadn't been previously generated nor expanded
					if (successorState != null && 
					    !generatedStates.contains(successorState) &&
					    !expandedStates.contains(successorState)) {
						//make a new node to contain the new successor state
						successorNode = new Node(successorState);
						successorNode.setAction(action.getName());
						successorNode.setParent(node);
						successorNode.setDepth(node.getDepth() + 1);
						//add the newly created node to the list of successor nodes.
						successorNodes.add(successorNode);
						//Insert current successor State to the list of generated states
						generatedStates.add(successorState);						
					}
				}
			}
		}
		
		return successorNodes;		
	}

}
