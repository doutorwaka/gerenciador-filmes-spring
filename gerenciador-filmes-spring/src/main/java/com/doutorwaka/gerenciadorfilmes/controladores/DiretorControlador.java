package com.doutorwaka.gerenciadorfilmes.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doutorwaka.gerenciadorfilmes.dtos.DiretorDto;
import com.doutorwaka.gerenciadorfilmes.servicos.DiretorServico;

@RestController
public class DiretorControlador {
	
	@Autowired
	private DiretorServico ds;
	
	@PostMapping("/diretores")
	public boolean addDiretor(@RequestBody DiretorDto diretor) {
		return this.ds.addDiretor(diretor);
	}
	
	@GetMapping("/diretores")
	public List<DiretorDto> listaDiretores(){
		return this.ds.listaDiretores();
	}
}
