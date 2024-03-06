package br.com.gerenciaCarteira.model;

import br.com.gerenciaCarteira.enums.Nescessario;
import br.com.gerenciaCarteira.enums.Tipo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "atividade")
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long idConta;
	
	private String nome;
	
	private String detalhes;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	private double valor;
	
	@Enumerated(EnumType.STRING)
	private Nescessario nescessario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Nescessario getNescessario() {
		return nescessario;
	}

	public void setNescessario(Nescessario nescessario) {
		this.nescessario = nescessario;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

}
