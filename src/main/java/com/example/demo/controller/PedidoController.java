package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pedido;
import com.example.demo.service.PedidoService;

 

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	PedidoService ser;
	
	@GetMapping 
	public List<Pedido> lists(){
		return ser.GetAll();
	
	}
	@GetMapping(value = "/{id}")
	public Pedido Get(@PathVariable int id) {
		return ser.FindById(id);
		
		
	}
	
	
	@DeleteMapping (value = "/{id}")
	public String Delete(@PathVariable int id) {
		String Messag = "Se ha  eliminado la mesa exitosamente";
		ser.delete(id);
		return Messag;
	}
	
	@PutMapping(value = "/{id}")
	public String modifyr(@PathVariable int id, @RequestBody Pedido pedido) {
		String Messag = "Se ha modificado exitosamente";
		ser.modify(id, pedido);
		return Messag;
	}
	
	@PostMapping
	public String creater(@RequestBody Pedido pedido) {
		String Messag = "Se ha creado exitosamente";
		ser.create(pedido);
		return Messag;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){
		
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return errors;
	}

}
