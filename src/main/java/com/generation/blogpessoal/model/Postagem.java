package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity //A classe vai virar uma entidade do banco de dados
@Table(name = "tb_postagens") //nomeando a tabela do banco de dados do blogPessoal

public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Tornando a chave primária auto increment
	private Long id;
	
	@NotBlank(message = "O atributo titulo é Obrigatório!!") // Está avisando que é notnull
	@Size(min = 5, max = 100, message = "O atributo titulo deve conter no mínimo 05 e no máximo 100 caracteres") // aqui é para dizer o tamanho dos caracteres
	private String titulo;

	@NotBlank(message = "O atributo titulo é Obrigatório")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
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
	
	
}
