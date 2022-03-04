package com.example.application.dtos;

import java.util.Date;
import java.util.List;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RentalDetailsDTO {
	
	@JsonProperty("id")
	private int rentalId;
	@JsonProperty("fechaAlquiler")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date rentalDate;
	@JsonProperty("fechaDevolucion")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date returnDate;
	@JsonProperty("inventarioId")
	private int customerId;
	@JsonProperty("nombreCliente")
	private String firstName;
	@JsonProperty("apellidoCliente")
	private String lastName;
	@JsonProperty("empleadoId")
	private int inventoryId;
	@JsonProperty("clienteId")
	private int staffId;
	@JsonProperty("pago")
	private List<Integer> payments;
	@JsonProperty("film")
	private String film;

	
	public static RentalDetailsDTO from(Rental source) {
		return new RentalDetailsDTO(
				source.getRentalId(),
				source.getRentalDate(),
				source.getReturnDate(),
				source.getCustomer().getCustomerId(),
				source.getCustomer().getFirstName(),
				source.getCustomer().getLastName(),
				source.getInventory().getInventoryId(),
				source.getStaff().getStaffId(),
				source.getPayments().stream().map(item -> item.getPaymentId()).sorted().toList(),
				source.getInventory().getFilm().getTitle()
				);
	}
}
