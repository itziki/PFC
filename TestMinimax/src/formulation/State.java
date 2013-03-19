package formulation;

public class State {
	private Object information;
	//the rating value
	private int rating;
	private int player; //0-> MAX; 1->MIN
	
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
		
	public int getRating()
	{
		return rating;
	}

	public void setRating(int rating)
	{
		this.rating = rating;
	}

	public int getPlayer()
	{
		return player;
	}

	public void setPlayer(int player)
	{
		this.player = player;
	}

	public boolean equals(Object object)
	{
		if(object instanceof State && object != null)
		{
			//System.out.print(((State) object).information.equals(this.information));
			if( ((State) object).information.equals(this.information) && ((State) object).rating == (this.rating))
			{
				return true;
			}			
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
}
