package paintPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectTypeOfPlayers extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static JFrame frame = new JFrame();
    
    private JButton jugarButton = new JButton("Jugar");
    private JLabel setjugadores = new JLabel("Elige qué jugadores manejará el ordenador");
    
	private List<Boolean> isCpu = new ArrayList<Boolean>();
	
	private JComboBox player1 = null;
    private JComboBox player2 = null;
    private JComboBox player3 = null;
    private JComboBox player4 = null;
    
    public List<Boolean> draw(int players)
    {
    	List<Boolean> jugadores = new ArrayList();
    	
    	
    	JFrame frame = new JFrame();
	    
	    frame.setPreferredSize(new Dimension(500, 250));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel tituloPanel = new JPanel();
        JPanel comboBoxPanel = new JPanel();
        JPanel botonPanel = new JPanel(); 
        
        
        setjugadores.setFont(new Font("Serif", Font.PLAIN, 20));
        jugarButton.addActionListener(this);
        
        //paneles que van dentro del gridlayout de en medio con los comboboxes
        JPanel player1Panel = new JPanel(new GridLayout(2,0));
        JPanel player2Panel = new JPanel(new GridLayout(2,0));
        JPanel player3Panel = new JPanel(new GridLayout(2,0));
        JPanel player4Panel = new JPanel(new GridLayout(2,0));
        
        JLabel player1Label = new JLabel("Amarillo", JLabel.CENTER);
        JLabel player2Label = new JLabel("Azul", JLabel.CENTER);
        JLabel player3Label = new JLabel("Rojo", JLabel.CENTER);
        JLabel player4Label = new JLabel("Verde", JLabel.CENTER);

        frame.setLayout(new GridLayout(3,0));
        comboBoxPanel.setLayout(new GridLayout(2,3)); 
        
        String[] playerTypes = {"Humano", "CPU"};
        player1 = new JComboBox(playerTypes);
        player2 = new JComboBox(playerTypes);
        player3 = new JComboBox(playerTypes);
        player4 = new JComboBox(playerTypes);
        
        //metemos los label de los player y los combobox
        player1Panel.add(player1Label);
        player1Panel.add(player1);
        player1.setEnabled(false);
        
        player2Panel.add(player2Label);
        player2Panel.add(player2);
        player2.setEnabled(false);
        
        player3Panel.add(player3Label);
        player3Panel.add(player3);
        player3.setEnabled(false);
        
        player4Panel.add(player4Label);
        player4Panel.add(player4);
        player4.setEnabled(false);
        
        List<JComboBox> comboBoxes = new ArrayList();
        comboBoxes.add(player1);
        comboBoxes.add(player2);
        comboBoxes.add(player3);
        comboBoxes.add(player4);
        
        for(int i = 0; i < players; i++)
    	{
    		comboBoxes.get(i).setEnabled(true);
    	}
        
        //añadimos los paneles con los combobox y los label a su panel de en medio
        comboBoxPanel.add(player1Panel);
        comboBoxPanel.add(player2Panel);
        comboBoxPanel.add(player3Panel);
        comboBoxPanel.add(player4Panel);
        botonPanel.add(jugarButton);
        tituloPanel.add(setjugadores);
        
        frame.add(tituloPanel);
        frame.add(comboBoxPanel);
        frame.add(botonPanel);
        
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
        
        
    	return isCpu;
    }

	public void actionPerformed(ActionEvent e)
	{
		if(player1.getSelectedItem().equals("Humano"))
		{isCpu.add(0, false);}
		else{isCpu.add(0, true);}
		
		if(player2.getSelectedItem().equals("Humano"))
		{isCpu.add(1, false);}
		else{isCpu.add(1, true);}
		
		if(player3.getSelectedItem().equals("Humano"))
		{isCpu.add(2, false);}
		else{isCpu.add(2, true);}
		
		if(player4.getSelectedItem().equals("Humano"))
		{isCpu.add(3, false);}
		else{isCpu.add(3, true);}
		
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
