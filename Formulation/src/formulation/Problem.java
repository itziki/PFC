package formulation;

import java.util.ArrayList;
import java.util.List;


public abstract class Problem {
	
	//there is only one initialState -> all chips in their initial square
	private State initialState;
	//the state that is actually playing
	private State currentState;
	//one final state for each player
	private List<State> finalStates;
	private List<Action> actions;
	
	public Problem() {
		this.initialState = null;
		this.finalStates = new ArrayList<State>();
		this.actions = new ArrayList<Action>();
		
		this.createActions();
	}
	
	
	protected abstract void createActions();
	
	public State getInitialState()
	{
		return initialState;
	}
	
	public void addInitialState(State initialState)
	{
		this.initialState = initialState;
		this.currentState = initialState;
	}
	
	public List<State> getFinalStates()
	{
		return finalStates;
	}
	
	public void addFinalStates(List<State> finalStates)
	{
		this.finalStates = finalStates;
	}
	
	public State getCurrentState()
	{
		return currentState;
	}
	
	public void setCurrentState(State currentState)
	{
		this.currentState = currentState;
	}
	
	public List<Action> getActions()
	{
		return actions;
	}
	
	public void addActions(List<Action> actions)
	{
		this.actions = actions;
	}
	
	public boolean isFinalState(State state)
	{
		if (state != null) {
			return this.finalStates.contains(state);
		} else {
			return false;
		}
	}
}
