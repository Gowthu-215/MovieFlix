package com.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.repository.UserRepository;
import com.movieflix.entities.User;

@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	UserRepository urepo;

	public UserServiceImplementation(UserRepository urepo) {
		super();
		this.urepo = urepo;
	}

	@Override
	public String addUsers(User user) {
		urepo.save(user);
		return "user is created";
	}

	@Override
	public boolean emailExists(String email) {
		if(urepo.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkUser(String email, String password) {
		//Checking email and getting user details from DB
		User usr=urepo.findByEmail(email);
		//Getting DB
		String db_password =usr.getPassword();
		if(db_password.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<User> viewUser() {
		List<User> userList=urepo.findAll();
		return userList;
	}

	@Override
	public User getUser(String email) {
		User user =urepo.findByEmail(email);
		return user;
	}

	@Override
	public void updateUser(User user) {
		urepo.save(user);
		
	}

	
	

}
