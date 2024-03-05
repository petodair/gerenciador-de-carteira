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
	
	public Carteira carregarCarteira(Long idConta) {
		
		System.out.println(idConta);
		
		Carteira carteira = carteiraRepository.findByIdConta(idConta);
		
		return carteira;
	}

}
