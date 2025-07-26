package com.project.digitalWalletMicroservice.service;

import java.math.BigDecimal;
import java.util.List;

import com.project.digitalWalletMicroservice.model.Wallet;

public interface WalletService {
	public Wallet createWallet(Wallet wallet);
	public List<Wallet> getWalletDetails();
	public Wallet getWalletDetailsById(Long walletId);
	public Wallet addFunds(Long walletId, BigDecimal amount);
	public Wallet deductFunds(Long walletId,BigDecimal initialBalance);


}
