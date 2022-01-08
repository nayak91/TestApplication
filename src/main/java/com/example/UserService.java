package com.example;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import com.example.*;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	 
	@Transactional(readOnly = false)
	public void saveUser(User user)
	{ 
		userRepository.save(user);
						
	}
	
	
	@Transactional(readOnly = true)
	public List<User> getAllUser()
	{
	    List<User> userList=userRepository.findAll();
	    return userList;
	}
	


}
