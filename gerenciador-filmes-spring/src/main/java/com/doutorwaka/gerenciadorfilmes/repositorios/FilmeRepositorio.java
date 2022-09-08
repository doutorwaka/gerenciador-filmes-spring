package com.doutorwaka.gerenciadorfilmes.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doutorwaka.gerenciadorfilmes.entities.Diretor;
import com.doutorwaka.gerenciadorfilmes.entities.Filme;

@Repository
public interface FilmeRepositorio extends JpaRepository<Filme, Long>{
	public List<Filme> findByOrderByNomeAsc();
	public List<Filme> findByDiretorOrderByNomeAsc(Diretor diretor);
	public List<Filme> findByNotaGreaterThanEqualOrderByNome(Float nota);
	@Query(value="select * from cf_filme as u inner join cf_filme_elenco as e on e.filme_id=u.id WHERE elenco_id=:id order by nome", nativeQuery=true)
	public List<Filme> findByAtorOrderByNome(Long id);
}
