package br.com.gerenciaCarteira.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaCarteira.model.Carteira;
import br.com.gerenciaCarteira.repository.CarteiraDao;

@Service
public class ServiceCarteira {
	
	@Autowired
	private CarteiraDao carteiraRepository;
	
	public void novaCarteira(Carteira carteira) {
		
		carteiraRepository.save(carteira);
		
	}
	
public void salvarCarteira(Carteira carteira) {
		
		carteiraRepository.save(carteira);
		
	}
	
	public Carteira carregarCarteira(Long idConta) {
		
		Carteira carteira = carteiraRepository.findByIdConta(idConta);
		
		return carteira;
	}
	
	public Carteira alterarCarteira(Long id) {
		
		Carteira carteira = carteiraRepository.getReferenceById(id);
		
		return carteira;
		
	}

}
