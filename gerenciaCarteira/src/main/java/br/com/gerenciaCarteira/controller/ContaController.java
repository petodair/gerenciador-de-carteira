package br.com.gerenciaCarteira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gerenciaCarteira.repository.ContaDao;
import br.com.gerencuaCarteira.model.Conta;

@Controller
public class ContaController {
	
	@Autowired
	private ContaDao contaRepository;
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conta/login");
		return mv;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("conta", new Conta());
		mv.setViewName("conta/cadastro");
		return mv;
	}
	
	@GetMapping("salvarConta")
	public ModelAndView cadastro(Conta conta) {
		ModelAndView mv = new ModelAndView();
		contaRepository.save(conta);
		mv.setViewName("redirect:/index");
		return mv;
	}

}

