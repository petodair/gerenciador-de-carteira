package br.com.gerenciaCarteira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerencuaCarteira.model.Conta;

public interface ContaDao extends JpaRepository<Conta, Long> {
	
	

}
