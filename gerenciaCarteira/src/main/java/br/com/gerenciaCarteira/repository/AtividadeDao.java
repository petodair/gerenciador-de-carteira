package br.com.gerenciaCarteira.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gerenciaCarteira.model.Atividade;

public interface AtividadeDao extends JpaRepository<Atividade, Long> {
	
	@Query("select a from Atividade a where a.idConta = :idConta")
	public List<Atividade> findAllByIdConta(Long idConta);
	
	@Query("SELECT SUM(m.valor) FROM Atividade m WHERE m.idConta = :idConta and m.tipo = 'GASTO'")
	public Double somaDosGastos(Long idConta);
	
	@Query("SELECT SUM(m.valor) FROM Atividade m WHERE m.idConta = :idConta and m.tipo = 'GANHO'")
	public Double somaDosGanhos(Long idConta);

}
