package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Menu;

 

public interface MenuService {
	public List<Menu> GetAll();
	public Menu FindById(int id);
	public void modify(int id, Menu menu);
	public void delete(int id);
	public void create(Menu menu);

}
