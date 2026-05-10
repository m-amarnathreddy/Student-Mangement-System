package com.studentmanagement.repository;

import java.util.List;


import com.studentmanagement.model.User;

public interface UserDao {
		int registerUser(User user);
		List<User> getAllUsers();
		boolean deleteUserById(int userId);
		User getUserById(int userId);
		boolean updateUserById(User user);
		User loginUser(String username,String password,String role);
		boolean updatePassword(int userId, String finalPassword);
}
