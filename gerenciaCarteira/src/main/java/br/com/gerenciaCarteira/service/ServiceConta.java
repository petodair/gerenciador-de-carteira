package br.com.gerenciaCarteira.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaCarteira.exceptions.CriptoExistException;
import br.com.gerenciaCarteira.exceptions.EmailExistsException;
import br.com.gerenciaCarteira.exceptions.ServiceExc;
import br.com.gerenciaCarteira.exceptions.UsuarioExistsException;
import br.com.gerenciaCarteira.model.Carteira;
import br.com.gerenciaCarteira.model.Conta;
import br.com.gerenciaCarteira.repository.ContaDao;
import br.com.gerenciaCarteira.util.Util;

@Service
public class ServiceConta {
	
	@Autowired
	private ContaDao contaRepositorio;
	
	@Autowired
	private ServiceCarteira serviceCarteira;
	
	
	public void salvarConta(Conta conta) throws Exception{
		
		try {
			
			if(contaRepositorio.findByEmail(conta.getEmail()) != null) {
				throw new EmailExistsException("Já existe um email cadastrado para: " + conta.getEmail());
			} else if (contaRepositorio.findByUsuario(conta.getUsuario()) != null) {
				throw new UsuarioExistsException("Já existe um usuario com o nome " + conta.getUsuario());
			}
					
			
			conta.setSenha(Util.md5(conta.getSenha()));		
			
		} catch (NoSuchAlgorithmException e) {
			
			throw new CriptoExistException("Erro na criptografia da senha");
			
		}
		
		contaRepositorio.save(conta);
		
		Carteira carteira = new Carteira("Carteira de " + conta.getUsuario(), conta.getId());
		
		serviceCarteira.novaCarteira(carteira);
		
	}
	
	public Conta loginConta(String usuario, String senha) throws ServiceExc{
		
		Conta contaLogin = contaRepositorio.buscarLogin(usuario, senha);
		return contaLogin;
		
	}

}
