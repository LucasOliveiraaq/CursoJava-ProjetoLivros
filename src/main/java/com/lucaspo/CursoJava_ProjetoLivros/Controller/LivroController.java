package com.lucaspo.CursoJava_ProjetoLivros.Controller;

import com.lucaspo.CursoJava_ProjetoLivros.DAO.LivroDAOImpl;
import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;

public class LivroController {

	LivroDAOImpl livroDAOImpl;
	
	public void saveLivro(Livro livro) {
		livroDAOImpl.save(livro);
	}
}
