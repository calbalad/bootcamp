package com.example.application.resources;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.application.dtos.ActorDTO;
import com.example.application.dtos.CiudadDetailsDTO;
import com.example.application.dtos.CiudadEditDTO;
import com.example.application.dtos.CiudadShortDTO;
import com.example.application.dtos.PaisDTO;
import com.example.application.dtos.PeliculaDetailsDTO;
import com.example.application.dtos.PeliculaEditDTO;
import com.example.application.dtos.PeliculaShortDTO;
import com.example.application.dtos.RentalDTO;
import com.example.application.dtos.RentalDetailsDTO;
import com.example.application.dtos.RentalShortDTO;
import com.example.domains.contracts.services.ActorService;
import com.example.domains.contracts.services.PeliculaService;
import com.example.domains.contracts.services.RentalService;
import com.example.domains.entities.Actor;
import com.example.domains.entities.City;
import com.example.domains.entities.Country;
import com.example.domains.entities.Rental;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/rental")
public class RentalResource {
	@Autowired
	private RentalService srv;


	@GetMapping
	@Transactional
	public List<RentalShortDTO> getAll() {
		return srv.getAll().stream().map(item -> RentalShortDTO.from(item)).toList();
	}

	@GetMapping(params = "page")
	public Page<RentalShortDTO> getAll(Pageable page) {
		return srv.getByProjection(page, RentalShortDTO.class);
	}
	
	@GetMapping(path = "/{id}")
	public RentalDetailsDTO getOneDetails(@PathVariable int id)
			throws NotFoundException {
			return RentalDetailsDTO.from(srv.getOne(id));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Object> create(@Valid @RequestBody RentalDTO item)
			throws InvalidDataException, DuplicateKeyException, NotFoundException {
		Rental rental = RentalDTO.from(item);
		if(rental.isInvalid())
			throw new InvalidDataException(rental.getErrorsMessage());
		rental = srv.add(rental);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(rental.getRentalId()).toUri();
		return ResponseEntity.created(location).build();

	}


	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		srv.deleteById(id);
	}
}
