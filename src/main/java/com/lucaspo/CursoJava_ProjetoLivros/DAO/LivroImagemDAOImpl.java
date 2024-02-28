package com.lucaspo.CursoJava_ProjetoLivros.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;

import com.lucaspo.CursoJava_ProjetoLivros.Model.LivroImagem;

public class LivroImagemDAOImpl implements LivroImagemDAO{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursoJava-jpa");
	EntityManager em = emf.createEntityManager();
	SessionFactory sessionFactory;

	@Override
	public void save(LivroImagem livroImagem) {
		em.getTransaction().begin();
		em.merge(livroImagem);
		em.getTransaction().commit();
		emf.close();
	}

}
