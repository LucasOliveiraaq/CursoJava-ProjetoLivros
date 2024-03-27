package com.lucaspo.CursoJava_ProjetoLivros.Controller;

import java.util.List;

import com.lucaspo.CursoJava_ProjetoLivros.DAO.LivroImagemDAOImpl;
import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;
import com.lucaspo.CursoJava_ProjetoLivros.Model.LivroImagem;

public class LivroImagemController {

	LivroImagemDAOImpl livroImagemDAOImpl = new LivroImagemDAOImpl();

	public void saveLivroImagem(LivroImagem livroImagem) {
		livroImagemDAOImpl.save(livroImagem);
	}
	
	public List<LivroImagem> loadByLivroId (Integer idLivro) {
		return livroImagemDAOImpl.loadByLivroId(idLivro);
	}
	
	public void remove(LivroImagem livroImagem) {
		livroImagemDAOImpl.remove(livroImagem);
	}
	
	public LivroImagem update(LivroImagem livroImagem) {
		return livroImagemDAOImpl.update(livroImagem);
	}
	
	public LivroImagem loadByLivroImagemId(Integer idLivro) {
		return livroImagemDAOImpl.loadByLivroImagemId(idLivro);
	}
}
