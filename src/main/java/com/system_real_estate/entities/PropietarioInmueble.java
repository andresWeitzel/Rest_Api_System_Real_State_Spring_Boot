package com.system_real_estate.entities;

import java.util.Date;
import java.util.UUID;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false)
	@JsonProperty("id")
	private UUID id;
	
	@Column(name="nombre", nullable=false, length=100)
	@JsonProperty("nombre")
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=100)
	@JsonProperty("apellido")
	private String apellido;
	
	@Column(name="edad", nullable=false)
	@JsonProperty("edad")
	private int edad;
	
	@Column(name="fecha_nacimiento", nullable=false)
	@JsonProperty("fecha_nacimiento")
	private Date fechaNac;
	
	@Column(name="tipo_documento", nullable=false, length=30)
	@JsonProperty("tipo_documento")
	private String tipoDoc;
	
	@Column(name="nro_documento", nullable=false, length=50 , unique=true)
	@JsonProperty("nro_documento")
	private String nroDoc;
	
	@Column(name="direccion", nullable=false, length=100 )
	@JsonProperty("direccion")
	private String direc;
	
	@Column(name="nro_telefono_principal", nullable=false, length=40 , unique=true)
	@JsonProperty("nro_telefono_principal")
	private String nroTelPrinc;
	
	@Column(name="nro_telefono_secundario", nullable=true, length=50 )
	@JsonProperty("nro_telefono_secundario")
	private String nroTelSec;
	
	@Column(name="email", nullable=true, length=50 , unique=true)
	@JsonProperty("email")
	private String email;
	
	@Column(name="created_at", nullable=false)
	@JsonProperty("created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name="updated_at", nullable=false)
	@JsonProperty("updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	
	
	
}
