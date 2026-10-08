package dev.victoria.service;

public class TaxService {
    public static int FIRST_PROGRAM_TAX_RATE = 6;
    public static int SECOND_PROGRAM_TAX_RATE = 15;

    public static int firstProgramCalculation(int income) {
        return income * FIRST_PROGRAM_TAX_RATE / 100;
    }

    public static int secondProgramCalculation(int income, int expense) {
        return (income - expense) * SECOND_PROGRAM_TAX_RATE / 100;
    }
}
