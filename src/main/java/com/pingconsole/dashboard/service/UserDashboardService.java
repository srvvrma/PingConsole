package com.pingconsole.dashboard.service;

import java.util.List;

import com.pingconsole.auth.model.User;
import com.pingconsole.users.dto.UserDTO;

public interface UserDashboardService {
	
	public List<UserDTO> getAllUserList();
	
	public List<UserDTO> parseUserList(List<User> users);

	public UserDTO getUserDTOByUserId(Long id);

	public void saveUserDtoInUser(UserDTO userDTO);

	public User getUserByUserName(String username);

}
