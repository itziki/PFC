package parchis;

import java.util.Random;

public class Dice {
	private int throwTimes;

	public int getThrowTimes()
	{
		return throwTimes;
	}
	
	public int throwDice()
	{
		Random randomGenerator = new Random();
	    int dice = randomGenerator.nextInt(6) + 1;
		return dice;
	}
}
