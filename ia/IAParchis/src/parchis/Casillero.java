package parchis;

import java.util.ArrayList;
import java.util.List;

public class Casillero {
	private List<Casilla> casillas = new ArrayList<Casilla>(); /*numero total de casillas del tablero*/
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

	public List<Casilla> getCasillas() {
		return casillas;
	}

	public void setCasillas(List<Casilla> casillas) {
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
			casillas.add(i, new Casilla(true));
		}
		//
		for (int i = 12; i < 72; i++)
		{
			casillas.add(i, new Casilla(false));
		}
		//pasillo final
		for (int i = 72; i < 104; i++)
		{			
			casillas.add(i, new Casilla(true));
		}
		casillas.add(104, new Casilla(false));
	}
	
	/*0 - Casa amarilla
	 * 1 - Casa azul
	 * 2 - Casa roja
	 * 3 - Casa verde
	 */
	
	public void iniciarPosiciones()
	{
		/*
		casillas.get(0).setPosicion(325, 164);
		casillas.get(12).setPosicion(305, 164);
		casillas.get(13).setPosicion(285, 164);
		casillas.get(14).setPosicion(265, 164);
		casillas.get(15).setPosicion(253, 151);		
		casillas.get(16).setPosicion(253, 131);		
		casillas.get(17).setPosicion(253, 111);
		casillas.get(4).setPosicion(253, 91);
		casillas.get(18).setPosicion(253, 71);
		casillas.get(19).setPosicion(253, 51);		
		casillas.get(20).setPosicion(253, 31);
		casillas.get(21).setPosicion(253, 11);
		casillas.get(5).setPosicion(207, 11);
		casillas.get(22).setPosicion(161, 11);
		casillas.get(23).setPosicion(161, 31);
		casillas.get(24).setPosicion(161, 51);
		casillas.get(25).setPosicion(161, 71);
		casillas.get(1).setPosicion(161, 91);
		casillas.get(26).setPosicion(161, 111);
		casillas.get(27).setPosicion(161, 131);
		casillas.get(28).setPosicion(161, 151);		
		casillas.get(29).setPosicion(148, 164);
		casillas.get(30).setPosicion(128, 164);
		casillas.get(31).setPosicion(108, 164);
		casillas.get(6).setPosicion(88, 164);		
		casillas.get(32).setPosicion(68, 164);
		casillas.get(33).setPosicion(48, 164);
		casillas.get(34).setPosicion(28, 164);
		casillas.get(35).setPosicion(8, 164);
		casillas.get(7).setPosicion(8, 210);
		casillas.get(36).setPosicion(8, 256);
		casillas.get(37).setPosicion(28, 256);
		casillas.get(38).setPosicion(48, 256);
		casillas.get(39).setPosicion(68, 256);
		casillas.get(3).setPosicion(88, 256);
		*/
		
		/*
		 casilla <--> 20
		 x ---->
		 y |
		   v
		 */
		casillas.get(0).setPosicion(88, 256);
	}
	
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
		
		List<Casilla> newCasillas = new ArrayList<Casilla>();
		for(int i = 0; i < casillas.size(); i++)
		{
			newCasillas.add(i, (Casilla) casillas.get(i).clone());
		}
		
		newCasillero.setCasillas(newCasillas);
		newCasillero.setPiezas(newPiezas);
		
		return newCasillero;
		
	}
}
