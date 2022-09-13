package com.doutorwaka.gerenciadorfilmes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.doutorwaka.gerenciadorfilmes.dtos.DiretorDto;

@Entity
@Table(name = "cf_diretor")
public class Diretor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(unique = true)
	private String nome;

	public Diretor() {

	}

	public Diretor(String nome) {
		super();
		this.nome = nome;
	}

	public Diretor(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Diretor(DiretorDto diretor) {
		this.nome = diretor.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
