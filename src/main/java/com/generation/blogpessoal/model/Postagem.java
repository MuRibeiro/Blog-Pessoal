package com.generation.blogpessoal.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//indica ao spring que o objeto vai virar uma tabela no banco de dados
@Entity

//definir um nome para a tabela no banco de dados
@Table(name = "tb_postagens")

public class Postagem {
	
	//indica a chave primaria da tabela
	@Id
	
	//equivalente ao auto_increment na criação da chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotBlank - garante que o campo seja preenchido. @Size - define o tamanho do campo
	@NotBlank(message = "O atributo título é Obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "O atributo texto é Obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String texto;
	
	//pega a hora e data atual que foi feita a postagem
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}


