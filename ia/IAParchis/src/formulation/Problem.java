package formulation;

import java.util.ArrayList;
import java.util.List;


public abstract class Problem {
	
	//there is only one initialState -> all chips in their initial square
	private State initialState;
	//the state that is actually playing
	private State currentState;
	//one final state for each player
	private State finalState;
	private List<Action> actions;
	
	public Problem() {
		this.initialState = null;
		this.finalState = null;
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
	
	public State getFinalState()
	{
		return finalState;
	}
	
	public void addFinalState(State finalState)
	{
		this.finalState = finalState;
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
			return this.finalState.equals(state);
		} else {
			return false;
		}
	}
}
