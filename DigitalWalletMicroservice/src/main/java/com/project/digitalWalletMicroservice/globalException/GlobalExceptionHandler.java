package com.project.digitalWalletMicroservice.globalException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
@ExceptionHandler(RuntimeException.class)
public ResponseEntity<String>handleRuntimeExceptions(RuntimeException ex){
	return ResponseEntity.badRequest().body("Error:"+ex.getMessage());
}


@ExceptionHandler(Exception.class)
		public ResponseEntity<String>handleCheckedExceptions(Exception ex){
	return ResponseEntity.internalServerError().body("Something went Wrong");
}

}
