package paintPackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import parchis.GameClass;

public class SelectPlayersGraphics extends JFrame implements ActionListener {
	private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    
    private JButton jugadores2 = new JButton("2 Jugadores");
    private JButton jugadores3 = new JButton("3 Jugadores");
    private JButton jugadores4 = new JButton("4 Jugadores");
    private JLabel setjugadores = new JLabel("Selecciona el numero de jugadores");
    
    private int numeroJugadores = 0;
    private boolean botonPulsado = false;
    int players = 0;
        
    public int draw()
    {
    	
    	JFrame frame = new JFrame();
	    
	    JButton jugadores2 = new JButton("2 Jugadores");
	    JButton jugadores3 = new JButton("3 Jugadores");
	    JButton jugadores4 = new JButton("4 Jugadores");
	    JLabel setjugadores = new JLabel("Selecciona el numero de jugadores");
	    
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
        
        final List<Boolean> isCpu = new ArrayList<Boolean>();
		isCpu.add(0, true);
		isCpu.add(1, false);
		isCpu.add(2, false);
		isCpu.add(3, true);
		
		
        
        jugadores2.addActionListener(this);
        jugadores3.addActionListener(this);
        jugadores4.addActionListener(this);
        
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
        
        try
		{
			synchronized(this)
			{
			      this.wait(); 
			}
		}
		catch(Exception ex)
		{
			
		}
        
		return players;
		
	}

	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		System.out.println(button);
		if(button.equals("2 Jugadores"))
		{
			players = 2;
		}
		else if (button.equals("3 Jugadores"))
		{
			players = 3;
		}
		else
		{
			players = 4;
		}
		
		try
		{
			synchronized(this)
			{
			      this.notify(); 
			}
		}
		catch(Exception ex)
		{
			
		}
	}
		
}
