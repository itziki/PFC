package es.deusto.ingenieria.aike.search.blind;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import es.deusto.ingenieria.aike.formulation.Problem;
import es.deusto.ingenieria.aike.formulation.State;
import es.deusto.ingenieria.aike.search.Node;
import es.deusto.ingenieria.aike.search.SearchMethod;
import es.deusto.ingenieria.aike.search.log.SearchLog;

/**
 * This class defines the Depth First Search Method and generates a log of the search process.
 * It is defined according to the design pattern <b>Singleton</b>.
 */
public class DepthFSwithLog extends SearchMethod {

	/**
	 * In accordance with the pattern <b>Singleton</b>, 
	 * a single instance of the class will be created
	 */
	private static DepthFSwithLog instance;
	
	/**
	 * Constructor method is private in accordance with the pattern <b>Singleton</b>
	 */
	private DepthFSwithLog() {
	}
	
	/**
	 * In accordance with the pattern <b>Singleton</b> a class method invokes the constructor
	 * and guarantees one single instantiation of the class.
	 * @return DepthFSwithLog, the single instance of the class.
	 */
	public static DepthFSwithLog getInstance() {
		if (instance == null) {
			instance = new DepthFSwithLog();
		}
		
		return instance;
	}
	
	/**
	 * Carries out a search process from the initial state
	 * to the final state of the given problem.
	 * This method is defined according to the second version of the basic search algorithm
	 * which checks for repeated states (refer to the last algorithm studied in chapter 3).
	 * 
	 * @param problem
	 *            Problem to be solved by a search method.
	 * @param initialState
	 *            Problem's initial state. 
	 * @return Node
	 *         <ul>
	 *         <li>If a solution is found, Node contains the problem's final state</li>
	 *         <li>If the problem can't be solved, Node contains null.</li>
	 *         </ul>
	 */
	public Node search(Problem problem, State initialState) {
		//A stack is used to keep the nodes generated during the search process.
		Stack<Node> frontier = new Stack<Node>();
		//List of states generated during the search process. This is used to check for repeated states.
		List<State> generatedStates = new ArrayList<State>();
		//List of states expended during the search process. This is used to check for repeated states.
		List<State> expandedStates = new ArrayList<State>();
		//Stack's first node.
		Node firstNode = null;
		//successor nodes list.
		List<Node> successorNodes = null;
		//flag to signal whether a solution has been found or not.
		boolean solutionFound = false;
		
		//Define and initialize the search log.
		SearchLog searchLog = this.createLog();
		
		//Initialize the stack with a node that contains the problem's initial state.
		frontier.add(new Node(initialState));
		//The initial state is kept in the list of generated states.
		generatedStates.add(initialState);

		//Loop until a solution is found or the stack empties
		while (!solutionFound && !frontier.isEmpty()) {
			//write the stack's content in the search log.
			this.writeLog(searchLog, frontier);

			//Remove the first node from the stack.
			firstNode = frontier.pop();
			//If the first node contains a problem's final state, then it's solved
			if (problem.isFinalState(firstNode.getState())) {
				//change the flag to signal that the problem is solved
				solutionFound = true;
			//If the first node doesn't contain a problem's final state
			} else {
				//expand the first node.
				successorNodes = super.expand(firstNode, problem, generatedStates, expandedStates);
				// Each successor node is pushed into stack one by one.
				for (Node successorNode : successorNodes) {
					frontier.push(successorNode);
				}
			}
		}
		
		// close the search log.
		this.closeLog(searchLog);		
		
		// If the problem is solved
		if (solutionFound) {
			//The first node of the stack is returned as it contains the problem's final state
			return firstNode;
		//If the problem isn't solved
		} else {
			//null is returned
			return null;
		}
	}
}