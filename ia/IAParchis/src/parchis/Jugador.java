package parchis;

import java.util.List;

/**
 * REGLAS DEL ALGORITMO Y FUNCION DE UTILIDAD
 * a) Si con el movimiento...
 * 	 1- Alcanzamos un seguro: +10
 *   2- No alcanzamos un seguro se comparan la posici�n final con la que tiene ahora
 * 		calculamos para cada posici�n (actual y posible final) el n�mero de fichas que 
 * 		tenemos tanto por delante como por detr�s en un rango de 7 casillas (el m�ximo que se puede
 * 		alcanzar). Seguido se calcula esta funci�n
 * 			rating = 3�(incremento_piezas_atacadas) + 9�(reducci�n_piezas_atacantes)
 * 						las que tenemos delante				las que tenemos detras
 * 	 3- Comemos pieza enemiga: +30
 * b) Si la ficha est� en un seguro v�lido (casillas de inicio de otro color no): -5
 * 	Se calcula el n� de fichas por detr�s de ella hasta 7 casillas. Por cada una: -9
 * 	Si est� compartiendo el seguro con una ficha enemiga: -6
 * c) Penalizaci�n por el camino recorrido: rating = 1-recorrido/10
 */
public class Jugador {
	private int colorPiezas;/*0- amarillo; 1-azul; 2-rojo; 3-verde*/
	private boolean cpu = false;
	
	public Jugador(int colorPiezas, boolean cpu)
	{
		this.colorPiezas = colorPiezas;
		this.cpu = cpu;
	}
	
	public Pieza selectPieza(Casillero casillero, int dado){
		int rating = 0;
		Pieza piezaElegida = null;
		List<Casilla> casillas = casillero.getCasillas();
		List<Pieza> piezas = casillero.getPiezas();
		List<Pieza> piezasEnCasilla = null;
		/*regla a*/
		for (int i = 0; i < piezas.size(); i= i+1)
		{
			if (piezas.get(i).getColor() == this.colorPiezas)
			{
				int casillaPieza = piezas.get(i).getCasilla();
				int casillasPorDelante = casillaPieza + 7;
				int casillasPorDetras = casillaPieza - 7;
				int reduccionPiezasAtacantes = 0;
				int incrementoPiezasAtacadas = 0;
				piezasEnCasilla = casillas.get(casillaPieza).getPiezas();
				/*regla a.1: alcanzamos un seguro*/
				if (casillas.get(casillaPieza + dado).isEsSegura())
				{
					rating += 10;
				}
				/*regla a.3: comemos pieza enemiga*/
				else if (casillas.get(casillaPieza + dado).miPieza(colorPiezas).getColor() != colorPiezas)
				{
					rating += 30;
				}
				/*regla a.2*/
				else
				{
					/*posici�n inicial*/
					for (int j = casillaPieza; j < casillasPorDelante; j++)
					{
						Pieza otraPieza = casillas.get(j).miPieza(colorPiezas);
						if (otraPieza.getColor() != this.colorPiezas)
						{
							reduccionPiezasAtacantes++;
						}
					}
					for (int j = casillaPieza; j < casillasPorDetras; j--)
					{
						Pieza otraPieza = casillas.get(j).miPieza(colorPiezas);
						if (otraPieza.getColor() != this.colorPiezas)
						{
							incrementoPiezasAtacadas++;
						}
					}
					/*posicion final*/
					for (int j = casillasPorDelante; j < casillasPorDelante + 7; j++)
					{
						Pieza otraPieza = casillas.get(j).miPieza(colorPiezas);
						if (otraPieza.getColor() != this.colorPiezas)
						{
							reduccionPiezasAtacantes++;
						}
					}
					for (int j = casillasPorDelante; j < casillaPieza; j--)
					{
						Pieza otraPieza = casillas.get(j).miPieza(colorPiezas);
						if (otraPieza.getColor() != this.colorPiezas)
						{
							incrementoPiezasAtacadas++;
						}
					}
					/*funci�n*/
					rating += (3 * incrementoPiezasAtacadas) + (9 * reduccionPiezasAtacantes);
				}
				/*regla b*/
				if((casillas.get(casillaPieza).isEsSegura()) || (casillero.esMiSeguro(colorPiezas, casillaPieza)))
				{
					rating -= 5;
					for(int j = casillaPieza; j < casillasPorDetras; j--)
					{
						Pieza otraPieza = casillas.get(j).miPieza(colorPiezas);
						if (otraPieza.getColor()!= this.colorPiezas)
						{
							rating -= 9;
						}
					}
					for(int k = 0; k < piezas.size(); k++)
					{
						if (piezas.get(k).getCasilla() == casillaPieza)
							if (piezas.get(k).getColor() != this.colorPiezas)
								rating -= 6;
					}
				}
				/*regla c: 1-recorrido/10*/
				rating -= (1-piezas.get(i).getRecorrido()/10);
			}
		}
			
		return piezaElegida;		
	}
	
	public boolean isCpu() {
		return cpu;
	}

	public void setCpu(boolean cpu) {
		this.cpu = cpu;
	}

	public int getColorPiezas() {
		return colorPiezas;
	}
	public void setColorPiezas(int colorPiezas) {
		this.colorPiezas = colorPiezas;
	}
	
	public Jugador clone()
	{
		Jugador newJugador = new Jugador(this.colorPiezas, this.cpu);
		return newJugador;
	}
}

