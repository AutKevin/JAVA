package com.qy.dao;

import com.qy.entity.User;

public class UserDao {
	public User find(String username, String password) {
		if ("qy".equals(username) && "1995".equals(password)) {
			User user = new User();
			user.setUsername("qy");
			user.setPassword("199526");
			return user;
		} else {
			return null;
		}
	}
}
