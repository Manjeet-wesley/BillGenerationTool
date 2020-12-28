package com.sboot.custom.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BillGenerationControllerAdvice extends ResponseEntityExceptionHandler {
	String BAD_REQUEST_MSG="Related Bill id information is not found..";
	
	@ExceptionHandler(BillIdNotFoundException.class)
	public final ResponseEntity<ErrorResponse> billIdDetailsNotFoundException(BillIdNotFoundException billNotFoundEx, WebRequest request){
		List<String> errors=new ArrayList();
		errors.add(billNotFoundEx.getLocalizedMessage());
		
		ErrorResponse response=new ErrorResponse();
		response.setMsg(BAD_REQUEST_MSG);
		response.setErrors(errors);
		
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.BAD_REQUEST);
		
		
		
		
	}

}
