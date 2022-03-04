package com.example.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.domains.entities.Actor;
import com.example.domains.entities.Category;
import com.example.domains.entities.Film;
import com.example.domains.entities.Language;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class PaymentEditDTO {

	@JsonProperty("id")
	private int paymentId;
	@JsonProperty("empleado")
	private int empleado;
	@JsonProperty("total")
	@ApiModelProperty("Precio del pago")
	private BigDecimal amount;
	@JsonProperty("fechaDePago")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@ApiModelProperty("Formato de fecha de alquiler yyyy-MM-dd hh:mm:ss")
	private Date fecha;

	public static PaymentEditDTO from(Payment source) {
		return new PaymentEditDTO(
				source.getPaymentId(),
				source.getStaff().getStaffId(),
				source.getAmount(),
				source.getPaymentDate()
				);
	}

	public static Payment from(PaymentEditDTO source, Rental rental) {
		return new Payment(
				source.getPaymentId(),
				source.getAmount(),
				source.getFecha(),
				new Staff(source.getEmpleado()),
				rental
				);
	}


}

