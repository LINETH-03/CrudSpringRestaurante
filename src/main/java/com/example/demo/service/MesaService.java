package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Mesa;
 

public interface MesaService {
	
	public List<Mesa> GetAll();
	public Mesa FindById(int id);
	public void modifyMesa(int id, Mesa mesa);
	public void delete(int id);
	public void create(Mesa mesa);

}
