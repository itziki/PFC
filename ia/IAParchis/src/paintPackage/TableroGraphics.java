package paintPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import parchis.Casillero;
import parchis.Partida;
import parchis.Pieza;

public class TableroGraphics extends JPanel{
	
	private static final long serialVersionUID = 1L;
	static BufferedImage tableroImg = null;
	private static JPanel tableroJPanel = new JPanel();
	
	private static JFrame frame = new JFrame();
    private static JLayeredPane lpane = new JLayeredPane();
    private static List<JPanel> fichasJPanel = new ArrayList<JPanel>();
    
    private List<Point> posicionesIniciales = new ArrayList<Point>();
	
		
	public TableroGraphics(Partida p)
	{
		int numeroPiezas = p.getTablero().getCasillero().getPiezas().size();
		Casillero casillero = p.getTablero().getCasillero();
		List<Pieza> piezas = p.getTablero().getCasillero().getPiezas();
		for(int i = 0; i < numeroPiezas; i++)
		{
			JPanel jpanel = new JPanel();
	        JButton ficha = new JButton();
	        this.iniciarPosiciones();
	        Point posicion;
	        if(piezas.get(i).getCasilla() == 104)
	        {

		        posicion = posicionesIniciales.get(i);
	        }
	        else
	        {
	        	System.out.println(piezas.get(i).getCasilla());
	        	posicion = casillero.getCasillas().get(piezas.get(i).getCasilla()).getPosicion();
	        }
	        
			switch(piezas.get(i).getColor())
			{
			case 0: //amarillo				
		        jpanel.setBounds(posicion.x, posicion.y, 25, 25);
		        jpanel.setOpaque(false);
		        fichasJPanel.add(i, jpanel);
		        
		        ficha.setBackground(Color.yellow);
		        ficha.setPreferredSize(new Dimension(20,20));
		        fichasJPanel.get(i).add(ficha);
				break;
			case 1: //azul				
		        jpanel.setBounds(posicion.x, posicion.y, 25, 25);
		        jpanel.setOpaque(false);
		        fichasJPanel.add(i, jpanel);
		        
		        ficha.setBackground(Color.blue);
		        ficha.setPreferredSize(new Dimension(20,20));
		        fichasJPanel.get(i).add(ficha);
				break;
			case 2: //rojo				
		        jpanel.setBounds(posicion.x, posicion.y, 25, 25);
		        jpanel.setOpaque(false);
		        fichasJPanel.add(i, jpanel);
		        
		        ficha.setBackground(Color.red);
		        ficha.setPreferredSize(new Dimension(20,20));
		        fichasJPanel.get(i).add(ficha);
				break;
			case 3: //verde
				jpanel.setBounds(posicion.x, posicion.y, 25, 25);
		        jpanel.setOpaque(false);
		        fichasJPanel.add(i, jpanel);
		        
		        ficha.setBackground(Color.green);
		        ficha.setPreferredSize(new Dimension(20,20));
		        fichasJPanel.get(i).add(ficha);
				break;
			}
		}
	}
	
	private void iniciarPosiciones()
	{
		//amarillas
		posicionesIniciales.add(0, new Point(320, 100));
		posicionesIniciales.add(1, new Point(320, 50));
		posicionesIniciales.add(2, new Point(370, 50));
		posicionesIniciales.add(3, new Point(370, 100));
		
		//azul
		posicionesIniciales.add(4, new Point(50, 50));
		posicionesIniciales.add(5, new Point(100, 50));
		posicionesIniciales.add(6, new Point(50, 100));
		posicionesIniciales.add(7, new Point(100, 100));
		
		//rojo
		posicionesIniciales.add(8, new Point(50, 320));
		posicionesIniciales.add(9, new Point(50, 370));
		posicionesIniciales.add(10, new Point(100, 320));
		posicionesIniciales.add(11, new Point(100, 370));
		
		//verde
		posicionesIniciales.add(12, new Point(320, 320));
		posicionesIniciales.add(13, new Point(320, 370));
		posicionesIniciales.add(14, new Point(370, 320));
		posicionesIniciales.add(15, new Point(370, 370));
	}
	
	public void clear()
	{
		
    }
	
	public void draw()
	{
		try
		{
			tableroImg = ImageIO.read(new File("D:/PFC/pictures/tablero_con_casillas.png"));
		}
		catch (IOException e){}
				
		JLabel imgJLabel = new JLabel(new ImageIcon(tableroImg));
		
		//inicializar el array de fichas del tablero
		
		frame.setPreferredSize(new Dimension(500, 500));
        frame.setLayout(new BorderLayout());
        frame.add(lpane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lpane.setBounds(0, 0, 500, 500);
        tableroJPanel.add(imgJLabel);
        tableroJPanel.setBounds(0, 0, tableroImg.getWidth(), tableroImg.getHeight());
        tableroJPanel.setOpaque(false);
        
       /* JPanel jpanel1 = new JPanel();
        jpanel1.setBounds(50, 50, 25, 25);
        jpanel1.setOpaque(false);
        fichasJPanel.add(0, jpanel1);
        
        JPanel jpanel2 = new JPanel();
        jpanel2.setBounds(300, 300, 25, 25);
        jpanel2.setOpaque(false);
        fichasJPanel.add(1, jpanel2);
        
        
//ficha 1
        /*JButton ficha = new JButton();
        ficha.setBackground(Color.RED);
        ficha.setPreferredSize(new Dimension(20,20));
        //fichasJPanel.setBounds(50, 50, 25, 25);
        //fichasJPanel.setOpaque(false);
        fichasJPanel.get(0).add(ficha);
        
//ficha 2
        JButton ficha2 = new JButton();
        ficha2.setBackground(Color.blue);
        ficha2.setPreferredSize(new Dimension(20,20));
        //fichasJPanel.setBounds(300, 300, 25, 25);
        //fichasJPanel.setOpaque(false);
        fichasJPanel.get(1).add(ficha2);*/
        
        
        lpane.add(tableroJPanel, new Integer(0), 0);
        for(int i = 0; i < fichasJPanel.size(); i++)
        {
        	lpane.add(fichasJPanel.get(i), new Integer(i), 0);
        }
        frame.pack();
        frame.setVisible(true);
    }
	
}
