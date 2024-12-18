
package com.project.software.advanced.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.model.User.User;
import com.project.software.advanced.demo.model.User.UserRepository;

@Service
public class UserService implements UserServiceInt {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User getUserById(int userID) {
		Optional<User> user = userRepository.findById(userID);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public User saveUser(User user) {
		if (user.getPassword() == null || user.getPassword().length() < 8) {
			throw new IllegalArgumentException("Password must be at least 8 characters long");
		}
		String passHash = passwordEncoder.encode(user.getPassword());
		
		user.setPassword(passHash);
		return userRepository.save(user);
	};

	@Override
	public User updateUser(User user, int userID) {
		Optional<User> existingUserOptional = userRepository.findById(userID);
		if (!existingUserOptional.isPresent()) {
			return null;
		}
		User existingUser = existingUserOptional.get();
		existingUser.setName(user.getName());
		existingUser.setRole(user.getRole());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(int userID) {
		Optional<User> existingUser = userRepository.findById(userID);
		if (!existingUser.isPresent()) {
			return;
		}
		userRepository.deleteById(userID);
	}

	@Override
	public boolean authUser(String email, String password) {
		Optional<User> userOptional = userRepository.findByEmail(email);
		if (!userOptional.isPresent()) {
			return false;
		}
		User user = userOptional.get();
		if (passwordEncoder.matches(password, user.getPassword()))
			return true;

		return false;
	}

	@Override
	public List<User> fetchUsers() {
		Iterable<User> existingUsers = userRepository.findAll();

		List<User> userList = new ArrayList<>();
		existingUsers.forEach(userList::add);

		return userList;
	}
}
