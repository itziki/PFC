package parchis;

import java.util.ArrayList;
import java.util.List;


public class Tablero {
	private Casillero casillero = new Casillero();
	private List<Jugador> jugadores = new ArrayList<Jugador>(); /*0- amarillo; 1-azul; 2-rojo; 3-verde*/
	private Dado dado = new Dado();//null
	
	public Tablero()
	{
		
	}
	
	public Casillero getCasillero() {
		return casillero;
	}
	public void setCasillero(Casillero casillero) {
		this.casillero = casillero;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugador) {
		this.jugadores = jugador;
	}
	
	public void iniciarTablero(int jugadorNumbers, List<Boolean> cpu)
	{
		casillero.iniciarCasillero();
		casillero.iniciarPosiciones();
		for(int i = 0; i < jugadorNumbers; i++)
		{
			jugadores.add( new Jugador(i, cpu.get(i)));
		}
	}
	
	public Tablero clone()
	{
		Tablero tableroCloned = new Tablero();
		
		List<Jugador> newJugadores = new ArrayList<Jugador>();
		for(int i = 0; i < jugadores.size(); i++)
		{
			newJugadores.add(jugadores.get(i).clone());
		}
		
		tableroCloned.setCasillero(this.casillero.clone());
		tableroCloned.setJugadores(newJugadores);
		tableroCloned.setDado(dado);
		return tableroCloned;		
	}

	public Dado getDado() {
		return dado;
	}
	public void setDado(Dado dado) {
		this.dado = dado;
	}


}
