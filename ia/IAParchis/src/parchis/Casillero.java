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
		
		this.iniciarPosiciones();
	}
	
	/*0 - Casa amarilla
	 * 1 - Casa azul
	 * 2 - Casa roja
	 * 3 - Casa verde
	 */
	
	public void iniciarPosiciones()
	{
/*
		 casilla <--> 20
		 x ---->
		 y |
		   v
 */
		
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
		casillas.get(40).setPosicion(108, 256);
		casillas.get(41).setPosicion(128, 256);
		casillas.get(42).setPosicion(148, 256);
		casillas.get(43).setPosicion(161, 269);
		casillas.get(44).setPosicion(161, 289);
		casillas.get(45).setPosicion(161, 309);
		casillas.get(8).setPosicion(161, 329);
		casillas.get(46).setPosicion(161, 349);
		casillas.get(47).setPosicion(161, 369);
		casillas.get(48).setPosicion(161, 389);
		casillas.get(49).setPosicion(161, 409);
		casillas.get(9).setPosicion(207, 409);
		casillas.get(50).setPosicion(253, 409);
		casillas.get(51).setPosicion(253, 389);
		casillas.get(52).setPosicion(253, 369);
		casillas.get(53).setPosicion(253, 349);
		casillas.get(3).setPosicion(253, 329);
		casillas.get(54).setPosicion(253, 309);
		casillas.get(55).setPosicion(253, 289);
		casillas.get(56).setPosicion(253, 269);
		casillas.get(57).setPosicion(266, 256);
		casillas.get(58).setPosicion(286, 256);
		casillas.get(59).setPosicion(306, 256);
		casillas.get(10).setPosicion(326, 256);
		casillas.get(60).setPosicion(346, 256);
		casillas.get(61).setPosicion(366, 256);
		casillas.get(62).setPosicion(386, 256);
		casillas.get(63).setPosicion(406, 256);
		casillas.get(11).setPosicion(406, 210);
		casillas.get(64).setPosicion(406, 164);
		casillas.get(65).setPosicion(386, 164);		
		casillas.get(66).setPosicion(366, 164);
		casillas.get(67).setPosicion(346, 164);
			
		//pasillo amarillo - 72..79
				 
		casillas.get(72).setPosicion(386, 210);
		casillas.get(73).setPosicion(366, 210);
		casillas.get(74).setPosicion(346, 210);
		casillas.get(75).setPosicion(326, 210);
		casillas.get(76).setPosicion(306, 210);
		casillas.get(77).setPosicion(286, 210);
		casillas.get(78).setPosicion(266, 210);
		casillas.get(79).setPosicion(240, 210); //casilla final
		 
		//pasillo azul - 80..87
		
		casillas.get(80).setPosicion(207, 30);
		casillas.get(81).setPosicion(207, 50);
		casillas.get(82).setPosicion(207, 70);
		casillas.get(83).setPosicion(207, 90);
		casillas.get(84).setPosicion(207, 110);
		casillas.get(85).setPosicion(207, 130);
		casillas.get(86).setPosicion(207, 150);
		casillas.get(87).setPosicion(207, 176); //casilla final
		
		//pasillo rojo - 88..95
		
		casillas.get(88).setPosicion(28, 210);
		casillas.get(89).setPosicion(48, 210);
		casillas.get(90).setPosicion(68, 210);
		casillas.get(91).setPosicion(88, 210);
		casillas.get(92).setPosicion(108, 210);
		casillas.get(93).setPosicion(128, 210);
		casillas.get(94).setPosicion(148, 210);
		casillas.get(95).setPosicion(171, 210); //casilla final
		
		 //pasillo verde - 96..103
		
		casillas.get(96).setPosicion(207, 389);
		casillas.get(97).setPosicion(207, 369);
		casillas.get(98).setPosicion(207, 349);
		casillas.get(99).setPosicion(207, 329);
		casillas.get(100).setPosicion(207, 309);
		casillas.get(101).setPosicion(207, 289);
		casillas.get(102).setPosicion(207, 269);
		casillas.get(103).setPosicion(207, 246); //casilla final
				
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
