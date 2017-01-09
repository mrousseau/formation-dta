package fr.pizzeria.dao.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Pizza;

@Aspect
@Component
public class PizzaAspect {

	
	@Before("execution(* save(..))")
	private void allSave(JoinPoint jp){
		String p = ((Pizza)jp.getArgs()[0]).getNom().substring(0,3 /*((Pizza)jp.getArgs()[0]).getNom().toCharArray().length*/);
		System.out.println("Code : " + p );
		((Pizza)jp.getArgs()[0]).setCode(p.toUpperCase());
	}
	
	
}
