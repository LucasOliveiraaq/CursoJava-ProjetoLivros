package com.lucaspo.CursoJava_ProjetoLivros.Controller;

import java.util.List;

import com.lucaspo.CursoJava_ProjetoLivros.DAO.LivroDAOImpl;
import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;

public class LivroController {

	LivroDAOImpl livroDAOImpl = new LivroDAOImpl();
	
	public Livro saveLivro(Livro livro) {
		return livroDAOImpl.save(livro);
	}
		
	public List<Livro> loadAll(){
		 return livroDAOImpl.loadAll();
	}
}
