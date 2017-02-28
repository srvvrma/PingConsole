package com.pingconsole.group.service;

import java.util.List;

import com.pingconsole.group.domain.PingGroup;
import com.pingconsole.group.domain.PingGroupVO;

public interface GroupService {
	
	public List<PingGroup> getAllGroup();

  public int isGroupExist(PingGroupVO pingGroupVO);

  public void crateNewGroup(PingGroupVO pingGroupVO);

  public void editGroup(PingGroupVO pingGroupVO);

  public void removeGroup(Long id);
  
  public PingGroup findById(Long id);

}
