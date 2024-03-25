package com.lucaspo.CursoJava_ProjetoLivros.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;

import com.lucaspo.CursoJava_ProjetoLivros.Model.Livro;
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

	@Override
	public List<LivroImagem>loadByLivroId(Integer idLivro) {
		return (List<LivroImagem>) em.createQuery("select li from LivroImagem li where livro_id = " + idLivro);
	}

	@Override
	public void remove(LivroImagem livroImagem) {
		em.getTransaction().begin();
		LivroImagem livroImagemRemove = em.find(LivroImagem.class, livroImagem.getId());
		em.remove(livroImagemRemove);
		em.getTransaction().commit();
		emf.close();
	}

}
