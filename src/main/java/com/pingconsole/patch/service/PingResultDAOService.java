package com.pingconsole.patch.service;

import com.pingconsole.patch.dto.PingResult;
import com.pingconsole.patch.dto.PingResultDTO;
import com.pingconsole.patch.repository.PingResultDTORepository;
import com.pingconsole.patch.repository.PingResultRepository;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class PingResultDAOService implements PingResultDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired 
    private PingResultDTORepository pingResultDTORepository;
    
    @Autowired
    private PingResultRepository pingResultRepository;
    
    @Override
    public PingResultDTO getById(Long id) {
        return pingResultDTORepository.getOne(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PingResultDTO> searchResults(String col, String search) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PingResultDTO.class);
        criteria.add(Restrictions.ilike(col, "%" +search +"%"));
        return criteria.list();
    }

    @Override
    public List<PingResultDTO> getAllResults() {
        return pingResultDTORepository.findAll();
    }

    @Override
    public int saveResult(PingResultDTO pingResultDTO) {
      pingResultDTORepository.save(pingResultDTO);
      pingResultRepository.save(new PingResult(pingResultDTO.getKeyid(),pingResultDTO.getResult(),pingResultDTO.getTimestamp(),pingResultDTO.getEnvType()));
      return 1;
    }

    @Override
    public void updateResult(PingResultDTO pingResultDTO) {
      pingResultDTORepository.save(pingResultDTO);
    }

    @Override
    public void deleteResult(Long id) {
        pingResultDTORepository.deleteById(id);
    }
    
    @Override
    public void deleteOldResult() {
      pingResultDTORepository.deleteAll();
    }
    
    @Override
    public List<PingResult> getAllStatus() {
        return pingResultRepository.findAll();
    }

	@Override
	public PingResult getAllStatusById(Long id) {
		return pingResultRepository.findByKeyId(id);
	}
    

}
