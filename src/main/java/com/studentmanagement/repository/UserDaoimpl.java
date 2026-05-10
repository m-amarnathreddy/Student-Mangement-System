package com.studentmanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.Utill.Dbconn1;
import com.studentmanagement.model.User;
import com.studentmanagement.model.User.Role;

public class UserDaoimpl implements UserDao {
	Connection con = Dbconn1.getConnection();

	@Override
	public int registerUser(User user) {
		 int generatedId = -1;
		String registerQuery = "INSERT INTO user(username,password,role) VALUES(?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(registerQuery,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRole().name());
			
			int count = pstmt.executeUpdate();
			if (count > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
	            if (rs.next()) {
	                generatedId = rs.getInt(1);
	            }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return generatedId;
	}

	@Override
	public List<User> getAllUsers() {
		String allUsers = "SELECT * FROM user";
		List<User> ulist = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(allUsers);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(Role.valueOf(rs.getString(4)));
				ulist.add(user);
			}
			return ulist;
		} catch (SQLException e) {
			System.out.println("Error in list user" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteUserById(int userId) {
		String deleteUser = "DELETE FROM user WHERE user_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(deleteUser);
			pstmt.setInt(1, userId);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserById(int userId) {
		String uQuery = "SELECT * FROM user WHERE user_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(uQuery);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(Role.valueOf(rs.getString(4)));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUserById(User user) {
		String update = "UPDATE user SET username=?,password=? WHERE user_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(update);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());			 
			pstmt.setInt(3, user.getUserId());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User loginUser(String username, String password,String role) {
		String uQuery= "SELECT * FROM user WHERE username=? AND password=? AND role=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(uQuery);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			 pstmt.setString(3, role); 

		        ResultSet rs = pstmt.executeQuery();
		        if (rs.next()) {
		            User user = new User();
		            user.setUserId(rs.getInt("user_id"));
		            user.setUsername(rs.getString("username"));
		            user.setPassword(rs.getString("password"));
		            user.setRole(User.Role.valueOf(rs.getString("role").toUpperCase())); 
		            return user;
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean updatePassword(int userId, String finalPassword) {
		String sql = "UPDATE user SET password = ? WHERE user_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, finalPassword);
            pstmt.setInt(2, userId);
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
		
	}
	
}
