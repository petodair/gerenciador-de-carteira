package br.com.gerenciaCarteira.util;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.gerenciaCarteira.controller.FilterController;

@Configuration
public class Configuracao {
	
	@Bean
    public FilterRegistrationBean<FilterController> filterRegistrationBean() {
        FilterRegistrationBean < FilterController > registrationBean = new FilterRegistrationBean();
        FilterController myCustomFilter = new FilterController();
 
        registrationBean.setFilter(myCustomFilter);
        registrationBean.addUrlPatterns("/carteira/*");
        registrationBean.setOrder(2); //set precedence
        return registrationBean;
    }

}
