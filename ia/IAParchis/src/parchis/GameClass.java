package parchis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import minimaxAlgorithm.ParchisProblem;
import paintPackage.TableroGraphics;
import formulation.State;

public class GameClass {
	
	public int nextPlayer(int player, int numberPlayers)
	{
		if (player == (numberPlayers - 1))
		{
			return 0;
		}
		else
		{
			int nextPlayer = player + 1;
			return nextPlayer;
		}
	}
	
	public void play(int players, List<Boolean> cpu)
	{
		try
		{	
			ParchisProblem problem = ParchisProblem.getInstance(players, cpu);
			State state = problem.getCurrentState();
			TableroGraphics tableroGraphics = new TableroGraphics(state.getPartida());
			tableroGraphics.draw();
			int player = 0;
			while(!problem.isFinalState(problem.getCurrentState()))
			{
				player = problem.getCurrentState().getPlayer();
				Jugador jugador = problem.getCurrentState().getPartida().getTablero().getJugadores().get(player);
				//if(player == 0)
				if(jugador.isCpu())
				{					
					State bestMovement = problem.getBestMovement();
					if(bestMovement != null)
					{
						int nextPlayer = nextPlayer(player, players);
						bestMovement.setPlayer(nextPlayer);
						bestMovement.getPartida().setColorJugador(nextPlayer);
						problem.setCurrentState(bestMovement);
					}
					else
					{
						int nextPlayer = nextPlayer(player, players);
						problem.getCurrentState().setPlayer(nextPlayer);
						problem.getCurrentState().getPartida().setColorJugador(nextPlayer);
					}
					
					try {
					    Thread.sleep(2000);
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				else
				{
					try{
					    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
					    String s = bufferRead.readLine();
				 
					    System.out.println(s);
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					
				}
				tableroGraphics.setVariables(problem.getCurrentState().getPartida());
				tableroGraphics.draw();
			}
			System.out.println("game over");			
		}
		catch (Exception ex)
		{
			System.err.println("% [MainProgram] Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
