package br.com.gerenciaCarteira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min = 3, max = 20, message = "Usuario deve conter entre 3 e 20 caracteres")
	private String usuario;
	
	@Email
	@NotBlank(message = "O campo e-mail deve ser preenchido")
	private String email;
	
	@NotBlank(message = "O campo senha deve ser preenchido")
	private String senha;
	
	@Transient
	@NotBlank(message = "A confirmação senha deve ser preenchida")
	private String repetirSenha;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRepetirSenha() {
		return repetirSenha;
	}
	public void setRepetirSenha(String repetirSenha) {
		this.repetirSenha = repetirSenha;
	}
	
	

}
