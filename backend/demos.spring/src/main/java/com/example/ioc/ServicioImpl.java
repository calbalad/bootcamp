package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@Qualifier("despliegue")
@Scope("prototype")
public class ServicioImpl implements Servicio {
	private String name;
	public ServicioImpl() {
		name = dep.getName();
	}

	@Override
	public void run() {
		System.out.println("Soy el servicio");
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	
}
