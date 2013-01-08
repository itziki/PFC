package parchis;

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
public class Jugador {
	private int colorPiezas;/*0- amarillo; 1-azul; 2-rojo; 3-verde*/
	
	public Pieza selectPieza(Casillero casillero, int dado){
		int rating = 0;
		Pieza piezaElegida = null;
		Casilla[] casillas = casillero.getCasillas();
		Pieza[] piezas = casillero.getPiezas();
		/*regla 1*/
		for (int i = 0; i < piezas.length; i= i+1)
		{
			if (piezas[i].getColor() == this.colorPiezas)
			{
				int casillaPieza = piezas[i].getCasilla();
				int casillasPorDelante = casillaPieza + 7;
				int casillasPorDetras = casillaPieza - 7;
				int reduccionPiezasAtacantes = 0;
				int incrementoPiezasAtacadas = 0;
				
				if (casillas[casillaPieza + dado].isEsSegura())
				{
					rating += 10;
				}
				else if (casillas[casillaPieza + dado].getPieza().getColor() != this.colorPiezas)
				{
					rating += 30;
				}
				else
				{
					for (int j = casillaPieza; j < casillasPorDelante; j++)
					{
						Pieza otraPieza = casillas[j].getPieza();
						if (otraPieza.getColor() != this.colorPiezas)
						{
							reduccionPiezasAtacantes++;
						}
					}
					for (int j = casillasPorDetras; j > casillaPieza; j++)
					{
						Pieza otraPieza = casillas[j].getPieza();
						if (otraPieza.getColor() != this.colorPiezas)
						{
							incrementoPiezasAtacadas++;
						}
					}
					rating += (3 * incrementoPiezasAtacadas) + (9 * reduccionPiezasAtacantes);
				}
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
