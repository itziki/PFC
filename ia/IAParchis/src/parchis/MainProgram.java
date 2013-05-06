package parchis;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import paintPackage.SelectPlayersGraphics;
import paintPackage.TableroGraphics;

import minimaxAlgorithm.ParchisProblem;
import formulation.State;

public class MainProgram
{	    
	public static void main(String [ ] args)
	{
		GameClass game = new GameClass();
		List<Boolean> isCpu = new ArrayList<Boolean>();
		isCpu.add(0, true);
		isCpu.add(1, true);
		isCpu.add(2, true);
		game.play(1, isCpu);
		
		//Seleccionar el numero de jugadores
		/*
		final List<Boolean> isCpu = new ArrayList<Boolean>();
		isCpu.add(0, true);
		isCpu.add(1, false);
		
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
        
        jugadores2.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				System.out.println("pulsado: " + e.getComponent().getName());
				GameClass game = new GameClass();
				game.play(Integer.parseInt(e.getComponent().getName()), isCpu);
				
			}
		});
        jugadores3.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				System.out.println("pulsado: " + e.getComponent().getName());
				GameClass game = new GameClass();
				game.play(Integer.parseInt(e.getComponent().getName()), isCpu);
			}
		});
        jugadores4.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}	
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				System.out.println("pulsado: " + e.getComponent().getName());
				GameClass game = new GameClass();
				game.play(Integer.parseInt(e.getComponent().getName()), isCpu);
			}
		});
        
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
        */
	}

}
