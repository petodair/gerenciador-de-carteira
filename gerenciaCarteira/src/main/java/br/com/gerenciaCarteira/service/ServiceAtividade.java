package br.com.gerenciaCarteira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaCarteira.model.Atividade;
import br.com.gerenciaCarteira.repository.AtividadeDao;

@Service
public class ServiceAtividade {
	
	@Autowired
	private AtividadeDao atividadeRepository;
	
	public void salvarAtividade(Atividade atividade) {
		atividadeRepository.save(atividade);
	}
	
	public List<Atividade> atividadesById(Long id){
		return atividadeRepository.findAllByIdConta(id);
	}
	
	public void excluir(Long id) {
		atividadeRepository.deleteById(id);
	}
	
	public Double somaDosGastos(Long id) {
		
		Double gastos;
		
		if(atividadeRepository.somaDosGastos(id) == null) {
			gastos = (double) 0;
		} else {
			gastos = atividadeRepository.somaDosGastos(id);
		}
		
		return gastos;
	}
	
	public Double somaDosGanhos(Long id) {
		
        Double ganhos;
		
		if(atividadeRepository.somaDosGanhos(id) == null) {
			ganhos = (double) 0;
		} else {
			ganhos = atividadeRepository.somaDosGanhos(id);
		}
		
		return ganhos;
	}
	
	public Double totalGastos(Long id) {
		Double gastos;
		
		gastos = -somaDosGastos(id);
		
		return gastos + somaDosGanhos(id);
	}

}
