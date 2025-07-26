package com.project.digitalWalletMicroservice.globalException;

public class InsufficientBalanceException extends RuntimeException {
	
	private static final long serialVersionUID = 4122881105629460976L;
   public InsufficientBalanceException(String message) {
		super(message);
	}

}
