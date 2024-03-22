package com.lucaspo.CursoJava_ProjetoLivros.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "livroImagem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

	public LivroImagem(Integer id, byte[] imagemLivro, int tamanhoImagem) {
		this.id = id;
		this.imagemLivro = imagemLivro;
		this.tamanhoImagem = tamanhoImagem;
	}	
}
