package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "El tiempo no debe ser nulo")
	@Column(name = "fecha")
	private Date fecha;
	
	
	@NotBlank(message = "Se necesita el estado del pedido")
	@Column(name = "estado")
	private String estado;
	
	@NotBlank(message = "Marque las observaciones")
	@Column(name = "observaciones")
	private String observaciones;
	
	
	@Column(name = "total")
	@Min(value = 1, message = "el total debe ser mayor a 0")
	private Double total;
	@Column(name = "id_menu")
	private int id_menu;
	@Column(name = "id_mesa")
	private int id_mesa;
	
	
	
	public Pedido() {
		super();
	}
	
	
	public Pedido(int id, Date fecha, String estado, String observaciones, Double total, int id_menu, int id_mesa) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.estado = estado;
		this.observaciones = observaciones;
		this.total = total;
		this.id_menu = id_menu;
		this.id_mesa = id_mesa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public int getId_menu() {
		return id_menu;
	}
	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}
	public int getId_mesa() {
		return id_mesa;
	}
	public void setId_mesa(int id_mesa) {
		this.id_mesa = id_mesa;
	}
	
	
	

}
