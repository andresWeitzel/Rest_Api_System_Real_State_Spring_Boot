package com.system_real_estate.controllers;

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

import com.system_real_estate.entities.PropietarioInmueble;
import com.system_real_estate.services.PropietarioInmuebleService;

@RestController
@RequestMapping("/api/v1/propietarios-inmuebles")
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
	// ---PROPIETARIO POR ID---
	@GetMapping("/id/{id}")
	public PropietarioInmueble findById(@PathVariable("id") int id) {
		return propInmService.findById(id);
	}

	// =======================
	// ===== GET BY NOMBRE ===
	// =======================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR NOMBRE---
	@GetMapping("/nombre/{nombre}")
	public Page<PropietarioInmueble> findByNombre(@PathVariable("nombre") String nombre, Pageable pageable) {

		return propInmService.findByNombre(nombre, pageable);

	}

	// =======================
	// ===== GET BY APELLIDO ===
	// =======================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR APELLIDO---
	@GetMapping("/apellido/{apellido}")
	public Page<PropietarioInmueble> findByApellido(@PathVariable("apellido") String apellido, Pageable pageable) {

		return propInmService.findByApellido(apellido, pageable);

	}

	// =======================
	// ===== GET BY EDAD ===
	// =======================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR EDAD---
	@GetMapping("/edad/{edad}")
	public Page<PropietarioInmueble> findByEdad(@PathVariable("edad") int edad, Pageable pageable) {

		return propInmService.findByEdad(edad, pageable);

	}

	// ===========================
	// ===== GET BY EDAD (MAX) ===
	// ===========================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR EDAD MÁXIMA---
	@GetMapping("/edad-maxima/{maxEdad}")
	public Page<PropietarioInmueble> findByEdadMax(@PathVariable("maxEdad") int maxEdad, Pageable pageable) {
		try {
			return propInmService.findByEdadMax(maxEdad, pageable);
		} catch (Exception e) {
			return null;
		}

	}

	// ===================================
	// ===== GET BY EDAD ( MIN & MAX ) ===
	// ===================================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR EDAD MÁXIMA Y MÍNIMA---
	@GetMapping("/edad-minima-maxima/{minEdad}/{maxEdad}")
	public Page<PropietarioInmueble> findByEdadMinMax(@PathVariable("minEdad") int minEdad,
			@PathVariable("maxEdad") int maxEdad, Pageable pageable) {
		try {
			return propInmService.findByEdadMinMax(minEdad, maxEdad, pageable);
		} catch (Exception e) {
			return null;
		}

	}

	// ==========================
	// ===== GET BY FECHA NAC ===
	// ==========================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR FECHA DE NAC---
	@GetMapping("/fecha-nacimiento/{fecha}")
	public Page<PropietarioInmueble> findByFechaNac(@PathVariable("fecha") Date fechaNacimiento, Pageable pageable) {

		return propInmService.findByFechaNac(fechaNacimiento, pageable);

	}

	// =======================
	// ===== GET BY TIPO DOC ===
	// =======================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR TIPO DOC---
	@GetMapping("/tipo-documento/{tipo_documento}")
	public Page<PropietarioInmueble> findByTipoDoc(@PathVariable("tipo_documento") String tipoDocumento,
			Pageable pageable) {

		return propInmService.findByTipoDoc(tipoDocumento, pageable);

	}

	// =======================
	// ===== GET BY NRO DOC ===
	// =======================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR NRO DE DOC---
	@GetMapping("/numero-documento/{nro_documento}")
	public Page<PropietarioInmueble> findByNroDoc(@PathVariable("nro_documento") String nroDocumento,
			Pageable pageable) {

		return propInmService.findByNroDoc(nroDocumento, pageable);

	}

	// =======================
	// ===== GET BY DIREC ===
	// =======================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR DIREC---
	@GetMapping("/direccion/{direccion}")
	public Page<PropietarioInmueble> findByDirec(@PathVariable("direccion") String direcccion, Pageable pageable) {

		return propInmService.findByDirec(direcccion, pageable);

	}

	// ==============================
	// ===== GET BY NRO TEL PRINC ===
	// ===============================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR NRO DE TEL PRINC---
	@GetMapping("/numero-telefono-principal/{nro-tel-princ}")
	public Page<PropietarioInmueble> findByNroTelPrinc(@PathVariable("nro-tel-princ") String nroTelefonoPrincipal,
			Pageable pageable) {

		return propInmService.findByNroTelPrinc(nroTelefonoPrincipal, pageable);

	}

	// ==============================
	// ===== GET BY NRO TEL SEC ===
	// ===============================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR NRO DE TEL SEC---
	@GetMapping("/numero-telefono-secundario/{nro-tel-sec}")
	public Page<PropietarioInmueble> findByNroTelSec(@PathVariable("nro-tel-sec") String nroTelefonoSecundario,
			Pageable pageable) {

		return propInmService.findByNroTelSec(nroTelefonoSecundario, pageable);

	}

	// =====================================
	// ===== GET BY NRO TEL PRINC OR SEC ===
	// =====================================
	// ---LISTADO DE PROPIETARIOS O PROPIETARIO POR NRO DE TEL PRINC O SEC---
	@GetMapping("/numero-telefono-filter/{nro-tel-filter}")
	public Page<PropietarioInmueble> findByNroTelFilter(@PathVariable("nro-tel-filter") String nroTelefonoFilter,
			Pageable pageable) {

		return propInmService.findByNroTelFilter(nroTelefonoFilter, pageable);

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