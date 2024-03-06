package br.com.gerenciaCarteira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gerenciaCarteira.model.Atividade;
import br.com.gerenciaCarteira.model.Conta;
import br.com.gerenciaCarteira.service.ServiceAtividade;
import jakarta.servlet.http.HttpSession;

@Controller
public class AtividadeController {
	
	@Autowired
	private ServiceAtividade serviceAtividade;
	
	@GetMapping("/carteira/adicionar-atividade")
	public ModelAndView adicionar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("atividade", new Atividade());
		mv.setViewName("carteira/adicionar-atividade.html");
		return mv;
	}
	
	@GetMapping("/carteira/lista-atividades/{id}")
	public ModelAndView lista(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("atividades", serviceAtividade.atividadesById(id));
		mv.setViewName("carteira/lista-atividades.html");
		return mv;
	}
	
	@GetMapping("/carteira/excluir-atividade/{id}")
	public ModelAndView excluirAtividade(@PathVariable("id") Long id, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		serviceAtividade.excluir(id);
		Conta conta = (Conta) session.getAttribute("contaLogada");
		mv.setViewName("redirect:/carteira/lista-atividades/" + conta.getId());
		return mv;
	}
	
	@PostMapping("/carteira/salvarAtividade")
	public ModelAndView salvar(Atividade atividade, BindingResult br, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Conta conta = (Conta) session.getAttribute("contaLogada");
		
		atividade.setIdConta(conta.getId());
		serviceAtividade.salvarAtividade(atividade);
		mv.setViewName("redirect:/carteira/lista-atividades/" + conta.getId());
		return mv;
	}

}
