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

import com.example.demo.entity.Menu;
import com.example.demo.service.MenuService;

 

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	MenuService menuser;
	
	@GetMapping 
	public List<Menu> lists(){
		return menuser.GetAll();
	
	}
	@GetMapping(value = "/{id}")
	public Menu Get(@PathVariable int id) {
		return menuser.FindById(id);
		
		
	}
	
	
	@DeleteMapping (value = "/{id}")
	public String Delete(@PathVariable int id) {
		String Messag = "Se ha  eliminado la mesa exitosamente";
		
		menuser.delete(id);
		return Messag;
	}
	
	@PutMapping(value = "/{id}")
	public String modifyr(@PathVariable int id, @RequestBody Menu menu) {
		String Messag = "Se ha modificado exitosamente";
		menuser.modify(id, menu);
		return Messag;
	}
	
	@PostMapping
	public String creater(@RequestBody Menu menu) {
		String Messag = "Se ha creado exitosamente";
		menuser.create(menu);
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
