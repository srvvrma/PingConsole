package com.pingconsole.patch.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pingconsole.patch.dto.PingResult;
import com.pingconsole.patch.dto.PingResultDTO;
import com.pingconsole.patch.repository.PingResultRepository;


@Repository
@Transactional
public class PingResultDAOService implements PingResultDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired PingResultRepository pingResultRepository;
    
    @Override
    public PingResultDTO getById(Long id) {
        return pingResultRepository.findById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PingResultDTO> searchResults(String col, String search) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PingResultDTO.class);
        criteria.add(Restrictions.ilike(col, "%" +search +"%"));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PingResultDTO> getAllResults() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PingResultDTO.class);
        return criteria.list();
    }

    @Override
    public int saveResult(PingResultDTO pingResultDTO) {
        pingResultRepository.save(pingResultDTO);
    	sessionFactory.getCurrentSession().save(new PingResult(pingResultDTO.getKeyid(),pingResultDTO.getResult(),pingResultDTO.getTimestamp(),pingResultDTO.getEnvType()));
        return 1;
    }

    @Override
    public void updateResult(PingResultDTO pingResultDTO) {
        sessionFactory.getCurrentSession().merge(pingResultDTO);
        
    }

    @Override
    public void deleteResult(Long id) {
        pingResultRepository.delete(id);
    }
    
    @Override
    public void deleteOldResult() {
    	sessionFactory.getCurrentSession().createQuery("delete from PingResult").executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<PingResult> getAllStatus() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PingResult.class);
        return criteria.list();
    }

	@Override
	public PingResult getAllStatusById(Long id) {
		return (PingResult) sessionFactory.getCurrentSession().get(PingResult.class, id);
	}
    

}
