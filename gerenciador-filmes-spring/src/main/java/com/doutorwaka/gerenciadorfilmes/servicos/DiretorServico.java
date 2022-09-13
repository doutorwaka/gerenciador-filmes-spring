package com.doutorwaka.gerenciadorfilmes.servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doutorwaka.gerenciadorfilmes.dtos.DiretorDto;
import com.doutorwaka.gerenciadorfilmes.entities.Diretor;
import com.doutorwaka.gerenciadorfilmes.repositorios.DiretorRepositorio;

@Service
public class DiretorServico {

	@Autowired
	private DiretorRepositorio dr;
	
	@Transactional(readOnly = false)
	public boolean addDiretor(DiretorDto diretor) {
		Diretor novoDiretor = dr.save(new Diretor(diretor));
		
		if(novoDiretor != null)
			return true;
		else
			return false;
	}
	
	@Transactional(readOnly = true)
	public List<DiretorDto> listaDiretores(){
		
		List<Diretor> diretoresDoBanco = this.dr.findByOrderByNomeAsc();
		
		List<DiretorDto> diretoresDto = null;
		
		if(diretoresDoBanco != null) {
			diretoresDto = new ArrayList<DiretorDto>();
			
			for(Diretor d : diretoresDoBanco)
				diretoresDto.add(new DiretorDto(d));
		}
		
		return diretoresDto;		
	}
}
