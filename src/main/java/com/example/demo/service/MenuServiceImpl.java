package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MenuDao;
import com.example.demo.entity.Menu;
import com.example.demo.exceptions.NotFoundException;
import com.google.common.base.Optional;
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired 
	MenuDao menudao;

	@Override
	public List<Menu> GetAll() {
		// TODO Auto-generated method stub
		return (List<Menu>) menudao.findAll();
	}

	@Override
	public Menu FindById(int id) {
		// TODO Auto-generated method stub
		//return menudao.findById(id).orElse(null);
		java.util.Optional<Menu> menuOptional = menudao.findById(id);
	    if (menuOptional.isPresent()) {
	        return menuOptional.get();
	    } else {
	        throw new NotFoundException("No se encontró el ID del Menu  ingresado");
	    }
	}

	@Override
	public void modify(int id, Menu menu) {
		// TODO Auto-generated method stub
		if(menudao.existsById(id)) {
			menu.setId(id);
			menudao.save(menu);
		}else {
			
			throw new NotFoundException("No se encontro el id ingresado");
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		if(menudao.existsById(id)) {
			menudao.deleteById(id);
			}else {
				
				throw new NotFoundException("No se encontro el id ingresado");
			}
	}

	@Override
	public void create(Menu menu) {
		// TODO Auto-generated method stub
		menudao.save(menu);
	}

}
