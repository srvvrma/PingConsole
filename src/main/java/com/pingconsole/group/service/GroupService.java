package com.pingconsole.group.service;

import com.pingconsole.group.domain.PingGroup;
import com.pingconsole.group.domain.PingGroupVO;

import java.util.List;

public interface GroupService {
	
	public List<PingGroup> getAllGroup();

  public int isGroupExist(PingGroupVO pingGroupVO);

  public void crateNewGroup(PingGroupVO pingGroupVO);

  public void editGroup(PingGroupVO pingGroupVO);

  public void removeGroup(Long id);

    public PingGroup getOne(Long id);

}
