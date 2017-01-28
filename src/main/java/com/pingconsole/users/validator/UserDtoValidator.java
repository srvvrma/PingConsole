package com.pingconsole.users.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pingconsole.auth.model.User;
import com.pingconsole.auth.service.UserService;
import com.pingconsole.users.dto.UserDTO;

@Component
public class UserDtoValidator implements Validator {
    
	@Autowired
    private UserService userService;
	
	

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	UserDTO userDto = (UserDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
        if (userDto.getUserId().length() < 6 || userDto.getUserId().length() > 32) {
            errors.rejectValue("userName", "Size.userForm.username");
        }
        if (!userDto.getUserId().equalsIgnoreCase(userService.findById(userDto.getId()).getUsername()) && userService.findByUsername(userDto.getUserId()) != null) {
            errors.rejectValue("userName", "Duplicate.userForm.username");
        }
    }
}

