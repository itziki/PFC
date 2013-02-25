package parchis;

public class Partida {
	private static Tablero tablero;
	private int colorJugador; /*0- amarillo; 1-azul; 2-rojo; 3-verde*/
	
	public int getColorJugador() {
		return colorJugador;
	}

	public void setColorJugador(int colorJugador) {
		this.colorJugador = colorJugador;
	}
	
	public Tablero getTablero() {
		return tablero;
	}

	public static void main(String [ ] args)
	{
		tablero = new Tablero();
		tablero.iniciarTablero();
		for(int i = 0; i < tablero.getCasillero().getCasillas().length; i++)
		{
			System.out.println(i + ":" + tablero.getCasillero().getCasillas()[i].isEsSegura());

		}
	}
	
}



