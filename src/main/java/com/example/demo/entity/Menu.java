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
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Se necesita el nombre del Menu")
	@Column(name = "nombre")
	private String nombre;
	
	@NotBlank(message = "Se necesita la descripcion del Menu")
	@Column(name = "descripcion")
	private String descripcion;
	
	
	@Column(name = "precio")
	@Min(value = 1, message = "El precio debe ser mayor a 0")
	private Double precio;
	@NotBlank(message = "Se necesita los ingredientes")
	@Column(name = "ingredientes")
	private String ingredientes;
	
	
	
	
	
	public Menu() {
		super();
	}
	public Menu(int id, String nombre, String descripcion, Double precio, String ingredientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.ingredientes = ingredientes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	

}