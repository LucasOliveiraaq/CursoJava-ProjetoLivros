package com.lucaspo.CursoJava_ProjetoLivros.Util;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class jButtonZoom extends JPanel {

	private int zoom = 100; // Nível de zoom inicial
	private JLabel jLabelZoom;
	private JButton jButtonZoomMax;
	private JButton jButtonZoomMin;
	
	 public jButtonZoom() {
	    	super();
	    	initialize();
	    }

		private void initialize() {
			this.setLayout(null);
			this.setBounds(0, 0, 333, 20);
			this.setPreferredSize(new Dimension(157, 33));
			this.add(getJButtonZoomMax());
			this.add(getJButtonZoomMin());
			this.add(getJLabelZoom());
			jLabelZoom.setText("" + zoom);
		}
		
		public JButton getJButtonZoomMax() {
			if (jButtonZoomMax == null) {
				jButtonZoomMax = new JButton();
				jButtonZoomMax.setBounds(106, 11, 30, 18);
				jButtonZoomMax.setText("+");
			}
			return jButtonZoomMax;
		}
		
		public JButton getJButtonZoomMin() {
			if (jButtonZoomMin == null) {
				jButtonZoomMin = new JButton();
				jButtonZoomMin.setBounds(23, 11, 30, 18);
				jButtonZoomMin.setText("-");
			}
			return jButtonZoomMin;
		}
		
		private JLabel getJLabelZoom() {
			if (jLabelZoom == null){
				jLabelZoom = new JLabel();
				jLabelZoom.setBounds(53, 11, 52, 18);
			}
			return jLabelZoom;
		}

	    public void setJDataLabelPorcentagemText(String text) {
	    	getJLabelZoom().setText(text);
	    }
	    
	    public String getJLabelZoomText() {
	    	return jLabelZoom.getText();
	    }
}
