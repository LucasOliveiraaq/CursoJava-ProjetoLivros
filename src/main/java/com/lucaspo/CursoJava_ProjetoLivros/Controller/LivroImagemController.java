package com.lucaspo.CursoJava_ProjetoLivros.Controller;

import com.lucaspo.CursoJava_ProjetoLivros.DAO.LivroImagemDAOImpl;
import com.lucaspo.CursoJava_ProjetoLivros.Model.LivroImagem;

public class LivroImagemController {

	LivroImagemDAOImpl livroImagemDAOImpl = new LivroImagemDAOImpl();

	public void saveLivroImagem(LivroImagem livroImagem) {
		livroImagemDAOImpl.save(livroImagem);
	}

}
