package parchis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dado {
	private int throwTimes;
	private List<Integer> consecutive6 = new ArrayList<Integer>();
	private int value;
	
	public Dado()
	{
		
	}
	
	public Dado(int value)
	{
		this.value = value;
	}

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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Integer> getConsecutive6() {
		return consecutive6;
	}

	public void setConsecutive6(List<Integer> givenValues) {
		this.consecutive6 = givenValues;
	}
	
	public void add6(int value)
	{
		if(value == 6)
		{
			this.consecutive6.add(value);
		}
	}
}
