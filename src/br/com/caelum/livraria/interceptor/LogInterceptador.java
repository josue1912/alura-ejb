package br.com.caelum.livraria.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object tempoDeAcessoAoBanco(InvocationContext ic) throws Exception{
		
		long tempoInicial = System.currentTimeMillis();
		
		Object proceed = ic.proceed();
		String metodo = ic.getMethod().getName();
		String classe = ic.getTarget().getClass().getSimpleName();
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("["+classe+":"+metodo+"] Tempo decorrido: " + (tempoFinal-tempoInicial));
		
		return proceed;
	}
}
