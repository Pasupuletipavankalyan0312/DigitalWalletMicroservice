package com.project.digitalWalletMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.digitalWalletMicroservice.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

}
