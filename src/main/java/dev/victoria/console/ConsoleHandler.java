package dev.victoria.console;

import dev.victoria.controller.TaxController;
import dev.victoria.repository.Budget;

import java.util.Scanner;

public class ConsoleHandler {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Budget budget = new Budget(0, 0);

        ConsoleMenu.start();

        while (true) {
            ConsoleMenu.display();

            String line = scanner.nextLine();

            if (line.equals("end")) {
                ConsoleMenu.end();

                break;
            }

            int operation = Integer.parseInt(line);

            switch (operation) {
                case 1: {
                    System.out.println("Введите сумму дохода:");

                    String moneyString = scanner.nextLine();
                    int money = Integer.parseInt(moneyString);

                    budget.setIncome(budget.getIncome() + money);

                    break;
                }
                case 2: {
                    System.out.println("Введите сумму расхода:");

                    String moneyString = scanner.nextLine();
                    int money = Integer.parseInt(moneyString);

                    budget.setExpense(budget.getExpense() + money);

                    break;
                }
                case 3: {
                    int income = budget.getIncome();
                    int expense = budget.getExpense();

                    if (income != 0 && income - expense > 0) {
                        TaxController.run(income, expense);
                    } else {
                        System.out.println("Невозможно выбрать систему налогообложения.");
                        System.out.println("Недостаточный уровень дохода или расходы превышают доход.");
                    }
                    break;
                }
                default: {
                    System.out.println("Некорректная операция. Выберите другую опцию.");
                }
            }
        }
    }
}
