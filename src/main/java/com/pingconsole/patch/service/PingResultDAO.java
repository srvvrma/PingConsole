package com.pingconsole.patch.service;

import java.util.List;

import com.pingconsole.patch.dto.PingResult;
import com.pingconsole.patch.dto.PingResultDTO;

public interface PingResultDAO {
    
    public PingResultDTO getById(Long id);
    public List<PingResultDTO> searchResults(String col,String search);
    public List<PingResultDTO> getAllResults();
    public int saveResult(PingResultDTO pingResultDTO);
    public void updateResult(PingResultDTO pingResultDTO);
    public void deleteResult(Long id);
	void deleteOldResult();
	List<PingResult> getAllStatus();
	public PingResult getAllStatusById(Long id);

}
