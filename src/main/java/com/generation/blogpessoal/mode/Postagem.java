package com.generation.blogpessoal.mode;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagens") //CREATE TABLE tb_postagens();

public class Postagem {

	@Id //PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
	private Long id;
	
	@NotBlank(message = "O atributo nome titulo é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo titulo deve ter no mínimo 5 e no máximo 100 caracter obrigatório")
	@Column(length = 100) //length determina o valor maximo da coluna
	private String titulo;
	
	@NotBlank(message = "O atributo nome titulo é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo titulo deve ter no mínimo 10 e no máximo 1000 caracter obrigatório")
	@Column(length = 1000) //length determina o valor maximo da coluna
	private String texto;
	
	@UpdateTimestamp //atualiza a data e hora quando você e quando vc atualiza
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
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
}
