package com.pingconsole.api.environment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pingconsole.environment.domain.EnvironmentDTO;
import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.patch.dto.PingResult;
import com.pingconsole.patch.service.PingResultDAOService;

@RestController
@RequestMapping("/api/environment")
public class EnvironmentRestController {

	
	@Autowired
	private EnvironmentService environmentService;
	
	@Autowired
    private PingResultDAOService pingResultDAOService;
	
	@RequestMapping("/getAll")
	public List<EnvironmentDTO> getAllEnvironment(){
		List<EnvironmentDTO> environementDTOs = environmentService.getAllEnvironment();
		return environementDTOs;
	}
	
	@RequestMapping("/getStatus/{id}")
	public PingResult getEnvironmentStatus(@PathVariable("id") long id){
		PingResult pingResult = pingResultDAOService.getAllStatusById(id);
		return pingResult;
	}

}
