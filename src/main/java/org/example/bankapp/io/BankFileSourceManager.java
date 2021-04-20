package org.example.bankapp.io;

import org.example.bankapp.exception.BankDataSourceException;
import org.example.bankapp.models.Bank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BankFileSourceManager implements BankDataSourceManager {

    public List<Bank> fetchBanks(String fileName) throws BankDataSourceException {
        List<Bank> banks = new ArrayList<>();

        String strLine;
        File f = new File(fileName);

        // Read Input File Line By Line
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            while ((strLine = br.readLine()) != null) {
                String[] arr = strLine.split(",");

                Bank bank = new Bank.Builder(
                        Long.parseLong(arr[0]),
                        arr[1],
                        arr[2]
                ).withAddress(
                        arr[3],
                        arr[4],
                        Integer.parseInt(arr[5])
                ).build();
                banks.add(bank);

            }
        } catch (IOException e) {
            throw new BankDataSourceException(e);
        }
        return banks;
    }

    @Override
    public List<Bank> fetchBanks() throws BankDataSourceException {
        return fetchBanks("banks.csv");
    }
}
