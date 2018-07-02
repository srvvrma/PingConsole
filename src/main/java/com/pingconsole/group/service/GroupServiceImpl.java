package com.pingconsole.group.service;

import com.pingconsole.group.domain.PingGroup;
import com.pingconsole.group.domain.PingGroupVO;
import com.pingconsole.group.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	private GroupRepository groupRepository;

	@Override
	public List<PingGroup> getAllGroup() {
		return groupRepository.findAll();
	}

  @Override
  public int isGroupExist(PingGroupVO pingGroupVO) {
    return 0;
  }

  @Override
  public void crateNewGroup(PingGroupVO pingGroupVO) {
    PingGroup pingGroup = new PingGroup();
    pingGroup.setCode(pingGroupVO.getCode());
    pingGroup.setName(pingGroupVO.getName());
    groupRepository.save(pingGroup);
    
  }
  
  @Override
  public void editGroup(PingGroupVO pingGroupVO) {
      PingGroup pingGroup = groupRepository.getOne(pingGroupVO.getId());
    pingGroup.setCode(pingGroupVO.getCode());
    pingGroup.setName(pingGroupVO.getName());
    groupRepository.save(pingGroup);
    
  }

  @Override
  public void removeGroup(Long id) {
      groupRepository.deleteById(id);
  }

@Override
public PingGroup getOne(Long id) {
    return groupRepository.getOne(id);
}

}
