package com.lucaspo.CursoJava_ProjetoLivros.Util;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class jButtonZoom extends JPanel implements ActionListener {

	private int zoom = 100; // Nível de zoom inicial
	private JLabel jLabelZoom;

	public jButtonZoom() {
		JButton jButtonZoomMax = new JButton("+");
        JButton jButtonZoomMin = new JButton("-");
        jLabelZoom = new JLabel("" + zoom);
        
        jButtonZoomMax.addActionListener(this);
        jButtonZoomMin.addActionListener(this);
        
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(jButtonZoomMax);
        buttonPanel.add(jButtonZoomMin);
        add(buttonPanel, BorderLayout.WEST);
        add(jLabelZoom, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 String command = e.getActionCommand();
	        if (command.equals("-")) {
	        	zoom -= 10;
	            if (zoom < 10) {
	            	zoom = 10;
	            }
	        } else if (command.equals("+")) {
	        	zoom += 10;
	            if (zoom > 200) {
	            	zoom = 200;
	            }
	        }

	        jLabelZoom.setText("" + zoom);
	}

	public JLabel getjLabelZoom() {
		return jLabelZoom;
	}

	public void setjLabelZoom(JLabel jLabelZoom) {
		this.jLabelZoom = jLabelZoom;
	}
}
