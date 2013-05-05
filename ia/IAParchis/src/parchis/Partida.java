package parchis;

import java.util.ArrayList;
import java.util.List;


public class Partida {
	private Tablero tablero;
	private int colorJugador; /*0- amarillo; 1-azul; 2-rojo; 3-verde*/
		
	public Partida(Tablero tablero, int jugador)
	{
		this.tablero = tablero;
		this.colorJugador = jugador;
	}
	
	public Partida()
	{
		
	}

	public int getColorJugador() {
		return colorJugador;
	}

	public void setColorJugador(int colorJugador) {
		this.colorJugador = colorJugador;
	}
	
	public Tablero getTablero() {
		return this.tablero;
	}
	
	public Partida clone()
	{
		Partida partidaCloned = new Partida(this.tablero.clone(), this.colorJugador);
		return partidaCloned;
	}

		
	/*public static void main(String [ ] args)
	{
		//tablero = new Tablero();
		//tablero.iniciarTablero();
		//for(int i = 0; i < tablero.getCasillero().getCasillas().length; i++)
		//{
			//System.out.println(i + ":" + tablero.getCasillero().getCasillas()[i].isEsSegura());

		//}
		try
		{		
			ParchisProblem problem = new ParchisProblem(2);
			State state = problem.getCurrentState();
			int player = problem.getCurrentState().getPlayer();
			while (player < 2)
			{
				problem.getBestMovement(tablero.getJugadores().size());
				System.out.println("player: " + player);
			}
			System.out.println("game over");
			
		}
		catch (Exception ex)
		{
			System.err.println("% [MainProgram] Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}*/
	
}



