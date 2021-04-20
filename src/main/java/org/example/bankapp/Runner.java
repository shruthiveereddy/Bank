package org.example.bankapp;

import org.example.bankapp.exception.BankDataSourceException;
import org.example.bankapp.io.BankDataSourceManager;
import org.example.bankapp.io.BankFileSourceManager;
import org.example.bankapp.models.Bank;
import org.example.bankapp.service.SearchService;

import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws BankDataSourceException {
        System.out.println("##############################");
        System.out.println("READING DATA FROM FILE.......");
        BankDataSourceManager sourceManager = new BankFileSourceManager();
        List<Bank> banks = sourceManager.fetchBanks();
        System.out.println("DATA READ COMPLETE....");

        Scanner scanner = new Scanner(System.in);
        SearchService service = new SearchService();
        String inp;
        do {
            System.out.println("##############################");
            System.out.println("SEARCH OPTIONS");
            System.out.println("1. By Zip/City/State/Type/Name");
            System.out.println("2. By City and State");
            System.out.println("q. Quit...");

            inp = scanner.nextLine();
            if ("1".equals(inp)) {
                System.out.println("Choose suboption Zip/City/State/Type/Name");
                String opt = scanner.nextLine();
                System.out.println("Enter search input");
                String srchInp = scanner.nextLine();
                display(service.search1(banks, opt.toLowerCase(), "" + srchInp));
            } else if ("2".equals(inp)) {
                System.out.println("Enter City");
                String city = scanner.nextLine();
                System.out.println("Enter state");
                String state = scanner.nextLine();
                display(service.search2(banks, "" + city, "" + state));
            }
        } while (!"q".equals(inp));

    }

    static void display(List<Bank> banks) {
        System.out.println("=========OUTPUT=========");
        banks.forEach(System.out::println);
    }
}
