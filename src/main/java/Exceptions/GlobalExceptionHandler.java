package Exceptions;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {

	@ExceptionHandler(value = InvalidEmailException.class)
	public ResponseEntity<ErrorResponse> handleInvalidEmailException(InvalidEmailException ex) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(), "");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
