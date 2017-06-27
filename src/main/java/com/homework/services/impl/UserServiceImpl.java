package com.homework.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.model.User;
import com.homework.repositories.UserRepo;
import com.homework.services.UserSerivce;

@Service
public class UserServiceImpl implements UserSerivce{
	
	private UserRepo userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo=userRepo;
	}
	
	@Override
	public List<User> viewAll() {
		return userRepo.viewAll();
	}

	@Override
	public boolean insert(User user) {
		boolean status = userRepo.insert(user);
		if(status){
			System.out.println("One Record has been inserted");
		}else{
			System.out.println("One Record has been inserted");
		}
		return status;
	}

	@Override
	public boolean deleteByUserhash(String user_hash) {
		boolean status = userRepo.delete(user_hash);
		if(status){
			System.out.println("One Record has been deleted");
		}else{
			System.out.println("One Record has been deleted");
		}
		return status;
	}

	@Override
	public boolean updateByUserhash(User user) {
		boolean status = userRepo.update(user);
		if(status){
			System.out.println("One Record has been updated");
		}else{
			System.out.println("One Record has been updated");
		}
		return status;
	}

	@Override
	public User findUserByhash(String user_hash) {
		return userRepo.findUser(user_hash);
	}

	@Override
	public String countGender(String gender) {
		return userRepo.countGender(gender);
	}

	@Override
	public int countDeactivate() {
		return userRepo.countDeactivate();
	}

	@Override
	public User findUserByGender(String gender) {
		return userRepo.findUserbygender(gender);
	}

	

}
