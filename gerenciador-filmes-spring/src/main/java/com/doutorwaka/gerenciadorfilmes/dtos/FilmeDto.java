package com.doutorwaka.gerenciadorfilmes.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.doutorwaka.gerenciadorfilmes.entities.Ator;
import com.doutorwaka.gerenciadorfilmes.entities.Filme;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private String nome;
	@JsonProperty
	private DiretorDto diretor;
	@JsonProperty
	private Set<AtorDto> elenco;
	@JsonProperty
	private float nota;

	@JsonCreator
	public FilmeDto(String nome, DiretorDto diretor, Set<AtorDto> elenco, float nota) {
		super();
		this.nome = nome;
		this.diretor = new DiretorDto(diretor);
		this.elenco = new HashSet<AtorDto>(elenco);
		this.nota = nota;
	}

	public FilmeDto(FilmeDto filme) {
		this(filme.getNome(), filme.getDiretor(), filme.getElenco(), filme.getNota());
	}

	public FilmeDto(Filme filme) {
		this.nome = filme.getNome();
		this.diretor = new DiretorDto(filme.getDiretor());
		this.nota = filme.getNota();
		
		for(Ator a : filme.getElenco()) {
			this.elenco.add(new AtorDto(a));
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DiretorDto getDiretor() {
		return diretor;
	}

	public void setDiretor(DiretorDto diretor) {
		this.diretor = diretor;
	}

	public Set<AtorDto> getElenco() {
		return elenco;
	}

	public void setElenco(Set<AtorDto> elenco) {
		this.elenco = elenco;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diretor, elenco, nome, nota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmeDto other = (FilmeDto) obj;
		return Objects.equals(diretor, other.diretor) && Objects.equals(elenco, other.elenco)
				&& Objects.equals(nome, other.nome) && Float.floatToIntBits(nota) == Float.floatToIntBits(other.nota);
	}

}
