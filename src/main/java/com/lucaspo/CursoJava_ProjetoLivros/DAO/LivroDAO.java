package com.lucaspo.CursoJava_ProjetoLivros.DAO;

import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;

public interface LivroDAO {
	public void save(Livro livro);
	public java.util.List<Livro> loadAll();
}
