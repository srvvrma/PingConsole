package com.pingconsole.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingconsole.group.domain.PingGroup;
import com.pingconsole.group.repository.GroupRepository;

@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	private GroupRepository groupRepository;

	@Override
	public List<PingGroup> getAllGroup() {
		return groupRepository.findAll();
	}

}
