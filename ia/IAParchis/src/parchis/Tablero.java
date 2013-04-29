package parchis;

//import java.awt.Graphics;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JApplet;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

public class Tablero /*extends JApplet */{
	private Casillero casillero = new Casillero();
	private List<Jugador> jugadores = new ArrayList<Jugador>(); /*0- amarillo; 1-azul; 2-rojo; 3-verde*/
	private Dado dado = new Dado();//null
	/*JPanel principal;
	JPanel fichaPanel;
	JFrame frame;
	BufferedImage img = null;
	Graphics g;*/
	
	private static final long serialVersionUID = 1L;
	
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
	
	public void iniciarTablero(int jugadorNumbers)
	{
		casillero.iniciarCasillero();
		casillero.iniciarPosiciones();
		for(int i = 0; i < jugadorNumbers; i++)
		{
			jugadores.add(new Jugador(i));
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
