package dev.victoria.controller;

import dev.victoria.service.TaxService;

public class TaxController {
    public static void run(int income, int expense) {
        int firstProgramTax = TaxService.firstProgramCalculation(income);
        int secondProgramTax = TaxService.secondProgramCalculation(income, expense);
        int taxDifference = Math.abs(firstProgramTax - secondProgramTax);

        if (firstProgramTax < secondProgramTax) {
            System.out.println("Мы советуем Вам УСН доходы!");
            System.out.println("Ваш налог составит: " + firstProgramTax + " рублей");
            System.out.println("Налог по другой системе: " + secondProgramTax + " рублей");
            System.out.println("Экономия: " + taxDifference + " рублей");
        } else if(firstProgramTax > secondProgramTax) {
            System.out.println("Мы советуем Вам УСН доходы минус расходы!");
            System.out.println("Ваш налог составит: " + secondProgramTax + " рублей");
            System.out.println("Налог по другой системе: " + firstProgramTax + " рублей");
            System.out.println("Экономия: " + taxDifference + " рублей");
        } else {
            System.out.println("Можете выбрать любую систему налогообложения");
            System.out.println("Налог по любой из них составит: " + firstProgramTax);
        }
    }
}
