package com.doutorwaka.gerenciadorfilmes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.doutorwaka.gerenciadorfilmes.dtos.AtorDto;

@Entity
@Table(name = "cf_ator")
public class Ator {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(unique = true)
	private String nome;

	public Ator() {

	}

	public Ator(String nome) {
		this.nome = nome;
	}

	public Ator(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Ator(AtorDto ator) {
		this.nome = ator.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
