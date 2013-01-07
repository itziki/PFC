package parchis;

import javax.swing.JApplet;

public class Tablero extends JApplet {
	private Casillero casillero;
	private Jugador jugador;
	/**
	 * REGLAS DEL ALGORITMO Y FUNCION DE UTILIDAD
	 * a) Si con el movimiento...
	 * 	1- Alcanzamos un seguro: +10
	 * 	2- No alcanzamos un seguro se comparan la posici�n final con la que tiene ahora
	 * 		calculamos para cada posici�n (actual y posible final) el n�mero de fichas que 
	 * 		tenemos tanto por delante como por detr�s en un rango de 7 casillas (el m�ximo que se puede
	 * 		alcanzar). Seguido se calcula esta funci�n
	 * 			rating = 3�(incremento_piezas_atacadas) + 9�(reducci�n_piezas_atacantes)
	 * 						las que tenemos delante				las que tenemos detras
	 * 	3- Comemos pieza enemiga: +30
	 * b) Si la ficha est� en un seguro v�lido (casillas de inicio de otro color no): -5
	 * 	Se calcula el n� de fichas por detr�s de ella hasta 7 casillas. Por cada una: -9
	 * 	Si est� compartiendo el seguro con una ficha enemiga: -6
	 * c) Penalizaci�n por el camino recorrido: rating = 1-recorrido/10
	 */
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
