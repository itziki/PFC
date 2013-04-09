package parchis;

import java.util.List;

/**
 * REGLAS DEL ALGORITMO Y FUNCION DE UTILIDAD
 * a) Si con el movimiento...
 * 	 1- Alcanzamos un seguro: +10
 *   2- No alcanzamos un seguro se comparan la posición final con la que tiene ahora
 * 		calculamos para cada posición (actual y posible final) el número de fichas que 
 * 		tenemos tanto por delante como por detrás en un rango de 7 casillas (el máximo que se puede
 * 		alcanzar). Seguido se calcula esta función
 * 			rating = 3·(incremento_piezas_atacadas) + 9·(reducción_piezas_atacantes)
 * 						las que tenemos delante				las que tenemos detras
 * 	 3- Comemos pieza enemiga: +30
 * b) Si la ficha está en un seguro válido (casillas de inicio de otro color no): -5
 * 	Se calcula el nº de fichas por detrás de ella hasta 7 casillas. Por cada una: -9
 * 	Si está compartiendo el seguro con una ficha enemiga: -6
 * c) Penalización por el camino recorrido: rating = 1-recorrido/10
 */
public class Jugador {
	private int colorPiezas;/*0- amarillo; 1-azul; 2-rojo; 3-verde*/
	
	public Pieza selectPieza(Casillero casillero, int dado){
		int rating = 0;
		Pieza piezaElegida = null;
		Casilla[] casillas = casillero.getCasillas();
		Pieza[] piezas = casillero.getPiezas();
		List<Pieza> piezasEnCasilla = null;
		/*regla a*/
		for (int i = 0; i < piezas.length; i= i+1)
		{
			if (piezas[i].getColor() == this.colorPiezas)
			{
				int casillaPieza = piezas[i].getCasilla();
				int casillasPorDelante = casillaPieza + 7;
				int casillasPorDetras = casillaPieza - 7;
				int reduccionPiezasAtacantes = 0;
				int incrementoPiezasAtacadas = 0;
				piezasEnCasilla = casillas[casillaPieza].getPiezas();
				/*regla a.1: alcanzamos un seguro*/
				if (casillas[casillaPieza + dado].isEsSegura())
				{
					rating += 10;
				}
				/*regla a.3: comemos pieza enemiga*/
				else if (casillas[casillaPieza + dado].miPieza(colorPiezas).getColor() != colorPiezas)
				{
					rating += 30;
				}
				/*regla a.2*/
				else
				{
					/*posición inicial*/
					for (int j = casillaPieza; j < casillasPorDelante; j++)
					{
						Pieza otraPieza = casillas[j].miPieza(colorPiezas);
						if (otraPieza.getColor() != this.colorPiezas)
						{
							reduccionPiezasAtacantes++;
						}
					}
					for (int j = casillaPieza; j < casillasPorDetras; j--)
					{
						Pieza otraPieza = casillas[j].miPieza(colorPiezas);
						if (otraPieza.getColor() != this.colorPiezas)
						{
							incrementoPiezasAtacadas++;
						}
					}
					/*posicion final*/
					for (int j = casillasPorDelante; j < casillasPorDelante + 7; j++)
					{
						Pieza otraPieza = casillas[j].miPieza(colorPiezas);
						if (otraPieza.getColor() != this.colorPiezas)
						{
							reduccionPiezasAtacantes++;
						}
					}
					for (int j = casillasPorDelante; j < casillaPieza; j--)
					{
						Pieza otraPieza = casillas[j].miPieza(colorPiezas);
						if (otraPieza.getColor() != this.colorPiezas)
						{
							incrementoPiezasAtacadas++;
						}
					}
					/*función*/
					rating += (3 * incrementoPiezasAtacadas) + (9 * reduccionPiezasAtacantes);
				}
				/*regla b*/
				if((casillas[casillaPieza].isEsSegura()) || (casillero.esMiSeguro(colorPiezas, casillaPieza)))
				{
					rating -= 5;
					for(int j = casillaPieza; j < casillasPorDetras; j--)
					{
						Pieza otraPieza = casillas[j].miPieza(colorPiezas);
						if (otraPieza.getColor()!= this.colorPiezas)
						{
							rating -= 9;
						}
					}
					for(int k = 0; k < piezas.length; k++)
					{
						if (piezas[k].getCasilla() == casillaPieza)
							if (piezas[k].getColor() != this.colorPiezas)
								rating -= 6;
					}
				}
				/*regla c: 1-recorrido/10*/
				rating -= (1-piezas[i].getRecorrido()/10);
			}
		}
			
		return piezaElegida;		
	}
	public int getColorPiezas() {
		return colorPiezas;
	}
	public void setColorPiezas(int colorPiezas) {
		this.colorPiezas = colorPiezas;
	}
}
