package com.pingconsole.environment.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pingconsole.environment.domain.EnvironmentDTO;

@Component
public class EnvironmentValidator implements Validator {

  @Override
  public boolean supports(Class<?> aclazz) {
    return EnvironmentDTO.class.equals(aclazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    // TODO Auto-generated method stub
    
  }

}
