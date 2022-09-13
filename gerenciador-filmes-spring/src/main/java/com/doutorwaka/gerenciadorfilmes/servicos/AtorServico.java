package com.doutorwaka.gerenciadorfilmes.servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doutorwaka.gerenciadorfilmes.dtos.AtorDto;
import com.doutorwaka.gerenciadorfilmes.entities.Ator;
import com.doutorwaka.gerenciadorfilmes.repositorios.AtorRepositorio;

@Service
public class AtorServico {

	@Autowired
	private AtorRepositorio ar;
	
	@Transactional(readOnly = false)
	public boolean addAtor(AtorDto ator) {
		Ator novoAtor = new Ator(ator);
		
		Ator atorSalvo = this.ar.save(novoAtor);
		
		if(atorSalvo != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Transactional(readOnly = true)
	public List<AtorDto> listaAtores(){		
		List<Ator> atoresDoBanco = ar.findByOrderByNomeAsc();
		
		List<AtorDto> atores = null;
		
		if(atoresDoBanco != null) {			
			atores = new ArrayList<AtorDto>();
			
			for(Ator a : atoresDoBanco) {
				atores.add(new AtorDto(a));
			}			
		}
		
		return atores;		
	}
}
