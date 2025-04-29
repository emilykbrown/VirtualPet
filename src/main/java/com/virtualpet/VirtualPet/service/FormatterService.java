package com.virtualpet.VirtualPet.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class FormatterService {
    private final DecimalFormat currencyFormatter;

    public FormatterService(DecimalFormat currencyFormatter) {
        this.currencyFormatter = currencyFormatter;
    }

    public String format(double amount) {
        return currencyFormatter.format(amount);
    }
}
