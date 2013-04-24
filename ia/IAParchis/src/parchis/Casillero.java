package parchis;

import java.util.ArrayList;
import java.util.List;

public class Casillero {
	private Casilla[] casillas = new Casilla[105]; /*numero total de casillas del tablero*/
	private List<Pieza> piezas = new ArrayList<Pieza>(); /*todas las piezas del juego*/
	/*
	 * 0 - Seguro amarillo
	 * 1 - Seguro azul
	 * 2 - Seguro rojo
	 * 3 - Seguro verde
	 * 12..71 - Tablero
	 * 72..79 - Pasillo amarillo
	 * 80..87 - pasillo azul
	 * 88..95 - pasillo rojo
	 * 96..103 - pasillo verde
	 * además, las casillas seguras para todos son:
	 * 4,5,6,7,8,9,10,11*/

	public Casilla[] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[] casillas) {
		this.casillas = casillas;
	}

	public List<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(List<Pieza> piezas) {
		this.piezas = piezas;
	}
	
	public List<Pieza> getPiezasJugador(int jugador)
	{
		List<Pieza> piezasJugador = new ArrayList<Pieza>();
		for(int i = 0; i < piezas.size(); i++)
		{
			if(piezas.get(i).getColor() == jugador)
			{
				piezasJugador.add(piezas.get(i));
			}
		}
		return piezasJugador;
		
	}
	
	public void iniciarCasillero()
	{
		//casillas de salida
		for (int i = 0; i < 12; i++)
		{			
			casillas[i] = new Casilla(true);
		}
		//
		for (int i = 12; i < 72; i++)
		{
			casillas[i] = new Casilla(false);
		}
		//pasillo final
		for (int i = 72; i < 104; i++)
		{			
			casillas[i] = new Casilla(true);
		}
		casillas[104] = new Casilla(false);
	}
	
	/*0 - Casa amarilla
	 * 1 - Casa azul
	 * 2 - Casa roja
	 * 3 - Casa verde
	 */
	public boolean esMiSeguro(int color, int casilla)
	{
		boolean result = false;
		switch (color)
		{
			case 0: if (casilla == 0)
				result = true;
			break;
			case 1: if (casilla == 1)
				result = true;
			break;
			case 2: if (casilla == 2)
				result = true;
			break;
			case 3: if (casilla == 3)
				result = true;
			break;
		}
		return result;
	}
	
	
	/*72..79 - Pasillo amarillo
	 * 80..87 - pasillo azul
	 * 88..95 - pasillo rojo
	 * 96..103 - pasillo verde*/
	public boolean piezaEnFinal(Pieza ficha)
	{
		boolean estaEnFinal = false;
		int casilla = ficha.getCasilla();
		switch(ficha.getColor())
		{
			case 0: if(casilla == 79)
				estaEnFinal = true;
				break;
			case 1: if(casilla == 87)
				estaEnFinal = true;
				break;
			case 2: if(casilla == 95)
				estaEnFinal = true;
				break;
			case 3: if(casilla == 103)
				estaEnFinal = true;
				break;
		}
		return estaEnFinal;
	}
	
	public Casillero clone()
	{
		Casillero newCasillero = new Casillero();
		
		List<Pieza> newPiezas = new ArrayList<Pieza>();
		for(int i = 0; i < piezas.size(); i++)
		{
			newPiezas.add((Pieza) piezas.get(i).clone());
		}
		
		Casilla[] newCasillas = new Casilla[105];
		for(int i = 0; i < casillas.length; i++)
		{
			newCasillas[i] = (Casilla) casillas[i].clone();
		}
		
		newCasillero.setCasillas(newCasillas);
		newCasillero.setPiezas(newPiezas);
		
		return newCasillero;
		
	}
}
