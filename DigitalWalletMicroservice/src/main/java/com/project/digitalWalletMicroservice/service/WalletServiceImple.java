package com.project.digitalWalletMicroservice.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalWalletMicroservice.model.Wallet;
import com.project.digitalWalletMicroservice.repository.WalletRepository;
@Service
public class WalletServiceImple implements WalletService {
	
@Autowired
WalletRepository walletRepository;

public Wallet createWallet(Wallet wallet) {
	return walletRepository.save(wallet);
}

public List<Wallet> getWalletDetails(){
	return walletRepository.findAll();
}

public Wallet getWalletDetailsById(Long walletId) {
	Optional<Wallet> walletOptional = walletRepository.findById(walletId);
	if(walletOptional.isPresent()) {
		return walletOptional.get();
	}
	else {
		throw new RuntimeException("Wallet not found with that ID");
	}
}

public Wallet addFunds(Long walletId,BigDecimal amount) {
	Wallet wallet = getWalletDetailsById(walletId);
	 wallet.setInitialBalance(wallet.getInitialBalance().add(amount));
	return walletRepository.save(wallet);
}

public Wallet deductFunds(Long walletId,BigDecimal amount) {
	Wallet wallet = getWalletDetailsById(walletId);
	if(wallet.getInitialBalance().compareTo(amount)<0){
		throw new RuntimeException("Insufficient balance");
		
	}
	wallet.setInitialBalance(wallet.getInitialBalance().subtract(amount));
	return wallet;
}

}
