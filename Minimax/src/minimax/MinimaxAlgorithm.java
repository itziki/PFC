package minimax;

import java.util.ArrayList;
import java.util.List;

import formulation.Action;
import formulation.Problem;
import formulation.State;

public class MinimaxAlgorithm {
	
	/*HAY QUE PASAR EL PROBLEMA PARA COGER EL ESTADO INICIAL Y VER SI ES ESTADO FINAL, SINO NO PODEMOS
	 * COMPROBAR SI ES ESTADO FINAL PORQUE LA CLASE STATE NO TIENE LA FUNCION*/
	
	/*
	 * 
	IF Terminal-Test(state) THEN
		//It is MAX’s turn to move but game is over
		minimax-value = UtilityValue(state, MAX)
		return minimax-value
	ELSE
		minimax-value = -infinito
		FOR EACH successor of state DO
		minimax-value = MAX(minimax-value, MIN-VALUE(successor))
		assign minimax-value to state
		return minimax-value
	 * */
	public int UtilytiValue(State state, String player)
	{
		return 0;
	}
	
	
	public int MaxValue(Problem problem)
	{
		int minimaxValue = 0;
		List<Node> successors = this.expand(node, problem, generatedStates, expandedStates, dice);
		if (problem.isFinalState(problem.getInitialState()))
		{
			minimaxValue = UtilytiValue(problem.getInitialState(), "MAX");
			return minimaxValue;
		}
		else
		{
			minimaxValue = -100;
			for (int i = 0; i <= successors.size(); i++)
			{
				Node successor = successors.get(i);
				minimaxValue = MAX(minimaxValue, MinValue(successor));
			}
			//asign valorMinimax al estado
			return minimaxValue;
		}
	}
	/*
	  	IF Terminal-Test(state) THEN
			//It is MIN’s turn to move but game is over
			minimax-value = UtilityValue(state, MAX)
			return minimax-value
		ELSE
			minimax-value = +infinito
			FOR EACH successor of state DO
			minimax-value = MIN(minimax-value, MAX-VALUE(successor))
			assign minimax-value to state
			return minimax-value*/
	public int MinValue(Problem problem)
	{
		int minimaxValue = 0;
		if (problem.isFinalState(problem.getInitialState()))
		{
			minimaxValue = UtilytiValue(problem.getInitialState(), "MIN");
			return minimaxValue;
		}
		else
		{
			minimaxValue = +100;
			for (int i = 0; /*numero piezas*/i<10; i++)
			{
				minimaxValue = MIN(minimaxValue, MaxValue(successor));
			}
			//asign valorMinimax al estado
			return minimaxValue;
		}
	}
	
	/*
	  	minimax-value = MAX-VALUE(state)
		bestSuccessorFound = false
		WHILE ! bestSuccessorFound DO
			successor = next state’s successor
			IF MinimaxValue(successor) == minimax-value THEN
			bestSuccessorFound = true
			action = successor’s action
			return action
		*/
	public Action Minimax(Problem problem)
	{
		Action action;
		int minimaxValue = MaxValue(problem);
		boolean bestSuccessorFound = false;
		while (!bestSuccessorFound)
		{
			//sucesor = estado con cada pieza del jugador
			//sucesor = next state's successor
			if (MinimaxValue(successor) == minimaxValue)
			{
				bestSuccessorFound = true;
				action = null;
			}
		}
		return action;
	}
	
	protected List<Node> expand(Node node, Problem problem, List<State> generatedStates, List<State> expandedStates, int dice)
	{
		List<Node> successorNodes = new ArrayList<Node>();
		Node successorNode = null;
		State currentState = null;
		State successorState = null;

		//If neither node or problem are null
		if (node != null && problem != null) {
			//Get the node's state.
			currentState = node.getState();
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
