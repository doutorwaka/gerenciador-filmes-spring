package com.doutorwaka.gerenciadorfilmes.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.doutorwaka.gerenciadorfilmes.entities.Diretor;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DiretorDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String nome;

	@JsonCreator
	public DiretorDto(String nome) {
		this.nome = nome;
	}
	
	public DiretorDto(DiretorDto diretor) {
		this.nome = diretor.nome;
	}
	
	public DiretorDto(Diretor diretor) {
		this.nome = diretor.getNome();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiretorDto other = (DiretorDto) obj;
		return Objects.equals(nome, other.nome);
	}
}
