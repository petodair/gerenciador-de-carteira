package br.com.gerenciaCarteira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gerenciaCarteira.model.Carteira;
import br.com.gerenciaCarteira.service.ServiceAtividade;
import br.com.gerenciaCarteira.service.ServiceCarteira;

@Controller
public class CarteiraController{
	
	@Autowired
	private ServiceCarteira serviceCarteira;
	
	@Autowired
	private ServiceAtividade serviceAtividade;
	
	@GetMapping("/carteira/carteira/{id}")
	public ModelAndView carteira(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		Carteira carteira = serviceCarteira.carregarCarteira(id);
		mv.addObject("carteira", carteira);
		mv.addObject("gastosTotais", serviceAtividade.totalGastos(id));
		mv.addObject("ganhos", serviceAtividade.somaDosGanhos(id));
		mv.addObject("gastos", serviceAtividade.somaDosGastos(id));
		Double total = serviceAtividade.totalGastos(id) + carteira.getValorAtual();
		mv.addObject("valorEspeculado", total);
		mv.setViewName("carteira/carteira.html");
		return mv;
	}
	
	@GetMapping("/carteira/editar-carteira/{id}")
	public ModelAndView Editar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		Carteira carteira = serviceCarteira.alterarCarteira(id);
		mv.addObject("carteira", carteira);
		mv.setViewName("carteira/editar-carteira.html");
		return mv;
	}
	
	@PostMapping("/carteira/salvarEdicao")
	public ModelAndView salvarEdicao(Carteira carteira) {
		ModelAndView mv = new ModelAndView();
		serviceCarteira.salvarCarteira(carteira);
		mv.setViewName("redirect:/carteira/carteira/" + carteira.getIdConta());
		return mv;
	}
	
}