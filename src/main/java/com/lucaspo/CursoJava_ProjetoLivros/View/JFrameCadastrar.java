package com.lucaspo.CursoJava_ProjetoLivros.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.lucaspo.CursoJava_ProjetoLivros.Util.DocumentoTextField;

public class JFrameCadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblLivro;
	
	private JLabel lblTitulo;
	private JTextField jTextFieldTitulo;
	
	private JLabel lblAutor;
	private JTextField jTextFieldAutor;
	
	private JLabel lblNumPaginas;
	private JSpinner jSpinnerNumPaginas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameCadastrar frame = new JFrameCadastrar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrameCadastrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getlblLivro());
		contentPane.add(getlblTitulo());
		contentPane.add(getTextFieldTitulo());
		contentPane.add(getlblAutor());
		contentPane.add(getTextFieldAutor());
		contentPane.add(getlblNumPaginas());
		contentPane.add(getjSpinnerNumPaginas());
	}
	
	public JLabel getlblLivro() {
		if(lblLivro == null) {
			lblLivro = new JLabel();
			lblLivro.setBounds(180, 10, 70, 22);
			lblLivro.setForeground(Color.BLACK);
			lblLivro.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblLivro.setHorizontalAlignment(SwingConstants.CENTER);
			lblLivro.setText("Livro");
		}
		return lblLivro;
	}
	
	public JLabel getlblTitulo() {
		if(lblTitulo == null) {
			lblTitulo = new JLabel();
			lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTitulo.setBounds(10, 43, 70, 22);
			lblTitulo.setForeground(Color.BLACK);
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblTitulo.setText("Titulo");
		}
		return lblTitulo;
	}
	
	public JTextField getTextFieldTitulo() {
		if(jTextFieldTitulo == null) {
			jTextFieldTitulo = new JTextField();
			jTextFieldTitulo.setLocation(85, 43);
			jTextFieldTitulo.setSize(292, 22);
			jTextFieldTitulo.setDocument(new DocumentoTextField(100));
		}
		return jTextFieldTitulo;
	}
	
	public JLabel getlblAutor() {
		if(lblAutor == null) {
			lblAutor = new JLabel();
			lblAutor.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAutor.setBounds(10, 70, 70, 22);
			lblAutor.setForeground(Color.BLACK);
			lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblAutor.setText("Autor");
		}
		return lblAutor;
	}
	
	public JTextField getTextFieldAutor() {
		if(jTextFieldAutor == null) {
			jTextFieldAutor = new JTextField();
			jTextFieldAutor.setLocation(85, 70);
			jTextFieldAutor.setSize(292, 22);
			jTextFieldAutor.setDocument(new DocumentoTextField(50));
		}
		return jTextFieldAutor;
	}
	
	public JLabel getlblNumPaginas() {
		if(lblNumPaginas == null) {
			lblNumPaginas = new JLabel();
			lblNumPaginas.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNumPaginas.setBounds(10, 95, 133, 22);
			lblNumPaginas.setForeground(Color.BLACK);
			lblNumPaginas.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNumPaginas.setText("Numero de Paginas");
		}
		return lblNumPaginas;
	}
	
	public JSpinner getjSpinnerNumPaginas() {
		if(jSpinnerNumPaginas == null) {
			jSpinnerNumPaginas = new JSpinner();
			jSpinnerNumPaginas.setBounds(145, 95, 70, 22);
		}
		return jSpinnerNumPaginas;
	}

}
