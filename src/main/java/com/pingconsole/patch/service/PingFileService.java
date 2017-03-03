package com.pingconsole.patch.service;

import com.pingconsole.patch.dto.PingFile;

public interface PingFileService {
	
	public int savePingFile(PingFile pingFile);
	public int updatePingFile(PingFile pingFile);

}
