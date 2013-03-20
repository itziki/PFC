package test;

public class MainProgram {
	public static void main(String[] args) {
		try {		
			TestProblem problem = new TestProblem(1);
			int player = 0;
			//while (player < 2)
			{
				player = problem.selectMovement();
				System.out.println("player: " + player);
				problem.getCurrentState().setPlayer(player);
			}
			System.out.println("game over");
			
		} catch (Exception ex) {
			System.err.println("% [MainProgram] Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
