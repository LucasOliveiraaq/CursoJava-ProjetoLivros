package com.lucaspo.CursoJava_ProjetoLivros.View;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lucaspo.CursoJava_ProjetoLivros.Controller.LivroController;
import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;
import com.lucaspo.CursoJava_ProjetoLivros.Model.StatusLeitura;

public class jFrameMenuInicial extends JFrame {

	JMenuBar barra = new JMenuBar();
	JMenu menuCadastrar = new JMenu("Cadastrar");
	JMenu menuSair = new JMenu("Sair");

	JMenuItem itemLivro = new JMenuItem("Livro");

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
		barra.add(menuCadastrar);
		menuCadastrar.add(itemLivro);
		itemLivro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrameCadastrar jFrameCadastrar = new JFrameCadastrar();
				jFrameCadastrar.setVisible(true);
				jFrameCadastrar.setLocationRelativeTo(null);
				jFrameCadastrar.setResizable(false);
				jFrameCadastrar.addWindowListener(new WindowListener() { // Atualizar a grid.

					@Override
					public void windowOpened(WindowEvent e) {
					}

					@Override
					public void windowIconified(WindowEvent e) {
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
					}

					@Override
					public void windowClosing(WindowEvent e) {
					}

					@Override
					public void windowClosed(WindowEvent e) {
						gridCadastroLivro();
					}

					@Override
					public void windowActivated(WindowEvent e) {
					}
				});
			}
		});
		barra.add(Box.createHorizontalGlue()); // abaixo vai alinhar a direita o menu.
		barra.add(menuSair);
		setTitle("Menu inicial do sistema");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		gridCadastroLivro();
	}

	public void gridCadastroLivro() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Titulo");
		tableModel.addColumn("Autor");
		tableModel.addColumn("Paginas");
		tableModel.addColumn("Status");
		List<Livro> list = new LivroController().loadAll();

		for (Livro livro : list) {
			Object[] objects = { livro.getTitulo(), livro.getAutor(), livro.getNumPaginas(),
					StatusLeitura.retornoDescription(livro.getStatusLeitura() + 1) // +1 porque inicia pegando o index no -1.
			};
			tableModel.addRow(objects);
		}

		JTable jTable = new JTable(tableModel);

		JPanel jPanel = new JPanel(new GridLayout(0, 1));
		jPanel.add(new JScrollPane(jTable));
		
		// Dentro do método gridCadastroLivro
		jTable.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		            int row = jTable.getSelectedRow();
		            if (row != -1) { // Verifica se a linha foi selecionada
		                String titulo = (String) tableModel.getValueAt(row, 0);
		                String autor = (String) tableModel.getValueAt(row, 1);
		                Integer numPaginas = (Integer) tableModel.getValueAt(row, 2);
		                Integer statusLeitura = StatusLeitura.retornoValue((String) tableModel.getValueAt(row, 3));

		                JFrameAlterarCadastro jFrameAlterarCadastro = new JFrameAlterarCadastro();
		                jFrameAlterarCadastro.setVisible(true);
		                jFrameAlterarCadastro.setLocationRelativeTo(null);
		                jFrameAlterarCadastro.setResizable(false);
		            }
		        }
		});

		add(jPanel);
		setSize(600, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
