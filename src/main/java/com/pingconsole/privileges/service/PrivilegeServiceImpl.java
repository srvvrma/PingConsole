package com.pingconsole.privileges.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingconsole.auth.model.Privilege;
import com.pingconsole.auth.repository.PrivilageRepository;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilageRepository privilageRepository;

	@Override
	public List<Privilege> getAllPrivilegeList() {
		List<Privilege> privileges = privilageRepository.findAll();
		return privileges;
	}

}
