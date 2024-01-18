package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Pedido;

 

public interface PedidoService {
	public List<Pedido> GetAll();
	public Pedido FindById(int id);
	public void modify(int id, Pedido pedido);
	public void delete(int id);
	public void create(Pedido pedido);

}
