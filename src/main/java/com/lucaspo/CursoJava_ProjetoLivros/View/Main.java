package com.lucaspo.CursoJava_ProjetoLivros.View;

import com.lucaspo.CursoJava_ProjetoLivros.DAO.LivroDAOImpl;
import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;

public class Main {

	public static void main(String[] args) {
				
		Livro livro = new Livro("aa", "bb", "imagem1.png", 200, 0);
		
		new LivroDAOImpl().save(livro);
		
	}

}
