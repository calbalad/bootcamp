package com.example.application.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.dtos.PaymentDetailsDTO;
import com.example.domains.contracts.services.PaymentService;

import com.example.exceptions.NotFoundException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/payment")
@Api(value = "/payment", description = "Consulta de pago", produces = "application/json", consumes="application/json")
public class PaymentResource {
	@Autowired
	private PaymentService srv;

	
	@GetMapping(path = "/{id}")
	public PaymentDetailsDTO getOneDetails(@PathVariable int id, @RequestParam(required = false, defaultValue = "details") String mode)
			throws NotFoundException {
			return PaymentDetailsDTO.from(srv.getOne(id));
	}


//	@DeleteMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable int id) {
//		srv.deleteById(id);
//	}
}
