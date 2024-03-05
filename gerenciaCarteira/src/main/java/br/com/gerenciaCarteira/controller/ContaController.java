package br.com.gerenciaCarteira.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gerenciaCarteira.exceptions.ServiceExc;
import br.com.gerenciaCarteira.model.Carteira;
import br.com.gerenciaCarteira.model.Conta;
import br.com.gerenciaCarteira.service.ServiceCarteira;
import br.com.gerenciaCarteira.service.ServiceConta;
import br.com.gerenciaCarteira.util.Util;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ContaController {
	
	@Autowired
	private ServiceConta serviceConta;
	
	@Autowired
	private ServiceCarteira serviceCarteira;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("conta", new Conta());
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
	
	@PostMapping("salvarConta")
	public ModelAndView cadastro(@Valid Conta conta, BindingResult br){
		ModelAndView mv = new ModelAndView();
		boolean confirmacao = true;
		
		 if(br.hasErrors()) {
			mv.setViewName("conta/cadastro");
			mv.addObject("confirmacao", confirmacao);
			mv.addObject(conta);
			
		} else if (conta.getSenha().equals(conta.getRepetirSenha())){
			
			try {
				serviceConta.salvarConta(conta);
			} catch (Exception e) {
				mv.addObject("message", e.getMessage());
				mv.setViewName("conta/cadastro");
				return mv;
			}
			mv.addObject("msgSucesso", "Conta criada com sucesso!");
			mv.setViewName("redirect:/login");
						
		} else {
					
			mv.setViewName("conta/cadastro");
			mv.addObject(conta);
			mv.addObject("diferentes",  "A senha e a confirmação da senhas estão diferentes");
			confirmacao = false;
			mv.addObject("confirmacao", confirmacao);
			
		}
		
		return mv;
	}
	
	@PostMapping("/logar")
	public ModelAndView logar(@Valid Conta conta, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc{
		ModelAndView mv = new ModelAndView();
		mv.addObject("conta", new Conta());
		if(br.hasErrors()) {
			mv.setViewName("conta/login");
			mv.addObject(conta);
		}
		
		Conta contaLogin = serviceConta.loginConta(conta.getUsuario(), Util.md5(conta.getSenha()));
		
		
		
		if(contaLogin == null) {
			mv.addObject("msg", "Conta ou usuário incorretos. Tente novamente");
		} else {
			Carteira carteira = serviceCarteira.carregarCarteira(contaLogin.getId());
			session.setAttribute("contaLogada", contaLogin);
			session.setAttribute("carteiraConta", carteira);
			return index();
		}
		
		return mv;
	}
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		
		session.invalidate();
		return login();
		
	}

}

