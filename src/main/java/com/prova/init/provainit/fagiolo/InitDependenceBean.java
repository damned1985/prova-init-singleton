package com.prova.init.provainit.fagiolo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class InitDependenceBean {
	
	@Autowired
	private Random rand;
	
	public int initValueFromExternalSource(){
		return rand.nextInt();
	}
}
