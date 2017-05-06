package com.pingconsole.environmentUser.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pingconsole.environmentUser.domain.EnvironmentUserDTO;

@Component
public class EnvironmentUserValidator implements Validator {

	  @Override
	  public boolean supports(Class<?> aclazz) {
	    return EnvironmentUserDTO.class.equals(aclazz);
	  }

	  @Override
	  public void validate(Object target, Errors errors) {
	    // TODO Auto-generated method stub
	    
	  }

	}
