package com.homework.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.homework.model.User;

@Repository
public interface UserRepo {

	@Select("SELECT "
			+ " id ,"
			+ " username,"
			+ " email,"
			+ " gender,"
			+ " phonenumber,"
			+ " status,"
			+ " user_hash,"
			+ " created_date "
			+ " FROM users")
	public  List<User> viewAll();
	
	@Select("SELECT "
			+ " id ,"
			+ " username,"
			+ " email,"
			+ " gender,"
			+ " phonenumber,"
			+ " status,"
			+ " user_hash,"
			+ " created_date "
			+ " FROM users WHERE user_hash=#{user_hash}")
	public  User findUser(String user_hash);
	
	@Select("SELECT count(gender) FROM users WHERE gender=#{gender}")
	public String countGender(String gender);
	
	@Select("SELECT count(status) FROM users WHERE status='0'")
	public int countDeactivate();
	
	@Insert("INSERT INTO users("
			+ " username,"
			+ " email,"
			+ " gender,"
			+ " phonenumber,"
			+ " status,"
			+ " user_hash,"
			+ " created_date"
			+ " )VALUES("
			+ " #{user.username},"
			+ " #{user.email},"
			+ " #{user.gender},"
			+ " #{user.phonenumber},"
			+ " #{user.status},"
			+ " #{user.user_hash},"
			+ " NOW())")
	public boolean insert(@Param("user") User user);
	
	@Delete("DELETE FROM users WHERE user_hash=#{user_hash}")
	public boolean delete(String user_hash);
	
	@Update("UPDATE users SET "
			+ "username=#{user.username},"
			+ "email=#{user.email},"
			+ "gender=#{user.gender},"
			+ "phonenumber=#{user.phonenumber},"
			+ "status=#{user.status}"
			+ " WHERE user_hash=#{user.user_hash}")
	public boolean update(@Param("user") User user);
}
