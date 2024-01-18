package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MesaDAO;
import com.example.demo.entity.Mesa;
import com.example.demo.exceptions.NotFoundException;
import com.google.common.base.Optional;
@Service
public class MesaServiceImpl implements MesaService {

	@Autowired 
	MesaDAO mesadao;

	@Override
	public List<Mesa> GetAll() {
		// TODO Auto-generated method stub
		return (List<Mesa>) mesadao.findAll();
	}

	@Override
	public Mesa FindById(int id) {
		// TODO Auto-generated method stub
		//return mesadao.findById(id).orElse(null);
		java.util.Optional<Mesa> mesaOptional = mesadao.findById(id);
	    if (mesaOptional.isPresent()) {
	        return mesaOptional.get();
	    } else {
	        throw new NotFoundException("No se encontró el ID de la mesa ingresado");
	    }
		
	}

	@Override
	public void create(Mesa mesa) {
		// TODO Auto-generated method stub
		mesadao.save(mesa);
	}

	@Override
	public void modifyMesa(int id, Mesa mesa) {
		// TODO Auto-generated method stub
		if(mesadao.existsById(id)) {
			mesa.setId(id);
			mesadao.save(mesa);
		}else {
			
			throw new NotFoundException("No se encontro el id ingresado");
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		if(mesadao.existsById(id)) {
			mesadao.deleteById(id);
			}else {
				
				throw new NotFoundException("No se encontro el id ingresado");
			}
	}

}
