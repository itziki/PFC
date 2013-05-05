package formulation;

import parchis.Partida;
import parchis.Pieza;


public class State {
	private Object information; //informacion => string
	private Pieza pieza; //pieza que se va a mover
	private Partida partida;
	//the rating value
	private double rating;
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
		
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public double getRating()
	{
		return rating;
	}

	public void setRating(double d)
	{
		this.rating = d;
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
	
	public State clone(String information) {
		State newState = new State(information);
		newState.setPlayer(this.player);
		newState.setPartida(this.partida.clone());
		newState.setPieza(this.pieza.clone());
		newState.setRating(this.getRating());
		
		return newState;
	}

	public Object getPieza()
	{
		return pieza;
	}

	public void setPieza(Object pieza)
	{
		this.pieza = (Pieza) pieza;
	}
}
