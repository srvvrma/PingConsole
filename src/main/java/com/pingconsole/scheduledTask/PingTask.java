package com.pingconsole.scheduledTask;


import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pingconsole.environment.domain.EnvironmentDTO;
import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.patch.dto.PingResultDTO;
import com.pingconsole.patch.service.PingResultDAO;
import com.pingconsole.patch.util.PingUtil;


@Component
public class PingTask {
    
    @Autowired
    private EnvironmentService environmentService;
    
    @Autowired
    private PingResultDAO pingResultDao;
    
    @Scheduled(fixedDelay = 60000)
    public void checkUrlStaus()
    {
        java.util.Date date= new java.util.Date();
        Timestamp time = new Timestamp(date.getTime());
        pingResultDao.deleteOldResult();
        for(EnvironmentDTO environmentDTO : environmentService.getAllEnvironment()){
            PingResultDTO resultDTO = new PingResultDTO(environmentDTO.getId(),time);
            resultDTO.setEnvType(environmentDTO.getEnvironmentType());
            if(environmentDTO.getEnvironmentType().equalsIgnoreCase(EnvironmentDTO.INT)){
            	resultDTO.setResult(PingUtil.isWebserviceAvailable(environmentDTO.getPingUrl()+".wsdl?"+String.valueOf(Math.random() * ( 1000000 - 50000 ))));
            }else{
            	resultDTO.setResult(PingUtil.checkUrl(environmentDTO.getPingUrl()+"?"+String.valueOf(Math.random() * ( 1000000 - 50000 ))));
            }
            pingResultDao.saveResult(resultDTO);
        }
        
    }
}
