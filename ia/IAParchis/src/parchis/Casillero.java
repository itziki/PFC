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
	
	/*
	 * 5 - Seguro amarillo
	 * 22 - Seguro azul
	 * 39 - Seguro rojo
	 * 56 - Seguro verde
	 * 1..68 - Tablero
	 * 69..76 - Pasillo amarillo
	 * 77..84 - pasillo azul
	 * 85..92 - pasillo rojo
	 * 93..100 - pasillo verde
	 * además, las casillas seguras para todos son:
	 * 12,17,29,34,46,51,63,68*/

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
		for (int i = 0; i <= 101; i++)
		{			
			casillas.add(i, new Casilla(false));
		}
		
		//casillas iniciales de los colores
		casillas.get(5).setEsSegura(true);
		casillas.get(22).setEsSegura(true);
		casillas.get(39).setEsSegura(true);
		casillas.get(56).setEsSegura(true);
		
		//seguras para todos
		casillas.get(12).setEsSegura(true);
		casillas.get(17).setEsSegura(true);
		casillas.get(29).setEsSegura(true);
		casillas.get(34).setEsSegura(true);
		casillas.get(46).setEsSegura(true);
		casillas.get(51).setEsSegura(true);
		casillas.get(63).setEsSegura(true);
		casillas.get(68).setEsSegura(true);
		
		//pasillos finales
		for (int i = 69; i <= 100; i++)
		{			
			casillas.get(i).setEsSegura(true);
		}
		
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
		casillas.get(1).setPosicion(406, 164);//1
		casillas.get(2).setPosicion(386, 164);//2
		casillas.get(3).setPosicion(366, 164);//3
		casillas.get(4).setPosicion(346, 164);//4		
		casillas.get(5).setPosicion(325, 164); //5
		casillas.get(6).setPosicion(305, 164); //6
		casillas.get(7).setPosicion(285, 164); //7
		casillas.get(8).setPosicion(265, 164); //8
		casillas.get(9).setPosicion(253, 151);	//9
		casillas.get(10).setPosicion(253, 131);	//10
		casillas.get(11).setPosicion(253, 111); //11
		casillas.get(12).setPosicion(253, 91); //12
		casillas.get(13).setPosicion(253, 71); //13
		casillas.get(14).setPosicion(253, 51);	//14	
		casillas.get(15).setPosicion(253, 31);//15
		casillas.get(16).setPosicion(253, 11);//16
		casillas.get(17).setPosicion(207, 11); //17
		casillas.get(18).setPosicion(161, 11);//18
		casillas.get(19).setPosicion(161, 31);//19
		casillas.get(20).setPosicion(161, 51);//20
		casillas.get(21).setPosicion(161, 71);//21
		casillas.get(22).setPosicion(161, 91); //22
		casillas.get(23).setPosicion(161, 111);//23
		casillas.get(24).setPosicion(161, 131);//24
		casillas.get(25).setPosicion(161, 151);	//25	
		casillas.get(26).setPosicion(148, 164);//26
		casillas.get(27).setPosicion(128, 164);//27
		casillas.get(28).setPosicion(108, 164);//28
		casillas.get(29).setPosicion(88, 164); //29		
		casillas.get(30).setPosicion(68, 164);//30
		casillas.get(31).setPosicion(48, 164);//31
		casillas.get(32).setPosicion(28, 164);//32
		casillas.get(33).setPosicion(8, 164);//33
		casillas.get(34).setPosicion(8, 210); //34
		casillas.get(35).setPosicion(8, 256);//35
		casillas.get(36).setPosicion(28, 256);//36
		casillas.get(37).setPosicion(48, 256);//37
		casillas.get(38).setPosicion(68, 256);//38
		casillas.get(39).setPosicion(88, 256); //39
		casillas.get(40).setPosicion(108, 256);//40
		casillas.get(41).setPosicion(128, 256);//41
		casillas.get(42).setPosicion(148, 256);//42
		casillas.get(43).setPosicion(161, 269);//43
		casillas.get(44).setPosicion(161, 289);//44
		casillas.get(45).setPosicion(161, 309);//45
		casillas.get(46).setPosicion(161, 329); //46
		casillas.get(47).setPosicion(161, 349);//47
		casillas.get(48).setPosicion(161, 369);//48
		casillas.get(49).setPosicion(161, 389);//49
		casillas.get(50).setPosicion(161, 409);//50
		casillas.get(51).setPosicion(207, 409); //51
		casillas.get(52).setPosicion(253, 409);//52
		casillas.get(53).setPosicion(253, 389);//53
		casillas.get(54).setPosicion(253, 369);//54
		casillas.get(55).setPosicion(253, 349);//55
		casillas.get(56).setPosicion(253, 329); //56
		casillas.get(57).setPosicion(253, 309);//57
		casillas.get(58).setPosicion(253, 289);//58
		casillas.get(50).setPosicion(253, 269);//59
		casillas.get(60).setPosicion(266, 256);//60
		casillas.get(61).setPosicion(286, 256);//61
		casillas.get(62).setPosicion(306, 256);//62
		casillas.get(63).setPosicion(326, 256); //63
		casillas.get(64).setPosicion(346, 256);//64
		casillas.get(65).setPosicion(366, 256);//65
		casillas.get(66).setPosicion(386, 256);//66
		casillas.get(67).setPosicion(406, 256);//67
		casillas.get(68).setPosicion(406, 210);//68
					
		//pasillo amarillo - 69..76
				 
		casillas.get(69).setPosicion(386, 210);
		casillas.get(70).setPosicion(366, 210);
		casillas.get(71).setPosicion(346, 210);
		casillas.get(72).setPosicion(326, 210);
		casillas.get(73).setPosicion(306, 210);
		casillas.get(74).setPosicion(286, 210);
		casillas.get(75).setPosicion(266, 210);
		casillas.get(76).setPosicion(240, 210); //casilla final
		 
		//pasillo azul - 77..84
		
		casillas.get(77).setPosicion(207, 30);
		casillas.get(78).setPosicion(207, 50);
		casillas.get(79).setPosicion(207, 70);
		casillas.get(80).setPosicion(207, 90);
		casillas.get(81).setPosicion(207, 110);
		casillas.get(82).setPosicion(207, 130);
		casillas.get(83).setPosicion(207, 150);
		casillas.get(84).setPosicion(207, 176); //casilla final
		
		//pasillo rojo - 85..92
		
		casillas.get(85).setPosicion(28, 210);
		casillas.get(86).setPosicion(48, 210);
		casillas.get(87).setPosicion(68, 210);
		casillas.get(88).setPosicion(88, 210);
		casillas.get(89).setPosicion(108, 210);
		casillas.get(90).setPosicion(128, 210);
		casillas.get(91).setPosicion(148, 210);
		casillas.get(92).setPosicion(171, 210); //casilla final
		
		 //pasillo verde - 93..100
		
		casillas.get(93).setPosicion(207, 389);
		casillas.get(94).setPosicion(207, 369);
		casillas.get(95).setPosicion(207, 349);
		casillas.get(96).setPosicion(207, 329);
		casillas.get(97).setPosicion(207, 309);
		casillas.get(98).setPosicion(207, 289);
		casillas.get(99).setPosicion(207, 269);
		casillas.get(100).setPosicion(207, 246); //casilla final
				
	}
	
	public boolean esMiSeguro(int color, int casilla)
	{
		boolean result = false;
		switch (color)
		{
			case 0: if (casilla == 5)
				result = true;
			break;
			case 1: if (casilla == 22)
				result = true;
			break;
			case 2: if (casilla == 39)
				result = true;
			break;
			case 3: if (casilla == 56)
				result = true;
			break;
		}
		return result;
	}
	
	/*public void meterFichasHardCoded()
	{

		casillas.get(56).addPiezaToCasilla(piezas.get(3));
		//piezas.get(3).setRecorrido(62);
	}*/
	
	
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
			case 0: if(casilla == 76)
				estaEnFinal = true;
				break;
			case 1: if(casilla == 84)
				estaEnFinal = true;
				break;
			case 2: if(casilla == 92)
				estaEnFinal = true;
				break;
			case 3: if(casilla == 100)
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
