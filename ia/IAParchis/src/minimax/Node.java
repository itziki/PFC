package minimax;

import formulation.State;

public class Node implements Comparable<Node> {
	
	private State state;
	private String action;
	private Node parent;
	private int depth;
	private double g;
	private double h;
	
	public Node(State state)
	{
		this.state = state;
	}

	public String getAction()
	{
		return action;
	}
	
	public void setAction(String action)
	{
		this.action = action;
	}
	
	public Node getParent()
	{
		return parent;
	}
	
	public void setParent(Node parent)
	{
		this.parent = parent;
	}

	public int getDepth()
	{
		return depth;
	}
	
	public void setDepth(int depth)
	{
		this.depth = depth;
	}

	public double getG()
	{
		return g;
	}

	public void setG(double g)
	{
		this.g = g;
	}

	public double getH()
	{
		return h;
	}

	public void setH(double h)
	{
		this.h = h;
	}

	public State getState()
	{
		return state;
	}
	
	public String toString()
	{
		String tab = "";
		// Tabulating the node's content is accomplished by adding two empty spaces 
		// per depth unit.
		for (int i = 0; i < this.depth; i++) {
			tab += "  ";
		}
		return tab + "Tree level:" + this.depth + " / g(n): " + this.g + 
		       "/ h(n): " + this.h + " # [" + this.state + "]";
	}
	
	public boolean equals(Object object)
	{
		if (object != null && object instanceof Node) {
			if (this.state.equals(((Node) object).state) && (this.action.equals(((Node) object).action)))
			{
				return true;
			}
			else
			{
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
