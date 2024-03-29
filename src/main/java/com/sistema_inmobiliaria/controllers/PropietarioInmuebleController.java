package com.sistema_inmobiliaria.controllers;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sistema_inmobiliaria.entities.PropietarioInmueble;
import com.sistema_inmobiliaria.services.PropietarioInmuebleService;

@RestController
@RequestMapping("/api/v1/property-owners")
public class PropietarioInmuebleController {

	@Autowired
	private PropietarioInmuebleService propInmService;

	// ===============================================
	// ============= MÉTODOS HTTP CRUD ==============
	// ===============================================

	// ================
	// ===== POST =====
	// =================
	@PostMapping("/")
	public ResponseEntity<?> addPropInm(@RequestBody PropietarioInmueble propInm) {

		try {
			return new ResponseEntity<PropietarioInmueble>(propInm, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

		}

	}

	// ==============
	// ===== PUT=====
	// ==============
	@PutMapping("/")
	public ResponseEntity<?> updatePropInm(@RequestBody PropietarioInmueble propInm) {

		try {
			return new ResponseEntity<PropietarioInmueble>(propInm, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

		}

	}

	// ==================
	// ===== DELETE =====
	// ==================
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePropInm(@PathVariable("id") long id) {

		try {
			return new ResponseEntity<PropietarioInmueble>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

		}

	}

	// ===================
	// ===== GET ALL =====
	// ===================
	// ---LISTADO DE PROPIETARIOS PAGINADO---
	@GetMapping("/listado")
	public Page<PropietarioInmueble> getAll(Pageable pageable) {
		return propInmService.getAllPropInm(pageable);
	}

	// ========================
	// ===== GET ALL FILTER=====
	// ========================
	// ---LISTADO DE PROPIETARIOS PAGINADO CON FILTRO---
	@GetMapping("/listado-filter/{filter}")
	public Page<PropietarioInmueble> getAllFilter(@PathVariable("filter") String filter, Pageable pageable) {
		return propInmService.getAllFilterPropInm(filter, pageable);
	}

	// =================================
	// ===== GET ALL EXCLUDE FILTER=====
	// =================================
	// ---LISTADO DE PROPIETARIOS PAGINADO CON EXCLUSIÓN DE FILTRO ---
	@GetMapping("/listado-exclude-filter/{filter}")
	public Page<PropietarioInmueble> getAllExcludeFilter(@PathVariable("filter") String filter, Pageable pageable) {
		return propInmService.getAllExcludeFilterPropInm(filter, pageable);
	}

	// ==================================================
	// ============= MÉTODOS HTTP BÚSQUEDA =============
	// ==================================================

	// ===================
	// ===== GET BY ID ===
	// ===================
	/**
	 * This method returns a list of owner/s according to their id
	 */
	@GetMapping("/id/{id}")
	public PropietarioInmueble findById(@PathVariable("id") int id) {
		return propInmService.findById(id);
	}

	// =======================
	// ===== GET BY NAME ===
	// =======================
	/**
	 * This method returns a list of owner/s according to their name
	 */
	@GetMapping("/name/{name}")
	public Page<PropietarioInmueble> findByName(@PathVariable("name") String name, Pageable pageable) {
		return propInmService.findByName(name, pageable);
	}

	// =======================
	// ===== GET BY LASTNAME ===
	// =======================
	/**
	 * This method returns a list of owner/s according to their lastName
	 */
	@GetMapping("/last-name/{lastName}")
	public Page<PropietarioInmueble> findByLastName(@PathVariable("lastName") String lastName, Pageable pageable) {

		return propInmService.findByLastName(lastName, pageable);

	}

	// =======================
	// ===== GET BY AGE ===
	// =======================
	/**
	 * This method returns a list of owner/s according to their age
	 */
	@GetMapping("/age/{age}")
	public Page<PropietarioInmueble> findByAge(@PathVariable("age") int age, Pageable pageable) {

		return propInmService.findByAge(age, pageable);

	}

	// ===========================
	// ===== GET BY AGE (MAX) ===
	// ===========================
	/**
	 * This method returns a list of owner/s according to their max age
	 */
	@GetMapping("/max-age/{maxAge}")
	public Page<PropietarioInmueble> findByAgeMax(@PathVariable("maxAge") int maxAge, Pageable pageable) {
		try {
			return propInmService.findByAgeMax(maxAge, pageable);
		} catch (Exception e) {
			return null;
		}

	}

	// ===================================
	// ===== GET BY AGE ( MIN & MAX ) ===
	// ===================================
	/**
	 * This method returns a list of owner/s according to their max and min age
	 */
	@GetMapping("/min-max-age/{minAge}/{maxAge}")
	public Page<PropietarioInmueble> findByAgeMinMax(@PathVariable("minAge") int minAge,
			@PathVariable("maxAge") int maxAge, Pageable pageable) {
		try {
			return propInmService.findByAgeMinMax(minAge, maxAge, pageable);
		} catch (Exception e) {
			return null;
		}

	}

	// ==========================
	// ===== GET BY BIRTHDATE ===
	// ==========================
	/**
	 * This method returns a list of owner/s according to birthdate
	 */
	@GetMapping("/birthdate/{date}")
	public Page<PropietarioInmueble> findByBirthdate(@PathVariable("date") Date bithdate, Pageable pageable) {

		return propInmService.findByBirthdate(bithdate, pageable);

	}

	// ==============================
	// ===== GET BY DOCUMENT TYPE ===
	// ==============================
	/**
	 * This method returns a list of owner/s according to document type
	 */
	@GetMapping("/document-type/{document-type}")
	public Page<PropietarioInmueble> findByDocumentType(@PathVariable("document-type") String documentType,
			Pageable pageable) {
		return propInmService.findByDocumentType(documentType, pageable);
	}

	// ================================
	// ===== GET BY DOCUMENT NUMBER ===
	// ================================
	/**
	 * This method returns a list of owner/s according to document number
	 */
	@GetMapping("/document-number/{document-number}")
	public Page<PropietarioInmueble> findByDocumentNumber(@PathVariable("document-number") String documentNumber,
			Pageable pageable) {
		return propInmService.findByDocumentNumber(documentNumber, pageable);
	}

	// ========================
	// ===== GET BY ADDRESS ===
	// =======================
	/**
	 * This method returns a list of owner/s according to address
	 */
	@GetMapping("/address/{address}")
	public Page<PropietarioInmueble> findByAddress(@PathVariable("address") String address, Pageable pageable) {
		return propInmService.findByAddress(address, pageable);
	}

	// ==================================
	// ===== GET BY MAIN PHONE NUMBER ===
	// ==================================
	/**
	 * This method returns a list of owner/s according to main phone number
	 */
	@GetMapping("/main-phone-number/{mainPhoneNumber}")
	public Page<PropietarioInmueble> findByMainPhoneNumber(@PathVariable("mainPhoneNumber") String mainPhoneNumber,
			Pageable pageable) {
		return propInmService.findByMainPhoneNumber(mainPhoneNumber, pageable);
	}

	// =======================================
	// ===== GET BY SECONDARY PHONE NUMBER ===
	// =======================================
	/**
	 * This method returns a list of owner/s according to secondary phone number
	 */
	@GetMapping("/secondary-phone-number/{secondaryPhoneNumber}")
	public Page<PropietarioInmueble> findBySecondaryPhoneNumber(
			@PathVariable("secondaryPhoneNumber") String secondaryPhoneNumber,
			Pageable pageable) {
		return propInmService.findBySecondaryPhoneNumber(secondaryPhoneNumber, pageable);
	}

	// ===============================================
	// ===== GET BY MAIN OR SECONDARY PHONE NUMBER ===
	// ===============================================
	/**
	 * This method returns a list of owner/s according to main or secondary phone number
	 */
	@GetMapping("/phone-number-filter/{phoneNumberFilter}")
	public Page<PropietarioInmueble> findByPhoneNumberFilter(
			@PathVariable("phoneNumberFilter") String phoneNumberFilter,
			Pageable pageable) {
		return propInmService.findByPhoneNumberFilter(phoneNumberFilter, pageable);
	}

	// =======================
	// ===== GET BY EMAIL ===
	// =======================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR EMAIL---
	@GetMapping("/email/{email}")
	public Page<PropietarioInmueble> findByEmail(@PathVariable("email") String email, Pageable pageable) {

		return propInmService.findByEmail(email, pageable);

	}

}