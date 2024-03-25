package com.lucaspo.CursoJava_ProjetoLivros.View;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.lucaspo.CursoJava_ProjetoLivros.Controller.LivroController;
import com.lucaspo.CursoJava_ProjetoLivros.Controller.LivroImagemController;
import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;
import com.lucaspo.CursoJava_ProjetoLivros.Model.LivroImagem;
import com.lucaspo.CursoJava_ProjetoLivros.Model.StatusLeitura;
import com.lucaspo.CursoJava_ProjetoLivros.Util.TableModel;

public class jFrameMenuInicial extends JFrame {

	JMenuBar barra = new JMenuBar();
	JMenu menuCadastrar = new JMenu("Cadastrar");
	JMenu menuRemover = new JMenu("Remover");
	JMenu menuSair = new JMenu("Sair");

	JMenuItem itemLivro = new JMenuItem("Livro");
	JMenuItem removerLivro = new JMenuItem("Remover");
	
	LivroImagemController livroImagemController = new LivroImagemController();
	
	static Integer controleRemover = 0;

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
		menuCadastrar.add(removerLivro);
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
						gridCadastroLivro(999);
					}

					@Override
					public void windowActivated(WindowEvent e) {
					}
				});
			}
		});
		removerLivro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gridCadastroLivro(controleRemover);
			}
		});
		barra.add(Box.createHorizontalGlue()); // abaixo vai alinhar a direita o menu.
		barra.add(menuSair);
		setTitle("Menu inicial do sistema");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		gridCadastroLivro(999); // 999 por conta do integer.
	}

	public void gridCadastroLivro(Integer controle) {
	    String[] columnNames = {"titulo", "autor", "numPaginas", "status"}; 
	    TableModel<Livro> tableModel = new TableModel<>(columnNames);

	    List<Livro> list = new LivroController().loadAll();

	    for (Livro livro : list) {
	    	livro.setStatus(StatusLeitura.retornoDescription(livro.getStatusLeitura()));
            tableModel.addRow(livro);
        }

        JTable jTable = new JTable(tableModel);

        JPanel jPanel = new JPanel(new GridLayout(0, 1));
        jPanel.add(new JScrollPane(jTable));

        jTable.addMouseListener(new MouseAdapter() {
        	@Override
    		public void mouseClicked(MouseEvent e) {
        		if(e.getClickCount() == 2) {
        			int row = jTable.getSelectedRow();
    				if (row != -1) {
    					Livro livroSelecionado = tableModel.getObjectAt(row);
    					JFrameAlterarCadastro jFrameAlterarCadastro = new JFrameAlterarCadastro(livroSelecionado);
    					jFrameAlterarCadastro.setVisible(true);
    					jFrameAlterarCadastro.setLocationRelativeTo(null);
    					jFrameAlterarCadastro.setResizable(false);
    				}
        		} else {
        			int row = jTable.getSelectedRow();
                	if(row == -1) {
                		JOptionPane.showMessageDialog(null, "Selecione uma linha para exclusão.", "Exclusão", 0);
                		return;
                	}
                	Livro livroSelecionado = tableModel.getObjectAt(row);
                	List<LivroImagem> listImagems = new LivroImagemController().loadByLivroId(livroSelecionado.getId());
                	listImagems.forEach(imagens -> livroImagemController.remove(imagens));
        		}
        	}
        });
        
//        if(controle == controleRemover) {
//        	int row = jTable.getSelectedRow();
//        	if(row == -1) {
//        		JOptionPane.showMessageDialog(null, "Selecione uma linha para exclusão.", "Exclusão", 0);
//        		return;
//        	}
//        	Livro livroSelecionado = tableModel.getObjectAt(row);
//        	List<LivroImagem> listImagems = new LivroImagemController().loadByLivroId(livroSelecionado.getId());
//        	listImagems.forEach(imagens -> livroImagemController.remove(imagens));
//        } else {
//        	jTable.addMouseListener(new MouseAdapter() {
//        		@Override
//        		public void mouseClicked(MouseEvent e) {
//        			if(e.getClickCount() == 2) {
//        				int row = jTable.getSelectedRow();
//        				if (row != -1) {
//        					Livro livroSelecionado = tableModel.getObjectAt(row);
//        					JFrameAlterarCadastro jFrameAlterarCadastro = new JFrameAlterarCadastro(livroSelecionado);
//        					jFrameAlterarCadastro.setVisible(true);
//        					jFrameAlterarCadastro.setLocationRelativeTo(null);
//        					jFrameAlterarCadastro.setResizable(false);
//        				}
//        			}
//        		}
//        	});
//        }

        add(jPanel);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
	}
}
