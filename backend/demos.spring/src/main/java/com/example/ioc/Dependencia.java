package com.example.ioc;

import lombok.Value;

public class Dependencia {
	@Value("${mi.config.name}")
	private String name;
	public Dependencia() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

}
