package com.prova.init.provainit.config;

import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.prova.init.provainit.fagiolo.InitDependenceBean;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonMaPeddavero {
	
	private static AtomicReference<SingletonMaPeddavero> instance;
	
	private int veryImportantExternalValue;
	
	@Autowired
	private InitDependenceBean initDependenceBean;
	
	static {
		instance= new AtomicReference<>();
	}
	
	public SingletonMaPeddavero() {
		if (instance.getAndSet(this) != null) {
			throw new IllegalStateException();
		}
		
	}


	/**
	 * @return the veryImportantExternalValue
	 */
	public int getVeryImportantExternalValue() {
		return veryImportantExternalValue;
	}

	/**
	 * @param veryImportantExternalValue the veryImportantExternalValue to set
	 */
	private void setVeryImportantExternalValue(int veryImportantExternalValue) {
		this.veryImportantExternalValue = veryImportantExternalValue;
	}
	
	@PostConstruct
	protected void init() {
		this.setVeryImportantExternalValue(initDependenceBean.initValueFromExternalSource());
		System.out.println(this.getVeryImportantExternalValue());
	}
	
}
