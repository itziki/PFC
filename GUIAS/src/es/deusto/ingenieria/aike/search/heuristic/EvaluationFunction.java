package es.deusto.ingenieria.aike.search.heuristic;

import es.deusto.ingenieria.aike.search.Node;

/**
 * Abstract class defining the evaluation function to be used 
 * by a heuristic search method. 
 * This class is the result of applying the design pattern: Strategy
 */
public abstract class EvaluationFunction {	
	
	/**
	 * Calculates the real accumulated cost down to the given search node.
	 * @param node current search node for which the real accumulated cost is to be calculated.
	 * @return double indicating the value of the real accumulated cost.
	 */
	public abstract double calculateG(Node node);	
	
	/**
	 * Calculates the ESTIMATED cost from the given search node to the goal node.
	 * @param node current search node for which the estimated cost is to be calculated.
	 * @return double indicating the value of the estimated cost.
	 */
	public abstract double calculateH(Node node);	
}