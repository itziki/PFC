package parchis;

public class Casilla {
	private boolean esSegura; /*si la casilla es segura, es decir, si pueden comerse fichas o no*/
	private int numeroFichas; /*fichas que hay en la casilla. Máximo 2*/
	private Pieza[] pieza;
	
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
	public Pieza[] getPiezas() {
		return pieza;
	}
	public void setPiezas(Pieza[] pieza) {
		this.pieza = pieza;
	}
	
	public boolean comparteCasillaConPieza(int color)
	{
		boolean result = false;
		for (int a = 0; a < 2; a++)
		{
			//si el color de la ficha con al que esta en la casilla es distinto, comparte casilla con otra ficha
			if(pieza[a].getColor() != color)
			{
				result = true;
			}
		}
		return result;
	}
}
