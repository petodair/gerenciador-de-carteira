package br.com.gerenciaCarteira.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FilterController implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		
		String urlOrigem = req.getServletPath();
		
		if(session.getAttribute("contaLogada") != null || urlOrigem.lastIndexOf("conta/login.html")>-1) {
			
			chain.doFilter(request, response);
			
		} else {
			((HttpServletResponse) response).sendRedirect("/login");
		}
		

	}

}
