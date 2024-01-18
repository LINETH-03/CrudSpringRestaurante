package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "mesa")
public class Mesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "capacidad")
	@Min(value = 1, message = "La capacidad de la mesa debe ser mayor a 0")
	private int capacidad;
	
	
	@NotBlank(message = "Se necesita la Ubicacion")
	@Column(name = "ubicacion")
	private String ubicacion;
	
	
	

	public Mesa(int id, int numero, int capacidad, String ubicacion) {
		super();
		this.id = id;
		this.numero = numero;
		this.capacidad = capacidad;
		this.ubicacion = ubicacion;
	}



	public Mesa() {
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
}
	
	