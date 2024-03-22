package com.lucaspo.CursoJava_ProjetoLivros.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "livro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 100)
	private String titulo;
	@Column(nullable = false, length = 50)
	private String autor;
	@Column
	private Integer numPaginas;
	@Column(nullable = false)
	private Integer statusLeitura;
	@Transient
	private String status; // retornar o statusLeitura String  	
	@Transient
	private LivroImagem livroImagem;
	
	public Livro(String titulo, String autor, byte[] imagemLivro, Integer numPaginas, Integer statusLeitura) {
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
		this.statusLeitura = statusLeitura;
	}
	
	public Livro(String titulo, String autor, Integer numPaginas, Integer statusLeitura) {
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
		this.statusLeitura = statusLeitura;
	}
}
