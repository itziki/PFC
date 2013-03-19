package test;

import java.util.Random;

import formulation.Action;
import formulation.State;

public class TestAction extends Action {

	public TestAction(String name)
	{
		super(name);
	}

	protected boolean isApplicable(State state, int dice)
	{
		return true;
	}

	protected State effect(State state, int dice)
	{
		Random randomGenerator = new Random();
	    int rating = randomGenerator.nextInt(dice) + 1;
	    State newState = state;
	    newState.setRating(rating);
	    //System.out.println("Generated node's value: " + rating);
		return newState;
	}

}
