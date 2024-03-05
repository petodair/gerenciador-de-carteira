package br.com.gerenciaCarteira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gerenciaCarteira.model.Conta;

public interface ContaDao extends JpaRepository<Conta, Long> {
	
	@Query("select i from Conta i where i.email = :email")
	public Conta findByEmail(String email);
	
	@Query("select a from Conta a where a.usuario = :usuario")
	public Conta findByUsuario(String usuario);
	
	@Query("select j from Conta j where j.usuario = :usuario and j.senha = :senha")
	public Conta buscarLogin(String usuario, String senha);

}
