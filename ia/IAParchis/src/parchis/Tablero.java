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
	
	/*public void init(){
		principal = new JPanel();
		fichaPanel = new JPanel();
		ImageLabel label = new ImageLabel(new ImageIcon("D:/PFC/pictures/tablero.png"));
		ImageLabel ficha = new ImageLabel(new ImageIcon("D:/PFC/pictures/ficha_roja.png"));
		ficha.setLocation(29, 37);
		label.setLocation(29, 37);
		principal.add(label);
		fichaPanel.add(ficha);
		principal.add(fichaPanel);
		
		frame = new JFrame();
		frame.getContentPane().add(principal);
		frame.pack();
		frame.setVisible(true);
		//p = new Panel();
		
		//JLabel picLabel = new JLabel(new ImageIcon(img));
		//principal.add(picLabel);
		//principal.repaint(); 
		//p.setBackground(Color.black);
		//p.setLayout(new GridLayout(3,3,10,10));
	}
	
	/* public void ImagePanel() {
		 try
			{
			    img = ImageIO.read(new File("Tablero_parchis.png"));
			}
			catch (IOException e)
			{
			}
	    }
	
	@Override
	public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.drawImage(img, 0, 0, null); // see javadoc for more info on the parameters            
    }*/
	public Dado getDado() {
		return dado;
	}
	public void setDado(Dado dado) {
		this.dado = dado;
	}


}
