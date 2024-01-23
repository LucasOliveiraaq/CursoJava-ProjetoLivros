package com.lucaspo.CursoJava_ProjetoLivros.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String titulo;
	@Column
	private String autor;
	@Column
	private String imagemLivro;
	@Column
	private Integer numPaginas;
	@Column
	private Integer statusLeitura;
	
	public Livro() {
	}

	public Livro(String titulo, String autor, String imagemLivro, Integer numPaginas, Integer statusLeitura) {
		this.titulo = titulo;
		this.autor = autor;
		this.imagemLivro = imagemLivro;
		this.numPaginas = numPaginas;
		this.statusLeitura = statusLeitura;
	}

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImagemLivro() {
		return imagemLivro;
	}

	public void setImagemLivro(String imagemLivro) {
		this.imagemLivro = imagemLivro;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}

	public Integer getStatusLeitura() {
		return statusLeitura;
	}

	public void setStatusLeitura(Integer statusLeitura) {
		this.statusLeitura = statusLeitura;
	}
}
