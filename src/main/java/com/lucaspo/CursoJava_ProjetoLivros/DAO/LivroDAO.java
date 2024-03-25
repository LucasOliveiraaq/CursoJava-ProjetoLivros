package com.lucaspo.CursoJava_ProjetoLivros.DAO;

import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;

public interface LivroDAO {
	public Livro save(Livro livro);
	public java.util.List<Livro> loadAll();
	public Livro update(Livro livro);
	public Livro delete(Livro livro);
}
