package com.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.exceptions.UserNotFoundException;
import com.user.model.Mail;
import com.user.model.User;
import com.user.service.MailService;
import com.user.service.UserService;

@RestController
@RequestMapping("api/")
public class UserListController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MailService mailService;
	
	
	@RequestMapping(value="users", method=RequestMethod.GET)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="users/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException{
		return userService.getUser(id);
	}
	
	
	@RequestMapping(value="mails", method=RequestMethod.GET)
	public List<Mail> getAllMails(){
		return mailService.getAllMails();
	}
	
	
	@RequestMapping(value="users", method=RequestMethod.POST)
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		ResponseEntity<Object> newUser= userService.addUser(user);
		mailService.sendEmail(user);
		return newUser;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable int id) throws UserNotFoundException {
		return userService.updateUser(user, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteUser(@PathVariable int id) throws UserNotFoundException {
		userService.deleteUser(id);
    }

}
