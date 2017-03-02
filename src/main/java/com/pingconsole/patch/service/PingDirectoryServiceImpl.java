package com.pingconsole.patch.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pingconsole.patch.dto.PingDirectory;


@Service
@Transactional
public class PingDirectoryServiceImpl implements PingDirectoryService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int savePingDirectory(PingDirectory pingDirectory) {
		if (pingDirectory.getId() == 0) {
			return (Integer) sessionFactory.getCurrentSession().save(
			    pingDirectory);
		} else {
			sessionFactory.getCurrentSession().merge(pingDirectory);
			return 0;
		}
	}

	@Override
	public int updateNeoDirectory(PingDirectory pingDirectory) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void cleanAllData() {
		sessionFactory.getCurrentSession().createSQLQuery("truncate table NEO_FILE").executeUpdate();
		sessionFactory.getCurrentSession().createSQLQuery("truncate table NEO_DIRECTORY").executeUpdate();
	}

}
