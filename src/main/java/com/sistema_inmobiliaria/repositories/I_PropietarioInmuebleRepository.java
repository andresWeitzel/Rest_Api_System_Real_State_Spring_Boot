package com.sistema_inmobiliaria.repositories;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sistema_inmobiliaria.entities.PropietarioInmueble;

@Repository
public interface I_PropietarioInmuebleRepository extends JpaRepository<PropietarioInmueble, Serializable>,
		PagingAndSortingRepository<PropietarioInmueble, Serializable> {


	public abstract Page<PropietarioInmueble> findAll(Pageable pageable);
	
	@Query("select c from PropietarioInmueble c where concat( lower(c.name), lower(c.lastName), c.birthdate"
			+ ", lower(c.documentType) , lower(c.documentNumber), lower(c.direc), lower(c.nroTelPrinc), lower(c.nroTelSec), lower(c.email) "
			+ ") like lower( concat ( '%', ?1, '%'))")
	public abstract Page<PropietarioInmueble> findAllFilter(String filtro, Pageable pageable);

	
	@Query("select c from PropietarioInmueble c where not concat( lower(c.name), lower(c.lastName), c.birthdate"
			+ ", lower(c.documentType), lower(c.documentNumber), lower(c.direc), lower(c.nroTelPrinc), lower(c.nroTelSec), lower(c.email)"
			+ ") like lower( concat ( '%', ?1, '%'))")
	public abstract Page<PropietarioInmueble> findAllExcludeFilter(String filtro, Pageable pageable);
	
	public abstract PropietarioInmueble findById(long id);

	@Query("select c from PropietarioInmueble c where lower(c.name) like lower(concat('%', :nombre, '%'))")
	public abstract Page<PropietarioInmueble> findByName(String nombre, Pageable pageable);

	@Query("select c from PropietarioInmueble c where lower(c.lastName) like lower(concat('%', :lastName, '%'))")
	public abstract Page<PropietarioInmueble> findByLastName(String lastName, Pageable pageable);

	public abstract Page<PropietarioInmueble> findByAge(int age, Pageable pageable);
	
	@Query("select c from PropietarioInmueble c where c.age <= ?1")
	public abstract Page<PropietarioInmueble> findByAgeMax(int maxage, Pageable pageable);
	
	@Query("select c from PropietarioInmueble c where c.age >= ?1 and c.age <=?2")
	public abstract Page<PropietarioInmueble> findByAgeMinMax(int minage, int maxage, Pageable pageable);

	public abstract Page<PropietarioInmueble> findByBirthdate(Date birthdate, Pageable pageable);

	@Query("select c from PropietarioInmueble c where lower(c.documentType) like lower(concat('%', :documentType, '%'))")
	public abstract Page<PropietarioInmueble> findByDocumentType(String documentType, Pageable pageable);

	@Query("select c from PropietarioInmueble c where lower(c.documentNumber) like lower(concat('%', :documentNumber, '%'))")
	public abstract Page<PropietarioInmueble> findByDocumentNumber(String documentNumber, Pageable pageable);

	@Query("select c from PropietarioInmueble c where lower(c.direc) like lower(concat('%', :direc, '%'))")
	public abstract Page<PropietarioInmueble> findByDirec(String direc, Pageable pageable);

	@Query("select c from PropietarioInmueble c where lower(c.nroTelPrinc) like lower(concat('%', :nroTelPrinc, '%'))")
	public abstract Page<PropietarioInmueble> findByNroTelPrinc(String nroTelPrinc, Pageable pageable);

	@Query("select c from PropietarioInmueble c where lower(c.nroTelSec) like lower(concat('%', :nroTelSec, '%'))")
	public abstract Page<PropietarioInmueble> findByNroTelSec(String nroTelSec, Pageable pageable);
	
	@Query("select c from PropietarioInmueble c where lower(c.nroTelPrinc) like lower(concat('%', :nroTelFilter, '%')) "
			+ "or lower(c.nroTelSec) like lower(concat('%', :nroTelFilter, '%'))")
	public abstract Page<PropietarioInmueble> findByNroTelFilter(String nroTelFilter, Pageable pageable);

	@Query("select c from PropietarioInmueble c where lower(c.email) like lower(concat('%', :email, '%'))")
	public abstract Page<PropietarioInmueble> findByEmail(String email, Pageable pageable);


}
