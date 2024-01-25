package com.lucaspo.CursoJava_ProjetoLivros.View;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class jFrameMenuInicial extends JFrame {
	
	JMenuBar barra = new JMenuBar();
	JMenu menu1 = new JMenu("Cadastrar");
	JMenu menu2 = new JMenu("Sair");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrameMenuInicial frame = new jFrameMenuInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public jFrameMenuInicial() {
		setJMenuBar(barra);
		barra.add(menu1);
		barra.add(Box.createHorizontalGlue()); //abaixo vai alinhar a direita o menu.
		barra.add(menu2);
		setTitle("Menu inicial do sistema");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
