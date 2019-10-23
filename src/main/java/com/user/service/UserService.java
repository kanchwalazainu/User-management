package com.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.exceptions.UserNotFoundException;
import com.user.model.User;
import com.user.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	public List<User> getAllUsers(){
		
		List<User> users= new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
		
	}
	
	public ResponseEntity<User> getUser(int userid) throws UserNotFoundException  {
	// User user=users.stream().filter(u -> u.getUserid()==(userid)).findFirst().get();
	 
	 Optional<User> user = userRepository.findById(userid);

		if (!user.isPresent())
			throw new UserNotFoundException("User not found for this id :: " + userid);
		
		
	        return ResponseEntity.ok().body(user.get());
	}
	
	public ResponseEntity<Object> addUser(User user) {
		//users.add(user);
		return  ResponseEntity.ok(userRepository.save(user));
		
	}
	
	
	
	public ResponseEntity<User> updateUser(User user, int userid) throws UserNotFoundException {
		/*
		 * for(int i=0;i<users.size();i++) { User u=users.get(i);
		 * if(u.getUserid()==userid){ users.set(i, user); return; }
		 * 
		 * 
		 * }
		 */
		
		Optional<User> existingUser = userRepository.findById(userid);

		if (!existingUser.isPresent())
			throw new UserNotFoundException("User not found for this id :: " + userid);

		existingUser.get().setEmailId(user.getEmailId());
		existingUser.get().setLastName(user.getLastName());
		existingUser.get().setFirstName(user.getFirstName());
		
		User updatedUser=userRepository.save(existingUser.get());

		return ResponseEntity.ok(updatedUser);
	}

	
	
	public void deleteUser(int userid) throws UserNotFoundException{
		Optional<User> existingUser = userRepository.findById(userid);

		if (!existingUser.isPresent())
			throw new UserNotFoundException("User not found for this id :: " + userid);

		existingUser.get().setDeletedFlag(true);
		
		userRepository.save(existingUser.get());

	
		
		
	}
	

}
