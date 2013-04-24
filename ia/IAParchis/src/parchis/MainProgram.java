package parchis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import minimaxAlgorithm.ParchisProblem;
import formulation.State;

public class MainProgram
{	
	public static void main(String [ ] args)
	{
		//tablero = new Tablero();
		//tablero.iniciarTablero();
		/*for(int i = 0; i < tablero.getCasillero().getCasillas().length; i++)
		{
			System.out.println(i + ":" + tablero.getCasillero().getCasillas()[i].isEsSegura());

		}*/
		/*System.out.println("Enter the number of players: ");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    String s = null;
		try
		{
			s = bufferRead.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	    System.out.println(s);
		int players = Integer.parseInt(s); */
		int players = 2;
		int jugadas = 2;
		try
		{		
			ParchisProblem problem = new ParchisProblem(players);
			State state = problem.getCurrentState();
			int player = problem.getCurrentState().getPlayer();
			while(true)
			{
				if(player == 0)
				{
					player = problem.getCurrentState().getPlayer();
					problem.getBestMovement(players);
					System.out.println("player: " + player);
				}
				else
				{	
					if(jugadas != 0 )
					{
						player = 0;
						jugadas--;
					}
					//player = 0;
				}
			}
			/*while (!(problem.isFinalState(problem.getCurrentState())))
			{
				switch(player)
				{
				case 0:
				{
					player = problem.getCurrentState().getPlayer();
					problem.getBestMovement(players);
					System.out.println("player: " + player);
				    player = problem.getCurrentState().getPlayer();
				    break;
				}
				case 1:
				{
					//bufferRead = new BufferedReader(new InputStreamReader(System.in));
				   // s = bufferRead.readLine();
				    //System.out.println(s);
					player++;
					System.out.println("player: " + player);
				    //player = problem.getCurrentState().getPlayer();
				    break;
				}
				case 2:
				{
					player++;
					System.out.println("player: " + player);
				    //player = problem.getCurrentState().getPlayer();
					break;
				}
				case 3:
				{
					player++;
				    //player = problem.getCurrentState().getPlayer();
					break;
				}
				}
			}*/
			//System.out.println("game over");
			
		}
		catch (Exception ex)
		{
			System.err.println("% [MainProgram] Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
