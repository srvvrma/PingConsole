package com.pingconsole.patch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pingconsole.patch.dto.PingDirectory;
import com.pingconsole.patch.repository.PingDirectoryRepository;
import com.pingconsole.patch.repository.PingFileRepository;

@Service
@Transactional
public class PingDirectoryServiceImpl implements PingDirectoryService {

	@Autowired
	private PingDirectoryRepository pingDirectoryRepository;

	@Autowired
	private PingFileRepository pingFileRepository;

	@Override
	public int savePingDirectory(PingDirectory pingDirectory) {
		if (pingDirectory.getId() == 0) {
			pingDirectoryRepository.save(pingDirectory);
			return 1;
		} else {
			pingDirectoryRepository.save(pingDirectory);
			return 0;
		}
	}

	@Override
	public int updateNeoDirectory(PingDirectory pingDirectory) {
		pingDirectoryRepository.save(pingDirectory);
		return 0;
	}

	@Override
	public void cleanAllData() {
		pingDirectoryRepository.deleteAllInBatch();
		;
	}

	@Override
	public void cleanAllFile() {
		pingFileRepository.deleteAllInBatch();

	}

}
