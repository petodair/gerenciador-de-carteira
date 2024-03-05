package br.com.gerenciaCarteira.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarteiraController{
	
	@GetMapping("/carteira/adicionar-atividade")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("carteira/atividade.html");
		return mv;
	}
	
	@GetMapping("/carteira/carteira")
	public ModelAndView carteira() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("carteira/carteira.html");
		return mv;
	}
	
}