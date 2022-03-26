package com.fiap.hmv.utils;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import com.fiap.hmv.CustomizadoValidacaoCampoException;

public class ValidacaoUtil {

	 public static <T> void validar(T obj) {

	        Collection<ConstraintViolation<Object>> violations = Validation.buildDefaultValidatorFactory()
	                .getValidator().validate(obj);

	        if (!violations.isEmpty()) {
	            throw new CustomizadoValidacaoCampoException(violations.stream().map(ConstraintViolation::getMessage)
	                    .collect(Collectors.toList()));
	        }
	    }
}
