package cn.com.common.validate.annotation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.com.common.validate.annotation.StringValidate;

public class StringValidator implements ConstraintValidator<StringValidate, String>{

	@Override
	public void initialize(StringValidate constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
