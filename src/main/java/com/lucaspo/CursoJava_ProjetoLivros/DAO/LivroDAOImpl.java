package com.lucaspo.CursoJava_ProjetoLivros.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;

public class LivroDAOImpl implements LivroDAO{

	@Override
	public void save(Livro livro) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursoJava-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(livro);
		em.getTransaction().commit();
		emf.close();
	}

}
