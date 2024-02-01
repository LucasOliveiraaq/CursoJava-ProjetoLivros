package com.lucaspo.CursoJava_ProjetoLivros.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageFilter;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.lucaspo.CursoJava_ProjetoLivros.DAO.LivroDAOImpl;
import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;
import com.lucaspo.CursoJava_ProjetoLivros.Model.StatusLeitura;
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

	private JLabel lblStatus;
	private JComboBox jComboBoxStatus;

	private JLabel lblImagem;
	private JTextField jTextFieldImagem;
	private JButton buttonImagem;
	private JFileChooser jFileImagem;
	
	private JButton buttonSalvar;

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
		setBounds(100, 100, 450, 218);
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
		contentPane.add(getlblStatus());
		contentPane.add(getJComboBoxStatus());
		contentPane.add(getlblImagem());
		contentPane.add(getTextFieldImagem());
		contentPane.add(getButtonImagem());
		contentPane.add(getButtonSalvar());
	}

	public JLabel getlblLivro() {
		if (lblLivro == null) {
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
			lblNumPaginas.setBounds(10, 120, 133, 22);
			lblNumPaginas.setForeground(Color.BLACK);
			lblNumPaginas.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNumPaginas.setText("Numero de Paginas");
		}
		return lblNumPaginas;
	}

	public JSpinner getjSpinnerNumPaginas() {
		if (jSpinnerNumPaginas == null) {
			jSpinnerNumPaginas = new JSpinner();
			jSpinnerNumPaginas.setBounds(145, 120, 70, 22);
		}
		return jSpinnerNumPaginas;
	}

	public JLabel getlblStatus() {
		if (lblStatus == null) {
			lblStatus = new JLabel();
			lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
			lblStatus.setBounds(130, 120, 133, 22);
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
			jComboBoxStatus.setBounds(269, 120, 108, 22);
		}
		return jComboBoxStatus;
	}

	public JLabel getlblImagem() {
		if (lblImagem == null) {
			lblImagem = new JLabel();
			lblImagem.setHorizontalAlignment(SwingConstants.RIGHT);
			lblImagem.setBounds(10, 95, 70, 22);
			lblImagem.setForeground(Color.BLACK);
			lblImagem.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblImagem.setText("Imagem");
		}
		return lblImagem;
	}

	public JTextField getTextFieldImagem() {
		if (jTextFieldImagem == null) {
			jTextFieldImagem = new JTextField();
			jTextFieldImagem.setLocation(85, 95);
			jTextFieldImagem.setSize(273, 22);
			jTextFieldImagem.setEditable(false);
		}
		return jTextFieldImagem;
	}

	public JButton getButtonImagem() {
		if (buttonImagem == null) {
			buttonImagem = new JButton();
			buttonImagem.setLocation(360, 95);
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
			buttonSalvar.setLocation(314, 150);
			buttonSalvar.setSize(65, 22);
			buttonSalvar.setText("Salvar");
			buttonSalvar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Livro livro = carregarLivro();
					new LivroDAOImpl().save(livro);
				}
			});
		}
		return buttonSalvar;
	}
	
	public Livro carregarLivro() {
		Livro livro = new Livro();
		livro.setTitulo(jTextFieldTitulo.getText());
		livro.setAutor(jTextFieldAutor.getText());
		livro.setImagemLivro(jTextFieldImagem.getText());
		livro.setNumPaginas((Integer) jSpinnerNumPaginas.getValue());
		livro.setStatusLeitura(jComboBoxStatus.getSelectedIndex());
		return livro;
	}
}
