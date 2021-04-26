package org.notabarista.exception.handler;

import org.notabarista.entity.response.Response;
import org.notabarista.entity.response.ResponseStatus;
import org.notabarista.exception.InsufficientRightsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class GenericExceptionHandler {

	@ExceptionHandler(value = { InsufficientRightsException.class })
	public ResponseEntity<Response<String>> handleInvalidArgumentRequest(MethodArgumentNotValidException e,
			WebRequest request) {

		log.warn(
				"Insufficient rights for uid: " + request.getHeader("uid") + ", resource: " + request.getContextPath());

		return new ResponseEntity<>(new Response<String>(ResponseStatus.SUCCESS, 0, null, 0, 0, 0, 0,
				new InsufficientRightsException().getMessage() + " uid: " + request.getHeader("uid")
						+ " accessed path: " + request.getContextPath()),
				HttpStatus.FORBIDDEN);
	}
}
