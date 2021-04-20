package org.example.bankapp.io;

import org.example.bankapp.exception.BankDataSourceException;
import org.example.bankapp.models.Bank;

import java.util.List;


public interface BankDataSourceManager {

    List<Bank> fetchBanks() throws BankDataSourceException;
}
