package com.doutorwaka.gerenciadorfilmes.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doutorwaka.gerenciadorfilmes.dtos.AtorDto;
import com.doutorwaka.gerenciadorfilmes.dtos.DiretorDto;
import com.doutorwaka.gerenciadorfilmes.dtos.FilmeDto;
import com.doutorwaka.gerenciadorfilmes.servicos.FilmeServico;

@RestController
public class FilmeControlador {

	@Autowired
	private FilmeServico fs;
	
	@PostMapping("/filmes")
	public boolean addFilme(@RequestBody FilmeDto filme) {
		return this.fs.addFilme(filme);
	}
	
	@GetMapping("/filmes")
	public List<FilmeDto> listaFilmes(){
		return this.fs.listaFilmesOrdenadoPorNome();
	}
	
	@GetMapping("/filmes/diretor/{nomediretor}")
	public List<FilmeDto> listaFilmesPorDiretor(@PathVariable("nomediretor") String nomeDiretor){
		DiretorDto diretor = new DiretorDto(nomeDiretor);
		return this.fs.listaFilmesPorDiretor(diretor);
	}
	
	@GetMapping("/filmes/ator/{nomeator}")
	public List<FilmeDto> listaFilmesPorAtor(@PathVariable("nomeator") String nomeAtor){
		AtorDto ator = new AtorDto(nomeAtor);
		return this.fs.listaFilmesPorAtor(ator);
	}
	
	@GetMapping("/filmes/nota/{nota}")
	public List<FilmeDto> listaFilmesPorNota(@PathVariable("nota") Float nota){
		return this.fs.listaFilmesPorNota(nota);
	}
}
