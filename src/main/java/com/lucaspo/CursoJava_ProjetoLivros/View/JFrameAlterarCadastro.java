package com.lucaspo.CursoJava_ProjetoLivros.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;
import com.lucaspo.CursoJava_ProjetoLivros.Model.StatusLeitura;
import com.lucaspo.CursoJava_ProjetoLivros.Util.DocumentoTextField;
import com.lucaspo.CursoJava_ProjetoLivros.Util.ImageLoader;
import com.lucaspo.CursoJava_ProjetoLivros.Util.jButtonZoom;

public class JFrameAlterarCadastro extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblAlteracaoLivro;

	private JLabel lblTitulo;
	private JTextField jTextFieldTitulo;

	private JLabel lblAutor;
	private JTextField jTextFieldAutor;

	private JLabel lblNumPaginas;
	private JSpinner jSpinnerNumPaginas;

	private JLabel lblStatus;
	private JComboBox jComboBoxStatus;

	private JButton buttonAlteracao;

	private JLabel lblImagem;

	private Livro livro = new Livro();
	
	private jButtonZoom jButtonZoom;

	public JFrameAlterarCadastro(Livro livro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getlblAlteracaoLivro());
		contentPane.add(getlblTitulo());
		contentPane.add(getTextFieldTitulo());
		contentPane.add(getlblAutor());
		contentPane.add(getTextFieldAutor());
		contentPane.add(getlblNumPaginas());
		contentPane.add(getjSpinnerNumPaginas());
		contentPane.add(getlblStatus());
		contentPane.add(getJComboBoxStatus());
		contentPane.add(getButtonAlteracao());
		contentPane.add(getlblImagem());
		contentPane.add(getjButtonZoom());
		if (livro != null) {
			carregarOsCampos(livro);
		}
	}

	public JLabel getlblAlteracaoLivro() {
		if (lblAlteracaoLivro == null) {
			lblAlteracaoLivro = new JLabel();
			lblAlteracaoLivro.setBounds(85, 10, 275, 22);
			lblAlteracaoLivro.setForeground(Color.BLACK);
			lblAlteracaoLivro.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAlteracaoLivro.setHorizontalAlignment(SwingConstants.CENTER);
			lblAlteracaoLivro.setText("Alteração livro");
		}
		return lblAlteracaoLivro;
	}

	public JLabel getlblTitulo() {
		if (lblTitulo == null) {
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
		if (jTextFieldTitulo == null) {
			jTextFieldTitulo = new JTextField();
			jTextFieldTitulo.setLocation(85, 43);
			jTextFieldTitulo.setSize(292, 22);
			jTextFieldTitulo.setDocument(new DocumentoTextField(100));
		}
		return jTextFieldTitulo;
	}

	public JLabel getlblAutor() {
		if (lblAutor == null) {
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
		if (jTextFieldAutor == null) {
			jTextFieldAutor = new JTextField();
			jTextFieldAutor.setLocation(85, 70);
			jTextFieldAutor.setSize(292, 22);
			jTextFieldAutor.setDocument(new DocumentoTextField(50));
		}
		return jTextFieldAutor;
	}

	public JLabel getlblNumPaginas() {
		if (lblNumPaginas == null) {
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
		if (jSpinnerNumPaginas == null) {
			jSpinnerNumPaginas = new JSpinner();
			jSpinnerNumPaginas.setBounds(145, 95, 70, 22);
		}
		return jSpinnerNumPaginas;
	}

	public JLabel getlblStatus() {
		if (lblStatus == null) {
			lblStatus = new JLabel();
			lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
			lblStatus.setBounds(130, 95, 133, 22);
			lblStatus.setForeground(Color.BLACK);
			lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblStatus.setText("Status");
		}
		return lblStatus;
	}

	public JComboBox getJComboBoxStatus() {
		if (jComboBoxStatus == null) {
			jComboBoxStatus = new JComboBox();
			jComboBoxStatus.setModel(new DefaultComboBoxModel(StatusLeitura.values()));
			jComboBoxStatus.setBounds(269, 95, 108, 22);
		}
		return jComboBoxStatus;
	}

	public JButton getButtonAlteracao() {
		if (buttonAlteracao == null) {
			buttonAlteracao = new JButton();
			buttonAlteracao.setLocation(300, 130);
			buttonAlteracao.setSize(80, 22);
			buttonAlteracao.setText("Alteração");
			buttonAlteracao.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return buttonAlteracao;
	}

	public JLabel getlblImagem() {
		if (lblImagem == null) {
			lblImagem = new JLabel();
			lblImagem.setHorizontalAlignment(SwingConstants.RIGHT);
			lblImagem.setBounds(390, 43, 250, 160);
			lblImagem.setForeground(Color.BLACK);
			lblImagem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		return lblImagem;
	}
	
	public jButtonZoom getjButtonZoom() {
		if(jButtonZoom == null) {
			jButtonZoom = new jButtonZoom();
			jButtonZoom.setLocation(269, 163);
			jButtonZoom.setSize(108, 16);
		}
		return jButtonZoom;
	}

	public void carregarOsCampos(Livro livro) {
		jTextFieldTitulo.setText(livro.getTitulo());
		jTextFieldAutor.setText(livro.getAutor());
		jSpinnerNumPaginas.setValue(livro.getNumPaginas());
		jComboBoxStatus.setSelectedIndex(livro.getStatusLeitura());
//		BufferedImage imagem = new ImageLoader().carregarImagem(livro.getImagemLivro());
//		if (imagem != null) {
//			ImageIcon icon = new ImageIcon(imagem);
//			lblImagem.setIcon(icon);
//		}
	}
}
