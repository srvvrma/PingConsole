package com.pingconsole.patch.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pingconsole.patch.dto.PingFile;

@Service
@Transactional
public class PingFileServiceImpl implements PingFileService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int savePingFile(PingFile pingFile) {
		if (pingFile.getId() == 0) {
			return (Integer) sessionFactory.getCurrentSession().save(
			    pingFile);
		} else {
			sessionFactory.getCurrentSession().merge(pingFile);
			return 0;
		}
	}

	@Override
	public int updatePingFile(PingFile pingFile) {
		// TODO Auto-generated method stub
		return 0;
	}

}
