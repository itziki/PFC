package parchis;

import javax.swing.JApplet;

public class Tablero extends JApplet {
	private Casillero casillero;
	private Jugador jugador;
	
	private static final long serialVersionUID = 1L;
	public Casillero getCasillero() {
		return casillero;
	}
	public void setCasillero(Casillero casillero) {
		this.casillero = casillero;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}
