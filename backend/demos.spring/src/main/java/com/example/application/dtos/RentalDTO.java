package com.example.application.dtos;

import java.util.Date;
import java.util.List;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
public class RentalDTO {
	
	@JsonProperty("id")
	private int rentalId;
	@JsonProperty("fechaAlquiler")
	private Date rentalDate;
	@JsonProperty("fechaDevolucion")
	private Date returnDate;
	@JsonProperty("inventarioId")
	private int inventoryId;
	@JsonProperty("clienteId")
	private int customerId;
	@JsonProperty("empleadoId")
	private int staffId;
	
	public static Rental from(RentalDTO source) {
		return new Rental(
				source.getRentalId(),
				source.getRentalDate(),
				source.getReturnDate(),
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
				source.getStaff().getStaffId()
				);
	}
}
