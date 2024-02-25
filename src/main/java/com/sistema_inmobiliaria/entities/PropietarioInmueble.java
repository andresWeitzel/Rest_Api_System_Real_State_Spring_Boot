package com.sistema_inmobiliaria.entities;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="propietarios_inmuebles")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropietarioInmueble {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id", nullable=false , unique=true)
	@JsonProperty("id")
	private int id;
	
	@Column(name="name", nullable=false, length=100)
	@JsonProperty("name")
	private String name;
	
	@Column(name="last_name", nullable=false, length=100)
	@JsonProperty("last_name")
	private String lastName;
	
	@Column(name="age", nullable=false)
	@JsonProperty("age")
	private int age;
	
	@Column(name="birthdate", nullable=false)
	@JsonProperty("birthdate")
	private Date birthdate;
	
	@Column(name="document_type", nullable=false, length=30)
	@JsonProperty("document_type")
	private String documentType;
	
	@Column(name="document_number", nullable=false, length=50 , unique=true)
	@JsonProperty("document_number")
	private String documentNumber;
	
	@Column(name="address", nullable=false, length=100 )
	@JsonProperty("address")
	private String address;
	
	@Column(name="main_phone_number", nullable=false, length=40 , unique=true)
	@JsonProperty("main_phone_number")
	private String mainPhoneNumber;
	
	@Column(name="secondary_phone_number", nullable=true, length=50 )
	@JsonProperty("secondary_phone_number")
	private String secondaryPhoneNumber;
	
	@Column(name="email", nullable=true, length=50 , unique=true)
	@JsonProperty("email")
	private String email;

	@Column(name="created_at", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("created_at")
	private Date createdAt;
	
	@Column(name="updated_at", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("updated_at")
	private Date updatedAt;
	
	
	
}
