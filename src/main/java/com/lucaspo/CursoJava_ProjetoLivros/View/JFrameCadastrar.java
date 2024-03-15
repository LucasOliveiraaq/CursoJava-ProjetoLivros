package com.lucaspo.CursoJava_ProjetoLivros.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.lucaspo.CursoJava_ProjetoLivros.Controller.LivroController;
import com.lucaspo.CursoJava_ProjetoLivros.Controller.LivroImagemController;
import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;
import com.lucaspo.CursoJava_ProjetoLivros.Model.LivroImagem;
import com.lucaspo.CursoJava_ProjetoLivros.Model.StatusLeitura;
import com.lucaspo.CursoJava_ProjetoLivros.Util.DocumentoTextField;
import com.lucaspo.CursoJava_ProjetoLivros.Util.ImageLoader;
import com.lucaspo.CursoJava_ProjetoLivros.Util.jButtonZoom;

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

	private JLabel lblStatus;
	private JComboBox jComboBoxStatus;

	private JLabel lblImagem;
	private JTextField jTextFieldImagem;
	private JButton buttonImagem;
	private JFileChooser jFileImagem;
	
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	
	private LivroController livroController = new LivroController();
	private LivroImagemController livroImagemController = new LivroImagemController();
	
	private JLabel lblCarregarImagem;
	
	private jButtonZoom jButtonZoom;
	
	public JFrameCadastrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getlblLivro());
		
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
	    panelImagem.add(getlblCarregarImagem());
	    panelImagem.add(getjButtonZoom());
	    panelImagem.add(getlblImagem());
	    panelImagem.add(getTextFieldImagem());
	    panelImagem.add(getButtonImagem());
	    
	    tabbedPane.addTab("Cadastro", panelCadastro);
	    tabbedPane.addTab("Imagem", panelImagem);
	    tabbedPane.setSize(480, 270);
	    
	    //fora da aba
	    contentPane.add(tabbedPane);
	    contentPane.add(getButtonSalvar());
	    contentPane.add(getButtonCancelar());
	}

	public JLabel getlblLivro() {
		if (lblLivro == null) {
			lblLivro = new JLabel();
			lblLivro.setBounds(180, 3, 70, 22);
			lblLivro.setForeground(Color.BLACK);
			lblLivro.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblLivro.setHorizontalAlignment(SwingConstants.CENTER);
			lblLivro.setText("Livro");
		}
		return lblLivro;
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

	public JLabel getlblImagem() {
		if (lblImagem == null) {
			lblImagem = new JLabel();
			lblImagem.setHorizontalAlignment(SwingConstants.RIGHT);
			lblImagem.setBounds(5, 205, 40, 22);
			lblImagem.setForeground(Color.BLACK);
			lblImagem.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblImagem.setText("Imagem");
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

	public JButton getButtonImagem() {
		if (buttonImagem == null) {
			buttonImagem = new JButton();
			buttonImagem.setLocation(322, 205);
			buttonImagem.setSize(18, 22);
			buttonImagem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						jFileImagem = new JFileChooser();
						jFileImagem.setDialogTitle("Procurar imagem");
						jFileImagem.setFileSelectionMode(JFileChooser.FILES_ONLY);
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem", "jpg", "Png");
						jFileImagem.setFileFilter(filter);
						
						int retorno = jFileImagem.showOpenDialog(JFrameCadastrar.this);
						
						if (retorno == JFileChooser.APPROVE_OPTION) {
							File file = jFileImagem.getSelectedFile();
							jTextFieldImagem.setText(file.getPath());
							BufferedImage imagem = new ImageLoader().carregarImagemPasta(file.getPath());
							if(imagem != null) {
								ImageIcon icon = new ImageIcon(imagem);
								lblCarregarImagem.setIcon(icon);
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		}
		return buttonImagem;
	}
	
	public JButton getButtonSalvar() {
		if (buttonSalvar == null) {
			buttonSalvar = new JButton();
			buttonSalvar.setLocation(320, 275);
			buttonSalvar.setSize(70, 22);
			buttonSalvar.setText("Salvar");
			buttonSalvar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Livro livro;
					try {
						livro = carregarLivro();
						Livro livroTemp =  livroController.saveLivro(livro);
						livro.getLivroImagem().setTamanhoImagem(10);
						livro.getLivroImagem().setLivro(livroTemp);
						livro.getLivroImagem().setImagemLivro(livro.getLivroImagem().getImagemLivro());
						livroImagemController.saveLivroImagem(livro.getLivroImagem());
						dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return buttonSalvar;
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
	
	public JLabel getlblCarregarImagem() {
		if (lblCarregarImagem == null) {
			lblCarregarImagem = new JLabel();
			lblCarregarImagem.setHorizontalAlignment(SwingConstants.CENTER);
			lblCarregarImagem.setBounds(5, 15, 460, 188);
			lblCarregarImagem.setForeground(Color.BLACK);
			lblCarregarImagem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		return lblCarregarImagem;
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
	
	public Livro carregarLivro() throws IOException {
		Livro livro = new Livro();
		LivroImagem livroImagem = new LivroImagem();
		livro.setTitulo(jTextFieldTitulo.getText());
		livro.setAutor(jTextFieldAutor.getText());
		byte[] imagemLivro = Files.readAllBytes(Paths.get(jTextFieldImagem.getText()));
		livroImagem.setImagemLivro(imagemLivro);
		livro.setLivroImagem(livroImagem);
		livro.setNumPaginas((Integer) jSpinnerNumPaginas.getValue());
		livro.setStatusLeitura(jComboBoxStatus.getSelectedIndex());
		return livro;
	}
	
	public void aplicarZoom(int valor) {
	    ImageIcon imagemIcon = (ImageIcon) lblCarregarImagem.getIcon();
	    if (imagemIcon != null) {
	        int larguraOriginal = imagemIcon.getIconWidth();
	        int alturaOriginal = imagemIcon.getIconHeight();
	        
	        if (valor > 0) {
	            int novaLargura = (larguraOriginal * valor) / 100;
	            int novaAltura = (alturaOriginal * valor) / 100;
//	            Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
//	            ImageIcon novoIcone = new ImageIcon(imagemRedimensionada);
//	            novoIcone.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
//	            lblCarregarImagem.setIcon(novoIcone);
	            lblCarregarImagem.setSize(novaLargura, novaAltura);
	        }
	    }
	}


}
