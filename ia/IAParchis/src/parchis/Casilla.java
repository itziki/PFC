package parchis;

public class Casilla {
	private boolean esSegura; /*si la casilla es segura, es decir, si pueden comerse fichas o no*/
	private Integer[] numeroFichas; /*fichas que hay en la casilla. M�ximo 2*/
	private Pieza pieza;
	
	public boolean isEsSegura() {
		return esSegura;
	}
	public void setEsSegura(boolean esSegura) {
		this.esSegura = esSegura;
	}
	public Integer[] getNumeroFichas() {
		return numeroFichas;
	}
	public void setNumeroFichas(Integer[] numeroFichas) {
		this.numeroFichas = numeroFichas;
	}
	public Pieza getPieza() {
		return pieza;
	}
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
}
