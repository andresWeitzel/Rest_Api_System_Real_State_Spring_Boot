package com.sistema_inmobiliaria.services;

import java.sql.Date;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sistema_inmobiliaria.entities.PropietarioInmueble;
import com.sistema_inmobiliaria.repositories.I_PropietarioInmuebleRepository;

@Service
public class PropietarioInmuebleService {

	// For Inyec. Dep.
	@Autowired
	private I_PropietarioInmuebleRepository iPropInmRepository;

	// For logs
	private static final Logger logger = org.apache.logging.log4j.LogManager
			.getLogger(PropietarioInmuebleService.class);

	// ===============================================
	// ============= MÉTODOS HTTP CRUD ==============
	// ===============================================

	// ================
	// ===== POST =====
	// =================
	public boolean addPropInm(PropietarioInmueble propInm) {
		try {

			if (propInm == null || propInm.toString().isEmpty()) {
				logger.error(
						"ERROR addPropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm + " ES NULO O VACIO!!");
				return false;
			} else {
				iPropInmRepository.save(propInm);
				return true;
			}

		} catch (Exception e) {
			logger.error(
					"ERROR addInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm + " NO SE HA INSERTADO EN LA DB!!");
			return false;

		}
	}

	// ==============
	// ===== PUT=====
	// ==============
	public boolean updatePropInm(PropietarioInmueble propInm) {
		try {

			if (propInm == null) {
				logger.error("ERROR updatePropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm + " ES NULO!!");
				return false;

			} else {
				iPropInmRepository.save(propInm);
				return true;

			}

		} catch (Exception e) {
			logger.error("ERROR updatePropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm
					+ " NO SE HA ACTUALIZADO EN LA DB!!");
			return false;

		}
	}

	// ==================
	// ===== DELETE =====
	// ==================
	public boolean deletePropInm(UUID id) {
		try {
			if (id == null) {
				logger.error("ERROR deletePropietarioInmueble : EL ID DEL PROPIETARIO DEL INMUEBLE NO EXISTE!!");
				return false;

			} else {
				iPropInmRepository.deleteById(id);
				return true;

			}

		} catch (Exception e) {
			logger.error("ERROR deletePropietarioInmueble : EL PROPIETARIO DEL INMUEBLE CON EL ID " + id
					+ " NO SE HA ELIMINADO DE LA DB!!");
			return false;

		}
	}

	// ===================
	// ===== GET ALL =====
	// ===================
	public Page<PropietarioInmueble> getAllPropInm(Pageable pageable) {

		return iPropInmRepository.findAll(pageable);
	}
	
	// =========================
	// ===== GET ALL FILTER=====
	// =========================
	public Page<PropietarioInmueble> getAllFilterPropInm(String filter,Pageable pageable) {

		return iPropInmRepository.findAllFilter(filter,pageable);
	}
	
	// ================================
	// ===== GET ALL EXCLUDE FILTER=====
	// ================================
	public Page<PropietarioInmueble> getAllExcludeFilterPropInm(String filter,Pageable pageable) {

		return iPropInmRepository.findAllExcludeFilter(filter,pageable);
	}

	// ==================================================
	// ============= MÉTODOS HTTP BÚSQUEDA =============
	// ==================================================

	// ===================
	// ===== GET BY ID ===
	// ===================
	public PropietarioInmueble findById(int id) {
		return iPropInmRepository.findById(id);
	}

	// =======================
	// ===== GET BY NOMBRE ===
	// =======================
	public Page<PropietarioInmueble> findByNombre(String nombre, Pageable pageable) {
		return iPropInmRepository.findByNombre(nombre, pageable);
	}

	// =======================
	// ===== GET BY APELLIDO ===
	// =======================
	public Page<PropietarioInmueble> findByApellido(String apellido, Pageable pageable) {
		return iPropInmRepository.findByApellido(apellido, pageable);
	}

	// =======================
	// ===== GET BY EDAD ===
	// =======================
	public Page<PropietarioInmueble> findByEdad(int edad, Pageable pageable) {
		return iPropInmRepository.findByEdad(edad, pageable);
	}

	// ==========================
	// ===== GET BY EDAD (MAX)===
	// ==========================
	public Page<PropietarioInmueble> findByEdadMax(int maxEdad, Pageable pageable) {
		try {
			return iPropInmRepository.findByEdadMax(maxEdad, pageable);
		} catch (Exception e) {
			return null;
		}
	}

	// ================================
	// ===== GET BY EDAD (MAX & MIN)===
	// ================================
	public Page<PropietarioInmueble> findByEdadMinMax(int minEdad, int maxEdad, Pageable pageable) {
		try {
			return iPropInmRepository.findByEdadMinMax(minEdad, maxEdad, pageable);
		} catch (Exception e) {
			return null;
		}
	}

	// =======================
	// ===== GET BY FECHA NAC ===
	// =======================
	public Page<PropietarioInmueble> findByFechaNac(Date fechaNac, Pageable pageable) {
		return iPropInmRepository.findByFechaNac(fechaNac, pageable);
	}

	// =======================
	// ===== GET BY TIPO DOC ===
	// =======================
	public Page<PropietarioInmueble> findByTipoDoc(String tipoDoc, Pageable pageable) {
		return iPropInmRepository.findByTipoDoc(tipoDoc, pageable);
	}

	// =======================
	// ===== GET BY NRO DOC ===
	// =======================
	public Page<PropietarioInmueble> findByNroDoc(String nroDoc, Pageable pageable) {
		return iPropInmRepository.findByNroDoc(nroDoc, pageable);
	}

	// =======================
	// ===== GET BY DIREC ===
	// =======================
	public Page<PropietarioInmueble> findByDirec(String direccion, Pageable pageable) {
		return iPropInmRepository.findByDirec(direccion, pageable);
	}

	// ==============================
	// ===== GET BY NRO TEL PRINC ===
	// ===============================
	public Page<PropietarioInmueble> findByNroTelPrinc(String nroTelPrinc, Pageable pageable) {
		return iPropInmRepository.findByNroTelPrinc(nroTelPrinc, pageable);
	}

	// ==============================
	// ===== GET BY NRO TEL SEC ===
	// ===============================
	public Page<PropietarioInmueble> findByNroTelSec(String nroTelSec, Pageable pageable) {
		return iPropInmRepository.findByNroTelSec(nroTelSec, pageable);
	}

	// =====================================
	// ===== GET BY NRO TEL PRINC OR SEC ===
	// =====================================
	public Page<PropietarioInmueble> findByNroTelFilter(String nroTelFilter, Pageable pageable) {
		try {
			return iPropInmRepository.findByNroTelFilter(nroTelFilter, pageable);
		} catch (Exception e) {
			return null;
		}
	}

	// =======================
	// ===== GET BY EMAIL ===
	// =======================
	public Page<PropietarioInmueble> findByEmail(String email, Pageable pageable) {
		return iPropInmRepository.findByEmail(email, pageable);
	}
}