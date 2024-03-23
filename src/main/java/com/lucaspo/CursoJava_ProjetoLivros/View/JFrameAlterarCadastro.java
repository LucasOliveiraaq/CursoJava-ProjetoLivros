package com.lucaspo.CursoJava_ProjetoLivros.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.lucaspo.CursoJava_ProjetoLivros.Controller.LivroController;
import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;
import com.lucaspo.CursoJava_ProjetoLivros.Model.LivroImagem;
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
	
	private JTextField jTextFieldImagem;
	
	private JButton buttonAlterar;
	private JButton buttonCancelar;
	
	private LivroController livroController = new LivroController();

	public JFrameAlterarCadastro(Livro livro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getlblAlteracaoLivro());
		
		JTabbedPane tabbedPane = new JTabbedPane();
	    JPanel panelCadastro = new JPanel();
	    panelCadastro.setLayout(null);
	    panelCadastro.add(getlblTitulo());
	    panelCadastro.add(getTextFieldTitulo());
	    panelCadastro.add(getlblAutor());
	    panelCadastro.add(getTextFieldAutor());
	    panelCadastro.add(getlblNumPaginas());
	    panelCadastro.add(getjSpinnerNumPaginas());
	    panelCadastro.add(getlblStatus());
	    panelCadastro.add(getJComboBoxStatus());
	    
	    JPanel panelImagem = new JPanel();
	    panelImagem.setLayout(null);
	    panelImagem.add(getlblImagem());
	    panelImagem.add(getjButtonZoom());
	    panelImagem.add(getlblImagem());
	    panelImagem.add(getTextFieldImagem());
	    
	    tabbedPane.addTab("Cadastro", panelCadastro);
	    tabbedPane.addTab("Imagem", panelImagem);
	    tabbedPane.setSize(480, 270);
	    
	    //fora da aba
	    contentPane.add(tabbedPane);
	    contentPane.add(getButtonAlterar());
	    contentPane.add(getButtonCancelar());
		if (livro != null) {
			carregarOsCampos(livro);
		}
	}

	public JLabel getlblAlteracaoLivro() {
		if (lblAlteracaoLivro == null) {
			lblAlteracaoLivro = new JLabel();
			lblAlteracaoLivro.setBounds(85, 3, 275, 22);
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
			lblImagem.setBounds(5, 15, 460, 188);
			lblImagem.setForeground(Color.BLACK);
			lblImagem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		return lblImagem;
	}
	
	public JTextField getTextFieldImagem() {
		if (jTextFieldImagem == null) {
			jTextFieldImagem = new JTextField();
			jTextFieldImagem.setLocation(48, 205);
			jTextFieldImagem.setSize(273, 22);
			jTextFieldImagem.setEditable(false);
		}
		return jTextFieldImagem;
	}
	
	public jButtonZoom getjButtonZoom() {
		if(jButtonZoom == null) {
			jButtonZoom = new jButtonZoom();
			jButtonZoom.getJButtonZoomMin().setBounds(10, 11, 43, 18);
			jButtonZoom.getJButtonZoomMax().setBounds(77, 11, 41, 18);
			jButtonZoom.setLocation(345, 195);
			jButtonZoom.setSize(157, 53);
			jButtonZoom.getJButtonZoomMin().addActionListener(e -> {
				Integer valor = Integer.parseInt(jButtonZoom.getJLabelZoomText());
				if(valor > 10) {
					Integer valorFinal = valor - 10;
					 jButtonZoom.setJDataLabelPorcentagemText(valorFinal.toString());
					 aplicarZoom(valorFinal);
				}
			});
			jButtonZoom.getJButtonZoomMax().addActionListener(e -> {
				Integer valor = Integer.parseInt(jButtonZoom.getJLabelZoomText());
				if(valor < 200) {
					Integer valorFinal = valor + 10;
					jButtonZoom.setJDataLabelPorcentagemText(valorFinal.toString());
					 aplicarZoom(valorFinal);
				}
			});
		}
		return jButtonZoom;
	}
	
	public void aplicarZoom(int valor) {
	    ImageIcon imagemIcon = (ImageIcon) lblImagem.getIcon();
	    if (imagemIcon != null) {
	        int larguraOriginal = imagemIcon.getIconWidth();
	        int alturaOriginal = imagemIcon.getIconHeight();
	        
	        if (valor > 0) {
	            int novaLargura = (larguraOriginal * valor) / 100;
	            int novaAltura = (alturaOriginal * valor) / 100;
	            lblImagem.setSize(novaLargura, novaAltura);
	        }
	    }
	}

	public void carregarOsCampos(Livro livro) {
		jTextFieldTitulo.setText(livro.getTitulo());
		jTextFieldAutor.setText(livro.getAutor());
		jSpinnerNumPaginas.setValue(livro.getNumPaginas());
		jComboBoxStatus.setSelectedIndex(livro.getStatusLeitura());
//		BufferedImage imagem = new ImageLoader().carregarImagem(livro.getLivroImagem().getImagemLivro());
//		if (imagem != null) {
//			ImageIcon icon = new ImageIcon(imagem);
//			lblImagem.setIcon(icon);
//		}
	}
	
	public JButton getButtonAlterar() {
		if (buttonAlterar == null) {
			buttonAlterar = new JButton();
			buttonAlterar.setLocation(311, 275);
			buttonAlterar.setSize(80, 22);
			buttonAlterar.setText("Alterar");
			buttonAlterar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Livro livro;
					try {
						livro = carregarLivro();
						livroController.update(livro);
//						livro.getLivroImagem().setTamanhoImagem(Integer.parseInt(jButtonZoom.getJLabelZoomText()));
//						livro.getLivroImagem().setLivro(livroTemp);
//						livro.getLivroImagem().setImagemLivro(livro.getLivroImagem().getImagemLivro());
//						livroImagemController.saveLivroImagem(livro.getLivroImagem());
//						dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return buttonAlterar;
	}
	
	public JButton getButtonCancelar() {
		if (buttonCancelar == null) {
			buttonCancelar = new JButton();
			buttonCancelar.setLocation(390, 275);
			buttonCancelar.setSize(86, 22);
			buttonCancelar.setText("Cancelar");
			buttonCancelar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return buttonCancelar;
	}
	
	public Livro carregarLivro() throws IOException {
		Livro livro = new Livro();
		LivroImagem livroImagem = new LivroImagem();
		livro.setTitulo(jTextFieldTitulo.getText());
		livro.setAutor(jTextFieldAutor.getText());
//		byte[] imagemLivro = Files.readAllBytes(Paths.get(jTextFieldImagem.getText()));
//		livroImagem.setImagemLivro(imagemLivro);
//		livroImagem.setTamanhoImagem(Integer.parseInt(jButtonZoom.getJLabelZoomText()));
//		livro.setLivroImagem(livroImagem);
		livro.setNumPaginas((Integer) jSpinnerNumPaginas.getValue());
		livro.setStatusLeitura(jComboBoxStatus.getSelectedIndex());
		return livro;
	}
}
