package com.lucaspo.CursoJava_ProjetoLivros.DAO;

import java.util.List;

import com.lucaspo.CursoJava_ProjetoLivros.Model.LivroImagem;

public interface LivroImagemDAO {

	public void save(LivroImagem livroImagem);
	public List<LivroImagem>  loadByLivroId(Integer idLivro);
	public void remove (LivroImagem livroImagem);
}
