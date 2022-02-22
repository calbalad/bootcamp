package com.example.ioc;

import org.springframework.stereotype.Component;

@Component
public class ServicioImpl implements Servicio {
	
	public ServicioImpl() {
		
	}

	@Override
	public void run() {
		System.out.println("Soy el servicio");
	}
	
	
	
}
