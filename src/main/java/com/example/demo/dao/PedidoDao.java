package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Pedido;

 

public interface PedidoDao  extends CrudRepository<Pedido,Integer> {

}
