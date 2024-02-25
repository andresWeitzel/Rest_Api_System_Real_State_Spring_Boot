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
			+ ", lower(c.documentType) , lower(c.documentNumber), lower(c.address), lower(c.mainPhoneNumber), lower(c.secondaryPhoneNumber), lower(c.email) "
			+ ") like lower( concat ( '%', ?1, '%'))")
	public abstract Page<PropietarioInmueble> findAllFilter(String filtro, Pageable pageable);

	
	@Query("select c from PropietarioInmueble c where not concat( lower(c.name), lower(c.lastName), c.birthdate"
			+ ", lower(c.documentType), lower(c.documentNumber), lower(c.address), lower(c.mainPhoneNumber), lower(c.secondaryPhoneNumber), lower(c.email)"
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

	@Query("select c from PropietarioInmueble c where lower(c.address) like lower(concat('%', :address, '%'))")
	public abstract Page<PropietarioInmueble> findByAddress(String address, Pageable pageable);

	@Query("select c from PropietarioInmueble c where lower(c.mainPhoneNumber) like lower(concat('%', :mainPhoneNumber, '%'))")
	public abstract Page<PropietarioInmueble> findByMainPhoneNumber(String mainPhoneNumber, Pageable pageable);

	@Query("select c from PropietarioInmueble c where lower(c.secondaryPhoneNumber) like lower(concat('%', :secondaryPhoneNumber, '%'))")
	public abstract Page<PropietarioInmueble> findBySecondaryPhoneNumber(String secondaryPhoneNumber, Pageable pageable);
	
	@Query("select c from PropietarioInmueble c where lower(c.mainPhoneNumber) like lower(concat('%', :phoneNumberFilter, '%')) or lower(c.secondaryPhoneNumber) like lower(concat('%', :phoneNumberFilter, '%'))")
	public abstract Page<PropietarioInmueble> findByPhoneNumberFilter(String phoneNumberFilter, Pageable pageable);

	@Query("select c from PropietarioInmueble c where lower(c.email) like lower(concat('%', :email, '%'))")
	public abstract Page<PropietarioInmueble> findByEmail(String email, Pageable pageable);


}
