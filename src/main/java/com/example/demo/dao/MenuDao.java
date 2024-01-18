package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Menu;

 
public interface MenuDao extends CrudRepository<Menu,Integer> {

}
