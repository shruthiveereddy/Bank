package org.example.bankapp.service;

import org.example.bankapp.models.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    public List<Bank> search1(List<Bank> inputBanks, String criteria, String srchInp) {
        List<Bank> output = null;

        switch (criteria) {
            case "zip":
                output = inputBanks.stream()
                        .filter(b -> srchInp.equals("" + b.getZip()))
                        .collect(Collectors.toList());
                break;
            case "state":
                output = inputBanks.stream()
                        .filter(b -> srchInp.equals(b.getState()))
                        .collect(Collectors.toList());
                break;
            case "city":
                output = inputBanks.stream()
                        .filter(b -> srchInp.equals(b.getCity()))
                        .collect(Collectors.toList());
                break;
            case "type":
                output = inputBanks.stream()
                        .filter(b -> srchInp.equals(b.getType()))
                        .collect(Collectors.toList());
                break;
            case "name":
                output = inputBanks.stream()
                        .filter(b -> srchInp.equals(b.getName()))
                        .collect(Collectors.toList());
                break;
            default:
                output = new ArrayList<>();
        }

        return output;
    }

    public List<Bank> search2(List<Bank> inputBanks, String city, String state) {
        return inputBanks.stream()
                .filter(b -> city.equals(b.getCity()) && state.equals(b.getState()))
                .collect(Collectors.toList());
    }

}
