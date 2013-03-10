package formulation;

public class State {
	private Object information;
	private int value;
	
	public State (Object information)
	{
		this.information = information;
	}

	public Object getInformation()
	{
		return information;
	}

	public String toString()
	{
		return this.information.toString();
	}
		
	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public boolean equals(Object object)
	{
		if(object instanceof State && object != null)
		{
			return ((State) object).information.equals(this.information);
		}
		else
		{
			return false;
		}
		
	}
}
