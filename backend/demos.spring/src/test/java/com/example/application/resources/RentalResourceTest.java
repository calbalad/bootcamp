package com.example.application.resources;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import org.springframework.http.HttpStatus;

import com.example.application.dtos.PaymentEditDTO;
import com.example.application.dtos.RentalDTO;
import com.example.domains.contracts.services.RentalService;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

@SpringBootTest
//@AutoConfigureMockMvc
class RentalResourceTest {
	List<RentalDTO> listado;

	@BeforeEach
	void setUp() throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		String string1 = "2001-07-04T12:08:56.235-0700";
		Date result1 = df.parse(string1);
		String string2 = "2001-07-10T12:07:55.235-0700";
		Date result2 = df.parse(string2);
		listado = new ArrayList<RentalDTO>();
		listado.add(new RentalDTO(1, result1, null, 1, 4, 9,
				List.of(new PaymentEditDTO(1, 1, new java.math.BigDecimal("0.01"), result1))));
		listado.add(new RentalDTO(1, result1, result2, 1, 4, 9,
				List.of(new PaymentEditDTO(1, 1, new java.math.BigDecimal("0.01"), result1))));
	}

	public static class IoCTestConfig {
		@Bean
		RentalService getServicio() {
			return mock(RentalService.class);
		}

		@Bean
		RentalResource getRest() {
			return new RentalResource();
		}
	}

	@Nested
	// @ContextConfiguration(classes = IoCTestConfig.class)
	@MockBean(RentalService.class)
	class PruebasUnitarias {
		@Autowired
		RentalService srv;

		@Autowired
		RentalResource rest;

		@Test
		void testMock() {
			assertNotNull(srv);
			assertNotNull(rest);
		}

		@Test
		void testGetAll() {
			when(srv.getByProjection(RentalDTO.class)).thenReturn(listado);

			var rslt = rest.getAll();

			assertNotNull(rslt);
			// assertEquals(2, rslt.size());
		}

		@Test
		void testGetOne() throws NotFoundException {
			when(srv.getOne(1)).thenReturn(RentalDTO.from(listado.get(0)));

			var rslt = rest.getOneEdit(1, "edit");
			assertNotNull(rslt);
			assertEquals(1, rslt.getRentalId());
		}

		@Test
		void testGetOneNotFound() throws NotFoundException {
			when(srv.getOne(1)).thenThrow(NotFoundException.class);

			assertThrows(NotFoundException.class, () -> rest.getOneEdit(1, "edit"));
		}

		@Test
		void testCreate() throws NotFoundException, DuplicateKeyException, InvalidDataException {
			when(srv.add(any())).thenReturn(RentalDTO.from(listado.get(0)));

			var rslt = rest.create(listado.get(0));
			assertNotNull(rslt);
			assertEquals(HttpStatus.CREATED, rslt.getStatusCode());
		}
		
//		@Test
//		void testCreateAndUpdate() throws NotFoundException, DuplicateKeyException, InvalidDataException {
//			when(srv.add(any())).thenReturn(RentalDTO.from(listado.get(0)));
//
//			var rslt = rest.create(listado.get(0));
//			assertNotNull(rslt);
//			assertEquals(HttpStatus.CREATED, rslt.getStatusCode());
//			
//			rest.update(1, listado.get(0));
//			verify(srv).change(RentalDTO.from(listado.get(0)));
//			
//		}

		@Test
		void testCreateDuplicateKey() throws NotFoundException, DuplicateKeyException, InvalidDataException {
			when(srv.add(any())).thenThrow(DuplicateKeyException.class);

			assertThrows(DuplicateKeyException.class, () -> rest.create(listado.get(0)));
		}

		@Test
		void testCreateInvalidData() throws NotFoundException, DuplicateKeyException, InvalidDataException {
			when(srv.add(any())).thenThrow(InvalidDataException.class);

			assertThrows(InvalidDataException.class, () -> rest.create(listado.get(0)));
		}

//		@Test
//		void testUpdate() throws NotFoundException, InvalidDataException, ParseException {
//			
//			rest.update(1, listado.get(0));
//			verify(srv).change(RentalDTO.from(listado.get(0)));
//		}

		@Test
		void testUpdateInvalidId() throws NotFoundException, InvalidDataException {
			assertThrows(InvalidDataException.class, () -> rest.update(60, listado.get(0)));
		}

		@Test
		void testUpdateInvalidData() throws NotFoundException, InvalidDataException {
			assertThrows(InvalidDataException.class, () -> rest.update(1, new RentalDTO()));
		}

		@Test
		void testDelete() throws NotFoundException, InvalidDataException {
			doNothing().when(srv).deleteById(any());

			rest.delete(1);
			verify(srv).deleteById(1);
		}
	}
}
