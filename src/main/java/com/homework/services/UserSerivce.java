package com.homework.services;

import java.util.List;

import com.homework.model.User;

public interface UserSerivce {

	public List<User> viewAll();
	public boolean insert(User user);
	public boolean deleteByUserhash(String user_hash);
	public boolean updateByUserhash(User user);
	public User findUserByhash(String user_hash);
	public String countGender(String gender);
	public int countDeactivate();
	public User findUserByGender(String gender);
}
