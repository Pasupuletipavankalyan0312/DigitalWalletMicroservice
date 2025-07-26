package com.project.digitalWalletMicroservice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalWalletMicroservice.model.Wallet;
import com.project.digitalWalletMicroservice.service.WalletService;

@RestController
@RequestMapping("/api/digitialWalletMicroservice")
public class WalletController {
	
@Autowired
WalletService walletService;

@PostMapping("/saveWallets")
public Wallet createWallet(@RequestBody Wallet wallet) {
	return walletService.createWallet(wallet);
	
}
@GetMapping("/getWalletDetails")
public List<Wallet> getWalletDetails(Wallet wallet){
	return walletService.getWalletDetails();
}

@GetMapping("/getWalletDetailsById/{walletId}")
public Wallet getWalletDetailsById(@PathVariable long walletId) {
	return walletService.getWalletDetailsById(walletId);
}

@PostMapping("/addFunds/{walletId}/{amount}")
public Wallet addFunds(@PathVariable Long walletId, @PathVariable BigDecimal amount) {
	return walletService.addFunds(walletId, amount);
}

@PostMapping("/deductFunds")
public Wallet deductFunds(@RequestParam long walletId,@RequestParam BigDecimal amount) {
	return walletService.deductFunds(walletId, amount);
}


}
