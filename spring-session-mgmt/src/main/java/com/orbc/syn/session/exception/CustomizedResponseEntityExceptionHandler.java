package com.orbc.syn.session.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.orbc.syn.session.response.vo.LoginResponse;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserValidationException.class)
	public final ResponseEntity<LoginResponse> handleUserNotFoundException(UserValidationException ex, WebRequest request) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setDesc(ex.getMessage());
		return new ResponseEntity<>(loginResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AuthenticationFailedException.class)
	public final ResponseEntity<LoginResponse> handleUserNotFoundException(AuthenticationFailedException ex,
			WebRequest request) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setDesc(ex.getMessage());
		return new ResponseEntity<>(loginResponse, HttpStatus.UNAUTHORIZED);
	}

}
