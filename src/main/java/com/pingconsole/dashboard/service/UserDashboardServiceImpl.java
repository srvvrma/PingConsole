package com.pingconsole.dashboard.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingconsole.auth.model.Role;
import com.pingconsole.auth.model.User;
import com.pingconsole.auth.repository.RoleRepository;
import com.pingconsole.auth.repository.UserRepository;
import com.pingconsole.group.domain.PingGroup;
import com.pingconsole.group.repository.GroupRepository;
import com.pingconsole.users.dto.UserDTO;

@Service
public class UserDashboardServiceImpl implements UserDashboardService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private GroupRepository groupRepository;

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

	@Override
	public void saveUserDtoInUser(UserDTO userDTO) {
		User user = userRepository.findById(userDTO.getId());
		user.setUsername(userDTO.getUserId());
		user.setFullName(userDTO.getUserName());
		user.setEmail(userDTO.getEmail());
		user.setDob(userDTO.getDob());
		Set<Role> roles = new HashSet<>();
		for (Long id : userDTO.getRoles()) {
			roles.add(roleRepository.findById(id));
		}
		user.setRoles(roles);
		Set<PingGroup> groups = new HashSet<>();
		for (Long id : userDTO.getGroups()) {
			groups.add(groupRepository.findById(id));
		}
		user.setGroups(groups);
		userRepository.save(user);
	}

	@Override
	public User getUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
