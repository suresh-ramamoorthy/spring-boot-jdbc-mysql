package com.first.project.springboot.demospringboot.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.project.springboot.demospringboot.dto.User;
import com.first.project.springboot.demospringboot.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	public void save (User user) throws ClassNotFoundException, SQLException {
		
		
		userRepository.save(user);
		
	}
	
	
    public List<User> getAllUsers () throws ClassNotFoundException, SQLException {
		
		
		 return userRepository.getAllUsers();
		
	}
    
    public void update(User user) throws SQLException, ClassNotFoundException {
    	
		userRepository.update(user);


	}


	public void delete(User user) throws SQLException, ClassNotFoundException {
		
		userRepository.delete(user);
}
	

	public User getById(Integer Id) throws SQLException, ClassNotFoundException {
		
		return userRepository.getById(Id);

	}
	
	
}
