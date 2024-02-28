package com.lucaspo.CursoJava_ProjetoLivros.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livroImagem")
public class LivroImagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private byte[] imagemLivro;

	@Column
	private int tamanhoImagem;

	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Livro livro;

	public LivroImagem() {
	}

	public LivroImagem(Integer id, byte[] imagemLivro, int tamanhoImagem) {
		this.id = id;
		this.imagemLivro = imagemLivro;
		this.tamanhoImagem = tamanhoImagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getImagemLivro() {
		return imagemLivro;
	}

	public void setImagemLivro(byte[] imagemLivro) {
		this.imagemLivro = imagemLivro;
	}

	public int getTamanhoImagem() {
		return tamanhoImagem;
	}

	public void setTamanhoImagem(int tamanhoImagem) {
		this.tamanhoImagem = tamanhoImagem;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
