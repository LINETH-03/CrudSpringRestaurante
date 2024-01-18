package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PedidoDao;
import com.example.demo.entity.Pedido;
import com.example.demo.exceptions.NotFoundException;
import com.google.common.base.Optional;
@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired 
	PedidoDao pedidodao;

	@Override
	public List<Pedido> GetAll() {
		// TODO Auto-generated method stub
		return (List<Pedido>) pedidodao.findAll();
	}

	@Override
	public Pedido FindById(int id) {
		// TODO Auto-generated method stub
		//return pedidodao.findById(id).orElse(null);
		java.util.Optional<Pedido> pedidoOptional = pedidodao.findById(id);
	    if (pedidoOptional.isPresent()) {
	        return pedidoOptional.get();
	    } else {
	        throw new NotFoundException("No se encontró el ID del pedido ingresado");
	    }
		
	}

	@Override
	public void modify(int id, Pedido pedido) {
		// TODO Auto-generated method stub
		if(pedidodao.existsById(id)) {
			pedido.setId(id);
			pedidodao.save(pedido);
		}else {
			
			throw new NotFoundException("No se encontro el id ingresado");
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		if(pedidodao.existsById(id)) {
			pedidodao.deleteById(id);
			}else {
				
				throw new NotFoundException("No se encontro el id ingresado");
			}
	}

	@Override
	public void create(Pedido pedido) {
		// TODO Auto-generated method stub
		pedidodao.save(pedido);
	}

}
