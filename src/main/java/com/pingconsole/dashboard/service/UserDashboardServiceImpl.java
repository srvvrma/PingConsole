package com.pingconsole.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingconsole.auth.model.User;
import com.pingconsole.auth.repository.UserRepository;
import com.pingconsole.users.dto.UserDTO;

@Service
public class UserDashboardServiceImpl implements UserDashboardService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDTO> getAllUserList() {
		List<User> users = userRepository.findAll();
		List<UserDTO> userDTOs = this.parseUserList(users);
		return userDTOs;
	}

	@Override
	public List<UserDTO> parseUserList(List<User> users) {
		List<UserDTO> userDTOs = new ArrayList<>();
		for (User user : users) {
			userDTOs.add(UserDTO.getUserDto(user));
		}
		return userDTOs;
	}

	@Override
	public UserDTO getUserDTOByUserId(Long id) {
		User user = userRepository.findById(id);
		return UserDTO.getUserDto(user);
	}

}
