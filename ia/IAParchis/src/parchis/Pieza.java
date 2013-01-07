package parchis;

public class Pieza {
	private int color; /*0- amarillo; 1-azul; 2-rojo; 3-verde*/
	private int recorrido; /*numero de casillas que ha recorrido*/
	private int casilla; /*número de casilla en la que se encuentra*/

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}

	public int getCasilla() {
		return casilla;
	}

	public void setCasilla(int casilla) {
		this.casilla = casilla;
	}
}
