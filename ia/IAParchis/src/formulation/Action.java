package formulation;

public abstract class Action {
	
	private String name;
	
	public Action(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return this.getName().toString();
	}

	//dice is the number that is get after rolling the dice

	public final State apply(State state, int dice)
	{
		State successor = null;

		if (state != null && this.isApplicable(state, dice)) {
			successor = this.effect(state, dice);
		}

		return successor;
	}
	
	protected abstract boolean isApplicable(State state, int dice);
	
	protected abstract State effect(State state, int dice);
}
