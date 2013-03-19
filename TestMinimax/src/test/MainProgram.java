package test;

public class MainProgram {
	public static void main(String[] args) {
		try {		
			TestProblem problem = new TestProblem(1);			
			int player = problem.selectMovement();
			System.out.println("player: " + player);
			problem.getCurrentState().setPlayer(player);
			
		} catch (Exception ex) {
			System.err.println("% [MainProgram] Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
