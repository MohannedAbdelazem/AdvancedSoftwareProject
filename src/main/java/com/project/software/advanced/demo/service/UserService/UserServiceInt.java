
package com.project.software.advanced.demo.service.UserService;

import java.util.List;

import com.project.software.advanced.demo.model.User.User;

public interface UserServiceInt {
	User saveUser(User user);

	User getUserByEmail(String email);

	User getUserById(int userID);

	List<User> fetchUsers();

	boolean authUser(String username, String passHash);

	User updateUser(User user, int userID);

	void deleteUser(int userID);
}
