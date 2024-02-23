package com.sistema_inmobiliaria.services;

import java.sql.Date;
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
	public void addPropInm(PropietarioInmueble propInm) {
		try {

			if (propInm == null || propInm.toString().isEmpty()) {
				logger.error(
						"ERROR addPropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm + " ES NULO O VACIO!!");
			} else {
				iPropInmRepository.save(propInm);
			}

		} catch (Exception e) {
			logger.error(
					"ERROR addInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm + " NO SE HA INSERTADO EN LA DB!!");

		}
	}

	// ==============
	// ===== PUT=====
	// ==============
	public void updatePropInm(long id, PropietarioInmueble propInm) {
		try {

			if (propInm == null) {
				logger.error("ERROR updatePropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm + " ES NULO!!");

			} else {
				PropietarioInmueble newPropInm = iPropInmRepository.findById(id);

				newPropInm.setName(propInm.getName());
				newPropInm.setLastName(propInm.getLastName());
				newPropInm.setAge(propInm.getAge());
				newPropInm.setBirthdate(propInm.getBirthdate());
				newPropInm.setDocumentType(propInm.getDocumentType());
				newPropInm.setDocumentNumber(propInm.getDocumentNumber());
				newPropInm.setDirec(propInm.getDirec());
				newPropInm.setNroTelPrinc(propInm.getNroTelPrinc());
				newPropInm.setNroTelSec(propInm.getNroTelSec());
				newPropInm.setEmail(propInm.getEmail());

				iPropInmRepository.save(newPropInm);

			}

		} catch (Exception e) {
			logger.error("ERROR updatePropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm
					+ " NO SE HA ACTUALIZADO EN LA DB!!");
		}
	}

	// ==================
	// ===== DELETE =====
	// ==================
	public boolean deletePropInm(long id) {
		try {
			if (id <= 0) {
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
	public Page<PropietarioInmueble> getAllFilterPropInm(String filter, Pageable pageable) {

		return iPropInmRepository.findAllFilter(filter, pageable);
	}

	// ================================
	// ===== GET ALL EXCLUDE FILTER=====
	// ================================
	public Page<PropietarioInmueble> getAllExcludeFilterPropInm(String filter, Pageable pageable) {

		return iPropInmRepository.findAllExcludeFilter(filter, pageable);
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
	// ===== GET BY NAME ===
	// =======================
	public Page<PropietarioInmueble> findByName(String name, Pageable pageable) {
		return iPropInmRepository.findByName(name, pageable);
	}

	// =======================
	// ===== GET BY LASTNAME ===
	// =======================
	public Page<PropietarioInmueble> findByLastName(String lastName, Pageable pageable) {
		return iPropInmRepository.findByLastName(lastName, pageable);
	}

	// =======================
	// ===== GET BY AGE ===
	// =======================
	public Page<PropietarioInmueble> findByAge(int age, Pageable pageable) {
		return iPropInmRepository.findByAge(age, pageable);
	}

	// ==========================
	// ===== GET BY AGE (MAX)===
	// ==========================
	public Page<PropietarioInmueble> findByAgeMax(int maxAge, Pageable pageable) {
		try {
			return iPropInmRepository.findByAgeMax(maxAge, pageable);
		} catch (Exception e) {
			return null;
		}
	}

	// ================================
	// ===== GET BY AGE (MAX & MIN)===
	// ================================
	public Page<PropietarioInmueble> findByAgeMinMax(int minAge, int maxAge, Pageable pageable) {
		try {
			return iPropInmRepository.findByAgeMinMax(minAge, maxAge, pageable);
		} catch (Exception e) {
			return null;
		}
	}

	// ==========================
	// ===== GET BY BIRTHDATE ===
	// ==========================
	public Page<PropietarioInmueble> findByBirthdate(Date birthdate, Pageable pageable) {
		return iPropInmRepository.findByBirthdate(birthdate, pageable);
	}

	// ==============================
	// ===== GET BY DOCUMENT TYPE ===
	// ==============================
	public Page<PropietarioInmueble> findByDocumentType(String documentType, Pageable pageable) {
		return iPropInmRepository.findByDocumentType(documentType, pageable);
	}

	// ================================
	// ===== GET BY DOCUMENT NUMBER ===
	// ===============================
	public Page<PropietarioInmueble> findByDocumentNumber(String documentNumber, Pageable pageable) {
		return iPropInmRepository.findByDocumentNumber(documentNumber, pageable);
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