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
    private List<Point> posiciones = new ArrayList<Point>();
	
    public void setVariables(Partida p)
    {
    	int numeroPiezas = p.getTablero().getCasillero().getPiezas().size();
		Casillero casillero = p.getTablero().getCasillero();
		List<Pieza> piezas = p.getTablero().getCasillero().getPiezas();
		//fichasJPanel.clear();
		for(int i = 0; i < numeroPiezas; i++)
		{
			JPanel jpanel = new JPanel();
	        Point posicion;
	        if(piezas.get(i).getCasilla() == 104)
	        {
	        	System.out.println(i);
		        posicion = posicionesIniciales.get(i);
	        }
	        else
	        {
	        	//posicion = casillero.getCasillas().get(piezas.get(i).getCasilla()).getPosicion();
	        	posicion = posiciones.get(piezas.get(i).getCasilla());
	        	System.out.println("...................."+ piezas.get(i).getCasilla() + posicion.x + ", " + posicion.y);
	        }
	        		
	        jpanel = fichasJPanel.get(i);
	        jpanel.setBounds(posicion.x, posicion.y, 25, 25);
	        jpanel.setOpaque(false);		
		}
    }
		
	public TableroGraphics(Partida p)
	{
		int numeroPiezas = p.getTablero().getCasillero().getPiezas().size();
		Casillero casillero = p.getTablero().getCasillero();
		List<Pieza> piezas = p.getTablero().getCasillero().getPiezas();
		this.iniciarPosiciones();
		fichasJPanel.clear();
		for(int i = 0; i < numeroPiezas; i++)
		{
			JPanel jpanel = new JPanel();
	        JButton ficha = new JButton();
	        Point posicion;
	        if(piezas.get(i).getCasilla() == 104)
	        {
	        	System.out.println(i);
		        posicion = posicionesIniciales.get(i);
	        }
	        else
	        {
	        	//posicion = casillero.getCasillas().get(piezas.get(i).getCasilla()).getPosicion();
	        	posicion = posiciones.get(piezas.get(i).getCasilla());
	        	System.out.println("...................."+ piezas.get(i).getCasilla() + posicion.x + ", " + posicion.y);
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
		
		posiciones.add(0, new Point(325, 164));
		/*posiciones.add(12, new Point(305, 164));
		posiciones.add(13, new Point(285, 164));
		posiciones.add(14, new Point(265, 164));
		posiciones.add(15, new Point(253, 151));		
		posiciones.add(16, new Point(253, 131));		
		posiciones.add(17, new Point(253, 111));
		posiciones.add(4, new Point(253, 91));
		posiciones.add(18, new Point(253, 71));
		posiciones.add(19, new Point(253, 51));		
		posiciones.add(20, new Point(253, 31));
		posiciones.add(21, new Point(253, 11));
		posiciones.add(5, new Point(207, 11));
		posiciones.add(22, new Point(161, 11));
		posiciones.add(23, new Point(161, 31));
		posiciones.add(24, new Point(161, 51));
		posiciones.add(25, new Point(161, 71));
		posiciones.add(1, new Point(161, 91));
		posiciones.add(26, new Point(161, 111));
		posiciones.add(27, new Point(161, 131));
		posiciones.add(28, new Point(161, 151));		
		posiciones.add(29, new Point(148, 164));
		posiciones.add(30, new Point(128, 164));
		posiciones.add(31, new Point(108, 164));
		posiciones.add(6, new Point(88, 164));		
		posiciones.add(32, new Point(68, 164));
		posiciones.add(33, new Point(48, 164));
		posiciones.add(34, new Point(28, 164));
		posiciones.add(35, new Point(8, 164));
		posiciones.add(7, new Point(8, 210));
		posiciones.add(36, new Point(8, 256));
		posiciones.add(37, new Point(28, 256));
		posiciones.add(38, new Point(48, 256));
		posiciones.add(39, new Point(68, 256));
		posiciones.add(3, new Point(88, 256));		
		posiciones.add(40, new Point(108, 256));
		posiciones.add(41, new Point(128, 256));
		posiciones.add(42, new Point(148, 256));
		posiciones.add(43, new Point(161, 269));
		posiciones.add(44, new Point(161, 289));
		posiciones.add(45, new Point(161, 309));
		posiciones.add(8, new Point(161, 329));
		posiciones.add(46, new Point(161, 349));
		posiciones.add(47, new Point(161, 369));
		posiciones.add(48, new Point(161, 389));
		posiciones.add(49, new Point(161, 409));
		posiciones.add(9, new Point(207, 409));
		posiciones.add(50, new Point(253, 409));
		posiciones.add(51, new Point(253, 389));
		posiciones.add(52, new Point(253, 369));
		posiciones.add(53, new Point(253, 349));
		posiciones.add(3, new Point(253, 329));
		posiciones.add(54, new Point(253, 309));
		posiciones.add(55, new Point(253, 289));
		posiciones.add(56, new Point(253, 269));
		posiciones.add(57, new Point(266, 256));
		posiciones.add(58, new Point(286, 256));
		posiciones.add(59, new Point(306, 256));
		posiciones.add(10, new Point(326, 256));
		posiciones.add(60, new Point(346, 256));
		posiciones.add(61, new Point(366, 256));
		posiciones.add(62, new Point(386, 256));
		posiciones.add(63, new Point(406, 256));
		posiciones.add(11, new Point(406, 210));
		posiciones.add(64, new Point(406, 164));
		posiciones.add(65, new Point(386, 164));		
		posiciones.add(66, new Point(366, 164));
		posiciones.add(67, new Point(346, 164));
			
		//pasillo amarillo - 72..79
				 
		posiciones.add(72, new Point(386, 210));
		posiciones.add(73, new Point(366, 210));
		posiciones.add(74, new Point(346, 210));
		posiciones.add(75, new Point(326, 210));
		posiciones.add(76, new Point(306, 210));
		posiciones.add(77, new Point(286, 210));
		posiciones.add(78, new Point(266, 210));
		posiciones.add(79, new Point(240, 210)); //casilla final
		 
		//pasillo azul - 80..87
		
		posiciones.add(80, new Point(207, 30));
		posiciones.add(81, new Point(207, 50));
		posiciones.add(82, new Point(207, 70));
		posiciones.add(83, new Point(207, 90));
		posiciones.add(84, new Point(207, 110));
		posiciones.add(85, new Point(207, 130));
		posiciones.add(86, new Point(207, 150));
		posiciones.add(87, new Point(207, 176)); //casilla final
		
		//pasillo rojo - 88..95
		
		posiciones.add(88, new Point(28, 210));
		posiciones.add(89, new Point(48, 210));
		posiciones.add(90, new Point(68, 210));
		posiciones.add(91, new Point(88, 210));
		posiciones.add(92, new Point(108, 210));
		posiciones.add(93, new Point(128, 210));
		posiciones.add(94, new Point(148, 210));
		posiciones.add(95, new Point(171, 210)); //casilla final
		
		 //pasillo verde - 96..103
		
		posiciones.add(96, new Point(207, 389));
		posiciones.add(97, new Point(207, 369));
		posiciones.add(98, new Point(207, 349));
		posiciones.add(99, new Point(207, 329));
		posiciones.add(100, new Point(207, 309));
		posiciones.add(101, new Point(207, 289));
		posiciones.add(102, new Point(207, 269));
		posiciones.add(103, new Point(207, 246)); //casilla final */
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
        
        lpane.add(tableroJPanel, new Integer(0), 0);
        for(int i = 0; i < fichasJPanel.size(); i++)
        {
        	lpane.add(fichasJPanel.get(i), new Integer(i), 0);
        }
        frame.pack();
        frame.setVisible(true);
    }
	
}
