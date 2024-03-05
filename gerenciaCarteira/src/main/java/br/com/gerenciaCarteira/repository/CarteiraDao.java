package br.com.gerenciaCarteira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gerenciaCarteira.model.Carteira;

public interface CarteiraDao extends JpaRepository<Carteira, Long> {
	
	@Query("select i from Carteira i where i.idConta = :idConta")
	public Carteira findByIdConta(Long idConta);

}
