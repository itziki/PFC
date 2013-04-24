package minimax;

import java.util.ArrayList;
import java.util.List;

import parchis.Partida;

import formulation.Action;
import formulation.Problem;
import formulation.State;

public class MinimaxAlgorithm {
	
	private static MinimaxAlgorithm instance;
	
	private List<State> generatedStates = new ArrayList<State>();
	private List<Node> successorFinalNodes = null;
	private List<State> expandedStates = new ArrayList<State>();
	private int minMinimaxValue;
	private int maxMinimaxValue;
	
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
		System.out.println("minimax");
		//String action = null;
		Node successor = null;
		
		minMinimaxValue = +100;
		maxMinimaxValue = -100;
		
		successorFinalNodes = new ArrayList<Node>();
		successorFinalNodes.add(node);
		int minimaxValue = MaxValue(problem, dice, node);
		boolean bestSuccessorFound = false;
		
		List<Node> successors = new ArrayList<Node>();
		for (int i = 0; i < successorFinalNodes.size(); i++)
		{

			//System.out.println(successorFinalNodes.get(i).getDepth() + ": " + successorFinalNodes.get(i).getState().getRating());
			if(successorFinalNodes.get(i) != null)
			{
				successors.add(successorFinalNodes.get(i));
				//System.out.print(successorFinalNodes.get(i).getDepth() + ", ");
			}
		}
		
		//System.out.println(successorFinalNodes.size());
	/*	String level0 = "     ";
		String level1 = "   ";
		String level2 = " ";
		String level3 = "";
		for (int z = 0; z < successorFinalNodes.size(); z++)
		{
			//System.out.println(successorFinalNodes.get(z).getAction() + " " + successorFinalNodes.get(z).getDepth() + ": " + successorFinalNodes.get(z).getState().getRating());
			//System.out.println(successorFinalNodes.get(z).getAction() + " " + successorFinalNodes.get(z).getParent().getDepth() + "->" + successorFinalNodes.get(z).getDepth() + ": " + successorFinalNodes.get(z).getState().getRating());
			switch (successorFinalNodes.get(z).getDepth())
			{
			case 0:
				level0 = level0 + String.valueOf(successorFinalNodes.get(z).getState().getRating());
				//System.out.println(successorFinalNodes.get(z).getState().getRating());
				break;
			case 1:
				level1 = level1 + successorFinalNodes.get(z).getState().getRating() + "   ";
				//System.out.println("--" + successorFinalNodes.get(z).getState().getRating());
				break;
			case 2:
				level2 = level2 + successorFinalNodes.get(z).getState().getRating() + "   ";
				//System.out.println("----" + successorFinalNodes.get(z).getState().getRating());
				break;
			case 3:
				level3 = level3 + successorFinalNodes.get(z).getState().getRating() + " ";
				break;
			}
			
		}
		System.out.println(level0);
		System.out.println(level1);
		System.out.println(level2);
		System.out.println(level3);
		*/
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

		System.out.println("maxvalue");
		int parentValue = 0;
		if(node.getParent() != null)
		{
			parentValue = node.getParent().getState().getRating();
		}
		
		
		int minimaxValue = 0;
		if (problem.isFinalState(node.getState()))
		{
			minimaxValue = UtilytiValue(node.getState());
			return minimaxValue;
		}
		else
		{
			if (node.getDepth() < 1/*3*/)//2
			{
				List<Node> successors = this.expand(problem, dice, node);
				//minimaxValue = -100;
				//System.out.println("successors' size: " + successors.size());
				for (int i = 0; i < successors.size(); i++)
				{
					Node successor = successors.get(i);
					//minimaxValue = MAX(minimaxValue, MinValue(problem, dice, successor));
					int minValue = MinValue(problem, dice, successor);
					//System.out.println(successor.getDepth() + ": " + minValue);
					//si el valor del sucesor es mayor que el valor que ya tiene se actualiza
					minimaxValue = node.getState().getRating();
					if (minimaxValue < minValue)
					{
						minimaxValue = minValue;
					}
					node.getState().setRating(minimaxValue);
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

		//System.out.println("minvalue");
		int parentValue = 0;
		if(node.getParent() != null)
		{
			parentValue = node.getParent().getState().getRating();
		}
		
		int minimaxValue = 0;
		if (problem.isFinalState(node.getState()))
		{
			minimaxValue = UtilytiValue(node.getState());
			return minimaxValue;
		}
		else
		{
			if (node.getDepth() < 0/*4*/) //3
			{
				List<Node> successors = this.expand(problem, dice, node);
				minimaxValue = +100;
				for (int i = 0; i < successors.size() ; i++)
				{
					Node successor = successors.get(i);
					//minimaxValue = MIN(minimaxValue, MaxValue(problem, dice, successor));
					int maxValue = MaxValue(problem, dice, successor);
					minimaxValue = node.getState().getRating();
					if (maxValue < minimaxValue)//aqui habría que borrar el valor que tenga el nodo la primera vez que se pasa
					{
						minimaxValue = maxValue;
					}
					node.getState().setRating(minimaxValue);
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

		System.out.println("expand");
		System.out.println(problem.getCurrentState().getPlayer());
		List<Node> successorNodes = new ArrayList<Node>();
		Node successorNode = null;
		State currentState = null;
		State successorState = null;
		//Node node = new Node(problem.getCurrentState());

		//If problem isn't null
		if (problem != null) {
			currentState = node.getState();
			//Remove current state from the list of generated states.
			//generatedStates.remove(currentState);
			//Insert current state to the list of generated states.
			expandedStates.add(currentState);
			//If the state is not null
			if (currentState != null) {
				//Go over the list of problem operators
				//System.out.println("problem.action: " + problem.getActions().size());
				for (Action action : problem.getActions()) {
					//Apply the operator to the current state
					System.out.println(action.getName());
					State stateToBeExpanded = currentState.clone("clonado");
					successorState = action.apply(stateToBeExpanded, dice);
					//If the operator has been successfully applied and the resulting successor
					//state hadn't been previously generated nor expanded
					if (successorState != null) {
							//&& !expandedStates.contains(successorState)) {
						//make a new node to contain the new successor state
						successorNode = new Node(successorState);
						successorNode.setAction(action.getName());
						successorNode.setParent(node);
						successorNode.setDepth(node.getDepth() + 1);
						/*if (successorNode.getDepth() < 2) //HARDCODED!!!!
						{
							successorNode.getState().setRating(100);
						}*/
						//System.out.println(successorNode.getAction() + " " + successorNode.getParent().getDepth() + "->" + successorNode.getDepth() + ": " + successorNode.getState().getRating());
						//add the newly created node to the list of successor nodes.
						successorNodes.add(successorNode);
						//Insert current successor State to the list of generated states
						generatedStates.add(successorState);	
						successorFinalNodes.add(successorNode);
						State state = successorNode.getState();
						Partida partida = (Partida)state.getPartida();
						System.out.println(partida.getTablero().getCasillero().getPiezas().get(0).getCasilla());
						System.out.println(partida.getTablero().getCasillero().getPiezas().get(1).getCasilla());
						System.out.println(partida.getTablero().getCasillero().getPiezas().get(2).getCasilla());
						System.out.println(partida.getTablero().getCasillero().getPiezas().get(3).getCasilla());
						//System.out.println(successorNode.getDepth() + ": " + successorNode.getState().getRating());
						//System.out.print(successorNode.getDepth() + ", ");
					}
				}
			}
		}
		
		return successorNodes;		
	}

}
