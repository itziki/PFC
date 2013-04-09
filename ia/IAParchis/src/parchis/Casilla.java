package parchis;

import java.util.ArrayList;
import java.util.List;

public class Casilla {
	private boolean esSegura; /*si la casilla es segura, es decir, si pueden comerse fichas o no*/
	private int numeroFichas; /*fichas que hay en la casilla. M�ximo 2*/
	private List<Pieza> piezas = new ArrayList<Pieza>(); /*piezas de esa casilla*/
	
	public Casilla (boolean esSegura)
	{
		this.esSegura = esSegura;
		this.numeroFichas = 0;
	}
	
	public boolean isEsSegura() {
		return esSegura;
	}
	public void setEsSegura(boolean esSegura) {
		this.esSegura = esSegura;
	}
	public int getNumeroFichas() {
		return numeroFichas;
	}
	public void setNumeroFichas(int numeroFichas) {
		this.numeroFichas = numeroFichas;
	}
	public List<Pieza> getPiezas() {
		return piezas;
	}
	public void setPiezas(List<Pieza> pieza) {
		this.piezas = pieza;
	}
	
	public void addPiezaToCasilla(Pieza pieza)
	{
		this.piezas.add(pieza);
	}
	
	//esta funcion mira a ver si esta en una casilla con una pieza di distinto color (osea, en un seguro) si estan haciendo
	//barrera el mismo color esta tendria que dar false y la cantidad de piezas en una casilla seria de 2
	public boolean comparteCasillaConPieza(int color)
	{
		boolean result = false;
		for (int a = 0; a < 2; a++)
		{
			//si el color de la ficha con la que esta en la casilla es distinto, comparte casilla con otra ficha
			if(piezas.get(a).getColor() != color)
			{
				result = true;
			}
		}
		return result;
	}
	
	public Pieza miPieza(int color)
	{
		Pieza miPieza = null;
		for (int a = 0; a < 2; a++)
		{
			if (piezas.get(a).getColor() == color)
			{
				miPieza = piezas.get(a);
			}
		}
		return miPieza;
	}
}
