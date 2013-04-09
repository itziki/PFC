package parchis;

public class Casillero {
	private Casilla[] casillas = new Casilla[104]; /*numero total de casillas del tablero*/
	private Pieza[] piezas; /*todas las piezas del juego*/
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

	public Pieza[] getPiezas() {
		return piezas;
	}

	public void setPiezas(Pieza[] piezas) {
		this.piezas = piezas;
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
}
