package com.example.application.dtos;

import java.util.Date;
import java.util.List;

import org.springframework.lang.NonNull;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data @NoArgsConstructor @AllArgsConstructor
@ApiModel(value = "Película editable", description = "Versión editable de los alquileres.")
public class RentalDTO {

	@JsonProperty("id")
	private int rentalId;
	@JsonProperty("fechaAlquiler")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date rentalDate;
	@JsonProperty("fechaDevolucion")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date returnDate;
	@JsonProperty("inventarioId")
	private int inventoryId;
	@JsonProperty("clienteId")
	@NonNull
	private int customerId;
	@JsonProperty("empleadoId")
	private int staffId;
	private List<PaymentEditDTO> payments;

	public static Rental from(RentalDTO source) {
		return new Rental(
				source.getRentalId(), 
				source.getRentalDate(), 
				source.getReturnDate() == null ? null : source.getRentalDate(),
				new Customer(source.getCustomerId()), 
				new Inventory(source.getInventoryId()),
				new Staff(source.getStaffId())
				);
	}

	public static RentalDTO from(Rental source) {
		return new RentalDTO(
				source.getRentalId(), 
				source.getRentalDate(),
				source.getReturnDate() == null ? null : source.getRentalDate(), 
				source.getCustomer().getCustomerId(),
				source.getInventory().getInventoryId(), 
				source.getStaff().getStaffId(),
				source.getPayments().stream().map(pago -> PaymentEditDTO.from(pago)).toList());
	}

	public Rental update(Rental target) {
		target.setRentalDate(rentalDate);
		target.setReturnDate(returnDate);
		target.setCustomer(new Customer(customerId));
		target.setInventory(new Inventory(inventoryId));
		target.setStaff(new Staff(staffId));
		
		var delAlquiladas = target.getPayments().stream()
				.filter(item -> payments.stream().noneMatch(pago -> pago.getPaymentId() == item.getPaymentId()))
				.toList();
		
		delAlquiladas.forEach(item -> target.removePayment(item));
		
		target.getPayments().forEach(item -> {
			var nuevoPago = payments.stream().filter(pago -> pago.getPaymentId() == item.getPaymentId()).findFirst().get();
			if (item.getAmount() != nuevoPago.getAmount()) {	
				item.setAmount(nuevoPago.getAmount());
			}
			if (item.getPaymentDate() != nuevoPago.getFecha()) {	
				item.setPaymentDate(nuevoPago.getFecha());
			}
			if(item.getStaff().getStaffId() != nuevoPago.getEmpleado()) {
				item.setStaff(new Staff(nuevoPago.getEmpleado()));
			}
		});
		
		payments.stream()
			.filter(paymentDTO -> target.getPayments().stream().noneMatch(alquiler -> alquiler.getPaymentId() == paymentDTO.getPaymentId()))
			.forEach(paymentDTO -> target.addPayment(
					new Payment(
					paymentDTO.getPaymentId(),
					paymentDTO.getAmount(),
					paymentDTO.getFecha(),
					new Staff(paymentDTO.getEmpleado()),
					target)));
		return target;
	}
}
