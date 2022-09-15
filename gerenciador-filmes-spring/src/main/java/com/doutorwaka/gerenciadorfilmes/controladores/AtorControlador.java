package com.doutorwaka.gerenciadorfilmes.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doutorwaka.gerenciadorfilmes.dtos.AtorDto;
import com.doutorwaka.gerenciadorfilmes.servicos.AtorServico;

@RestController
public class AtorControlador {

	@Autowired
	private AtorServico as;
	
	@PostMapping("/atores")
	public boolean addAtor(@RequestBody AtorDto ator) {
		return this.as.addAtor(ator);
	}
	
	@GetMapping("/atores")
	public List<AtorDto> listaAtores(){
		return this.as.listaAtores();
	}
}
