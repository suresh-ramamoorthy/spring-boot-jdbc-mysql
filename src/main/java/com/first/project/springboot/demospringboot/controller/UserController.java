package com.first.project.springboot.demospringboot.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.project.springboot.demospringboot.dto.GenericResponse;
import com.first.project.springboot.demospringboot.dto.User;
import com.first.project.springboot.demospringboot.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
 
	@Autowired
	private UserService userservice;
	
 @PostMapping(value = "/create")
 public GenericResponse<User> createUser(@RequestBody User user) throws ClassNotFoundException, SQLException {
	 
	 userservice.save(user);
	 
	 GenericResponse<User> response = new GenericResponse<User>();
	 
	    response.setData(null);
		response.setDatalist(null);
		response.setStatus("SUCCESS");
		response.setMessage("user saved information successfully");

	  return response;
 }
 
 
 @GetMapping(value = "/getAll")
 public GenericResponse < User> getAllUsers() throws ClassNotFoundException, SQLException {
	
	 List<User> users = userservice.getAllUsers();
	 
     GenericResponse<User> response = new GenericResponse<User>();
     
     response.setData(null);
     response.setDatalist(users);
 	response.setStatus("SUCCESS");
	response.setMessage("user  information  fetched successfully");

	  return response;
 
 }
 
 
 @PutMapping(value = "/put")
	private GenericResponse<User> updateUser(@RequestBody User user) throws SQLException, ClassNotFoundException {
	 
		userservice.update(user);
		
        GenericResponse<User> response = new GenericResponse<User>();
        
		response.setData(user);
		response.setDatalist(null);
		response.setStatus("SUCCESS");
		response.setMessage("user  information  updated successfully");

		return response;
}
 
 @DeleteMapping(value = "/delete")
	private GenericResponse<User> deleteUser(@RequestBody User user) throws SQLException, ClassNotFoundException {
	 
		userservice.delete(user);
		
        GenericResponse<User> response = new GenericResponse<User>();
        
		response.setData(user);
		response.setDatalist(null);
		response.setStatus("SUCCESS");
		response.setMessage("user  information  updated successfully");

		return response;
	}
 
 @GetMapping(value = "/getby/{id}")
	private GenericResponse<User> getById(@PathVariable Integer id) throws SQLException, ClassNotFoundException {
		
		User user=userservice.getById(id);
		
        GenericResponse<User> response = new GenericResponse<User>();
        
		response.setData(user);
		response.setDatalist(null);
		response.setStatus("SUCCESS");
		response.setMessage("user  information  updated successfully");
		return response;

	}
 
}
