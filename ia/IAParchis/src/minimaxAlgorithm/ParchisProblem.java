package minimaxAlgorithm;

import java.util.List;

import minimax.MinimaxAlgorithm;
import formulation.Action;
import formulation.Problem;
import formulation.State;

public class ParchisProblem extends Problem {

	protected void createOperators()
	{
		final List<Action> actionList = null;
		actionList.add(new DestroyABarrier("DestroyABarrier"));
		actionList.add(new EatChip("EatChip"));
		actionList.add(new EnterFinalCorridor("EnterFinalCorridor"));
		actionList.add(new EnterFinalSquare("EnterFinalSquare"));
		actionList.add(new GetOutOfHome("GetOutOfHome"));
		actionList.add(new JumpABarrier("JumpABarrier"));
		actionList.add(new MakeABarrier("MakeABarrier"));
		actionList.add(new MoveChip("MoveChip"));
		actionList.add(new MoveChipInCorridor("MoveChipInCorridor"));
		actionList.add(new ReturnChipToHome("ReturnChipToHome"));
		this.addActions(actionList);
	}
	
	/*
	 * 0 - Casa amarilla
	 * 1 - Casa azul
	 * 2 - Casa roja
	 * 3 - Casa verde
	 * 12..71 - Tablero
	 * 72..79 - Pasillo amarillo
	 * 80..87 - pasillo azul
	 * 88..95 - pasillo rojo
	 * 96..103 - pasillo verde
	 * además, las casillas seguras para todos son:
	 * 4,5,6,7,8,9,10,11*/
	
	public void createInitialState(int playerNumber)
	{
		//playerNumber variable is the amount of players that are playing. 2 <= playerNumber <= 4
		for(int i = 0; i < playerNumber; i++)
		{
			
		}
	}
	
	public void addFinalStates()
	{
		
	}
	
	public boolean isFinalState(State state)
	{
		return false;
	}
	
	public void getBestMovement(MinimaxAlgorithm minimaxAlgorithm)
	{
		
	}

}
