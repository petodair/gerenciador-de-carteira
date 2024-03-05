package br.com.gerenciaCarteira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carteira")
public class Carteira {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private double valorAtual;
	
	public double valorPretendido;
	
	public Long idConta;

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

	public double getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}

	public double getValorPretendido() {
		return valorPretendido;
	}

	public void setValorPretendido(double valorPretendido) {
		this.valorPretendido = valorPretendido;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public Carteira(String nome, Long idConta) {
		super();
		this.nome = nome;
		this.idConta = idConta;
	}

	public Carteira() {
		super();
	}
	
	

}
