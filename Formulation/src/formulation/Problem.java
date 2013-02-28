package formulation;

import java.util.List;

public abstract class Problem {
	
	//there is only one initialState and one finalState
	private State initialState;
	private State finalState;
	private List<Action> actions;
	
	protected abstract void createOperators();
	
	public State getInitialState()
	{
		return initialState;
	}
	public void addInitialState(State initialState)
	{
		this.initialState = initialState;
	}
	public State getFinalState()
	{
		return finalState;
	}
	public void addFinalState(State finalState)
	{
		this.finalState = finalState;
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
		return state.equals(this.finalState);
	}
}
