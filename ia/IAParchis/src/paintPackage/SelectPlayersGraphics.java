package paintPackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectPlayersGraphics extends JFrame implements MouseListener {
	private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    
    private JButton jugadores2 = new JButton("2 Jugadores");
    private JButton jugadores3 = new JButton("3 Jugadores");
    private JButton jugadores4 = new JButton("4 Jugadores");
    private JLabel setjugadores = new JLabel("Selecciona el numero de jugadores");
    
    private int numeroJugadores = 0;
    private boolean botonPulsado = false;
        
    public void draw()
    {
    	
    	//jugadores2.setLayout(new BorderLayout(1, 2));
    	/*
    	
    	lpane.setVisible(true);
    	lpane.setOpaque(true);
    	lpane.setBackground(Color.blue);
    	
    	JPanel buttonPanel = new JPanel();
    	buttonPanel.add(jugadores2);
    	lpane.add(buttonPanel, new Integer(1), 0);
    	
		frame.pack();
		frame.setVisible(true); */
    	
    	frame.setPreferredSize(new Dimension(500, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frame.getContentPane();
        
        JPanel setJugadoresPanel = new JPanel();
        setjugadores.setFont(new Font("Serif", Font.PLAIN, 20));
        setJugadoresPanel.add(setjugadores, BorderLayout.CENTER);
        pane.add(setJugadoresPanel, BorderLayout.PAGE_START);
        
        jugadores2.setPreferredSize(new Dimension(110,50));
        jugadores3.setPreferredSize(new Dimension(110,50));
        jugadores4.setPreferredSize(new Dimension(110,50));
        
        jugadores2.setName("2");
        jugadores3.setName("3");
        jugadores4.setName("4");
        
        jugadores2.addMouseListener(this);
        jugadores3.addMouseListener(this);
        jugadores4.addMouseListener(this);
        
        JPanel jugadores2Panel = new JPanel();
        jugadores2Panel.add(jugadores2);
        pane.add(jugadores2Panel, BorderLayout.LINE_START);
        
        JPanel jugadores3Panel = new JPanel();
        jugadores3Panel.add(jugadores3);
        pane.add(jugadores3Panel, BorderLayout.CENTER);
        
        JPanel jugadores4Panel = new JPanel();
        jugadores4Panel.add(jugadores4);
        pane.add(jugadores4Panel, BorderLayout.LINE_END);
          
        frame.setContentPane(pane);
        frame.pack();
        frame.setVisible(true);
    }
    
    public int getNumeroJugadores()
    {
    	return numeroJugadores;
    }

	public boolean isBotonPulsado()
	{
		return botonPulsado;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("pulsado: " + e.getComponent().getName());
		numeroJugadores = Integer.parseInt(e.getComponent().getName());		
		botonPulsado = true;
		System.out.println("variable cambiada: " + numeroJugadores + ", " + botonPulsado);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    

}
