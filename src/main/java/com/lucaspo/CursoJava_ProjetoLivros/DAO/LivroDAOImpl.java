package com.lucaspo.CursoJava_ProjetoLivros.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;

import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;

public class LivroDAOImpl implements LivroDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursoJava-jpa");
	EntityManager em = emf.createEntityManager();
	SessionFactory sessionFactory;

	@Override
	public Livro save(Livro livro) {
		em.getTransaction().begin();
		Livro livro2 =  em.merge(livro);
		em.getTransaction().commit();
		emf.close();
		return livro2;
	}

	@Override
	public List<Livro> loadAll() {
	    try {
	        TypedQuery<Livro> query = em.createQuery("SELECT l FROM Livro l", Livro.class);
	        return query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public Livro update(Livro livro) {
		em.getTransaction().begin();
		Livro livro2 =  em.merge(livro);
		em.getTransaction().commit();
		emf.close();
		return livro2;
	}
}
