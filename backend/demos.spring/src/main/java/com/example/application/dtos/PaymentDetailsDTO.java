package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
public class PaymentDetailsDTO {

	@JsonProperty("id")
	private int paymentlId;
	@JsonProperty("empleado")
	private String empleado;
	@JsonProperty("total")
	private BigDecimal amount;
	@JsonProperty("fechaDePago")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fecha;

	public static PaymentDetailsDTO from(Payment source) {
		return new PaymentDetailsDTO(
				source.getPaymentId(),
				source.getStaff().getFirstName() + " " + source.getStaff().getLastName(),
				source.getAmount(),
				source.getPaymentDate()
				);
	}

}
