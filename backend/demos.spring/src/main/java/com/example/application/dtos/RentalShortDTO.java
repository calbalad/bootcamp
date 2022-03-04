package com.example.application.dtos;

import com.example.domains.entities.Film;
import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class RentalShortDTO {
	@JsonProperty("id")
	private int rentalId;
	private String customer;
	private String title;

	public static RentalShortDTO from(Rental source) {
		return new RentalShortDTO(
				source.getRentalId(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName(),
				source.getInventory().getFilm().getTitle()
				);
	}
}
