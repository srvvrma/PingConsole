package com.pingconsole.patch.service;

import com.pingconsole.patch.dto.PingDirectory;

public interface PingDirectoryService {

	public int savePingDirectory(PingDirectory pingDirectory);
	public int updateNeoDirectory(PingDirectory pingDirectory);
	public void cleanAllData();
	public void cleanAllFile();
}
