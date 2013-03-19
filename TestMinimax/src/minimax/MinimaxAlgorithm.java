package minimax;

import java.util.ArrayList;
import java.util.List;

import formulation.Action;
import formulation.Problem;
import formulation.State;

public class MinimaxAlgorithm {
	
	private static MinimaxAlgorithm instance;
	
	private List<State> generatedStates = new ArrayList<State>();
	private List<Node> successorFinalNodes = new ArrayList<Node>();
	private List<State> expandedStates = new ArrayList<State>();
	
	public static MinimaxAlgorithm getInstance()
	{
		if (instance == null) {
			instance = new MinimaxAlgorithm();
		}
		
		return instance;
	}
	
	
	/*HAY QUE PASAR EL PROBLEMA PARA COGER EL ESTADO INICIAL Y VER SI ES ESTADO FINAL, SINO NO PODEMOS
	 * COMPROBAR SI ES ESTADO FINAL PORQUE LA CLASE STATE NO TIENE LA FUNCION
	*/
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
	public Node Minimax(Problem problem, int dice, Node node)
	{		
		//String action = null;
		Node successor = null;
		int minimaxValue = MaxValue(problem, dice, node);
		boolean bestSuccessorFound = false;
		
		List<Node> successors = new ArrayList<Node>();
		for (int i = 0; i < successorFinalNodes.size(); i++)
		{
			if(successorFinalNodes.get(i) != null)
			{
				successors.add(successorFinalNodes.get(i));
				//System.out.print(successorFinalNodes.get(i).getDepth() + ", ");
			}
		}
		
		/*for (int z = 0; z < successorFinalNodes.size(); z++)
		{
			switch (successorFinalNodes.get(z).getDepth())
			{
			case 0:
				System.out.println(successorFinalNodes.get(z).getState().getRating());
				break;
			case 1:
				System.out.println("--" + successorFinalNodes.get(z).getState().getRating());
				break;
			case 2:
				System.out.println("----" + successorFinalNodes.get(z).getState().getRating());
				break;
			case 3:
				System.out.println("----" + successorFinalNodes.get(z).getState().getRating());
				break;
			}
		}*/
		
		while (!bestSuccessorFound)
		{
			//sucesor = estado con cada pieza del jugador
			//sucesor = next state's successor
			for(int i = 0; i < successors.size(); i++)
			{
				if (successors.get(i).getState().getRating() == minimaxValue)
				//if (MinimaxValue(problem, successors.get(i), dice) == minimaxValue)
				{
					bestSuccessorFound = true;
					//action = successors.get(i).getAction();
					successor = successors.get(i);
				}
			}
		}
		return successor;
	}
	
	public int UtilytiValue(State state)
	{
		//winner -> 10
		//loser -> -10
		if (state.getPlayer() == 0)
		{
			return 10;
		}
		else if (state.getPlayer() == 1)
		{
			return -10;
		}
		else
		{
			return 0;
		}
	}
	
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
	public int MaxValue(Problem problem, int dice, Node node)
	{		
		int parentValue = 0;
		if(node.getParent() != null)
		{
			parentValue = node.getParent().getState().getRating();
		}
		
		
		int minimaxValue = 0;
		if (problem.isFinalState(problem.getCurrentState()))
		{
			minimaxValue = UtilytiValue(problem.getCurrentState());
			return minimaxValue;
		}
		else
		{
			if (node.getDepth() < 3)
			{
				List<Node> successors = this.expand(problem, dice, node);
				//minimaxValue = -100;
				//System.out.println("successors' size: " + successors.size());
				for (int i = 0; i < successors.size(); i++)
				{
					Node successor = successors.get(i);
					//minimaxValue = MAX(minimaxValue, MinValue(problem, dice, successor));
					int minValue = MinValue(problem, dice, successor);
					//si el valor del sucesor es mayor que el valor que ya tiene se actualiza
					minimaxValue = minValue;
					if (parentValue > minValue)
					{
						minimaxValue = parentValue;
					}
					successor.getState().setRating(minimaxValue);
				}
				return minimaxValue;
			}
			else
			{
				return node.getState().getRating();
			}
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
			minimax-value = MIN(minimax-value, MAX-VALUE(successor)) //se saca el valor para el jugador min
			assign minimax-value to state
			return minimax-value*/
	public int MinValue(Problem problem, int dice, Node node)
	{		
		int parentValue = 0;
		if(node.getParent() != null)
		{
			parentValue = node.getParent().getState().getRating();
		}
		
		int minimaxValue = 0;
		if (problem.isFinalState(problem.getCurrentState()))
		{
			minimaxValue = UtilytiValue(problem.getCurrentState());
			return minimaxValue;
		}
		else
		{
			if (node.getDepth() < 3)
			{
				List<Node> successors = this.expand(problem, dice, node);
				minimaxValue = +100;
				for (int i = 0; i < successors.size() ; i++)
				{
					Node successor = successors.get(i);
					//minimaxValue = MIN(minimaxValue, MaxValue(problem, dice, successor));
					int maxValue = MaxValue(problem, dice, successor);
					minimaxValue = maxValue;
					if (maxValue < parentValue)
					{
						minimaxValue = maxValue;
					}
					successor.getState().setRating(minimaxValue);
				}
				return minimaxValue;
			}
			else //cuando llega al final de los successors salta aqui directamente. 
			{
				return node.getState().getRating(); //node llega con rating a 0
			}
			
		}
	}	
	
	public int MinimaxValue(Problem problem, Node node, int dice)
	{
		int minimaxValue = 0;
		if (problem.isFinalState(problem.getCurrentState()))
		{
			minimaxValue = this.UtilytiValue(problem.getCurrentState());
		}
		else if (problem.getCurrentState().getPlayer() == 0)
		{
			minimaxValue = MaxValue(problem, dice, node);
		}
		else if(problem.getCurrentState().getPlayer() == 1)
		{
			minimaxValue = MinValue(problem, dice, node);
		}
		return minimaxValue;
	}
	
	protected List<Node> expand(Problem problem, int dice, Node node)
	//Node node, Problem problem, List<State> generatedStates, List<State> expandedStates
	{
		List<Node> successorNodes = new ArrayList<Node>();
		Node successorNode = null;
		State currentState = null;
		State successorState = null;
		//Node node = new Node(problem.getCurrentState());

		//If problem isn't null
		if (problem != null) {
			currentState = problem.getCurrentState();
			//Remove current state from the list of generated states.
			generatedStates.remove(currentState);
			//Insert current state to the list of generated states.
			expandedStates.add(currentState);
			//If the state is not null
			if (currentState != null) {
				//Go over the list of problem operators
				//System.out.println("problem.action: " + problem.getActions().size());
				for (Action action : problem.getActions()) {
					//Apply the operator to the current state
					successorState = action.apply(currentState, dice);
					//If the operator has been successfully applied and the resulting successor
					//state hadn't been previously generated nor expanded
					if (successorState != null) {
							//&& !expandedStates.contains(successorState)) {
						//make a new node to contain the new successor state
						successorNode = new Node(successorState);
						successorNode.setAction(action.getName());
						successorNode.setParent(node);
						successorNode.setDepth(node.getDepth() + 1);

						System.out.println(successorNode.getDepth() + ": " + successorNode.getState().getRating());
						//add the newly created node to the list of successor nodes.
						successorNodes.add(successorNode);
						//Insert current successor State to the list of generated states
						generatedStates.add(successorState);	
						successorFinalNodes.add(successorNode);
						//System.out.print(successorNode.getDepth() + ", ");
					}
				}
			}
		}
		
		return successorNodes;		
	}

}
