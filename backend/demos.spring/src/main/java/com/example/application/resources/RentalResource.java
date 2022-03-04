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
import org.springframework.data.domain.PageImpl;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/rental")
@Api(value = "/rental", description = "Mantenimiento de alquileres", produces = "application/json", consumes="application/json")
public class RentalResource {
	@Autowired
	private RentalService srv;

	@GetMapping
	@ApiOperation(value = "Listado de las alquileres")
	public List<RentalShortDTO> getAll() {
		return srv.getAll().stream().map(item -> RentalShortDTO.from(item)).toList();
	}

	@GetMapping(params = "page")
	@ApiOperation(value = "Listado paginable de los alquileres")
	public Page<RentalShortDTO> getAll(Pageable page) {
		var content = srv.getAll(page);
		return new PageImpl(content.getContent().stream().map(item -> RentalShortDTO.from(item)).toList(), 
				page, content.getTotalElements());
	}
	
	@GetMapping(path = "/{id}")
	public RentalDetailsDTO getOneDetails(@PathVariable int id, @RequestParam(required = false, defaultValue = "details") String mode)
			throws NotFoundException {
			return RentalDetailsDTO.from(srv.getOne(id));
	}

	@GetMapping(path = "/{id}", params = "mode=edit")
	@ApiOperation(value = "Recupera un alquiler")
	@ApiResponses({
		@ApiResponse(code = 200, message = "alquiler encontrado"),
		@ApiResponse(code = 404, message = "alquiler no encontrado")
	})
	public RentalDTO getOneEdit(@ApiParam(value = "Identificador del alquiler") @PathVariable int id, 
			@ApiParam(value = "Versión completa o editable", required = false, allowableValues = "details,edit", defaultValue = "edit") @RequestParam() String mode)
			throws NotFoundException {
			return RentalDTO.from(srv.getOne(id));
	}

	@PostMapping
	@Transactional
	@ApiOperation(value = "Añadir un nuevo alquiler")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Alquiler añadida"),
		@ApiResponse(code = 400, message = "Error al validar los datos o clave duplicada"),
		@ApiResponse(code = 404, message = "Alquiler no encontrado")
	})
	public ResponseEntity<Object> create(@Valid @RequestBody RentalDTO item)
			throws InvalidDataException, DuplicateKeyException, NotFoundException {
		Rental rental = RentalDTO.from(item);
		if (rental.isInvalid())
			throw new InvalidDataException(rental.getErrorsMessage());
		rental = srv.add(rental);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(rental.getRentalId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@Transactional
	@ApiOperation(value = "Modificar un alquiler existente", notes = "Los identificadores deben coincidir")
	@ApiResponses({
		@ApiResponse(code = 202, message = "Alquiler editado"),
		@ApiResponse(code = 400, message = "Error al validar los datos o discrepancias en los identificadores"),
		@ApiResponse(code = 404, message = "Alquiler no encontrado")
	})
	public void update(@PathVariable int id, @Valid @RequestBody RentalDTO item)
			throws InvalidDataException, NotFoundException {
		if (id != item.getRentalId())
			throw new InvalidDataException("No coinciden los identificadores");
		var entity = srv.getOne(id);
		item.update(entity);
		if (entity.isInvalid())
			throw new InvalidDataException(entity.getErrorsMessage());
		srv.change(entity);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar un alquiler existente", notes = "Los identificadores deben coincidir")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiResponses({
		@ApiResponse(code = 204, message = "Alquiler borrado"),
		@ApiResponse(code = 400, message = "Error al validar los datos o discrepancias en los identificadores"),
		@ApiResponse(code = 404, message = "Alquiler no encontrado")
	})
	public void delete(@PathVariable int id) {
		srv.deleteById(id);
	}
}
