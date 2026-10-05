package dev.victoria;

import java.util.Scanner;

public class Main {
    public static int FIRST_PROGRAM_TAX_RATE = 6;
    public static int SECOND_PROGRAM_TAX_RATE = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int income = 0;
        int expense = 0;

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Вас приветствует программа-помощник индивидуальному предпринимателю!");
        System.out.print("Пожалуйста, следуйте инструкции. ");
        System.out.println("Для завершения программы введите end.");
        System.out.println("---------------------------------------------------------------------");

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String line = scanner.nextLine();

            if (line.equals("end")) {
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Программа завершена!");
                System.out.println("---------------------------------------------------------------------");

                break;
            }

            int operation = Integer.parseInt(line);

            switch (operation) {
                case 1: {
                    System.out.println("Введите сумму дохода:");

                    String moneyString = scanner.nextLine();
                    int money = Integer.parseInt(moneyString);

                    income = income + money;

                    break;
                }
                case 2: {
                    System.out.println("Введите сумму расхода:");

                    String moneyString = scanner.nextLine();
                    int money = Integer.parseInt(moneyString);

                    expense = expense + money;

                    break;
                }
                case 3: {
                    if (income != 0 && income - expense > 0) {
                        recommendTaxProgram(income, expense);
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

        scanner.close();
    }

    public static int firstProgramCalculation(int income) {
        return income * FIRST_PROGRAM_TAX_RATE / 100;
    }

    public static int secondProgramCalculation(int income, int expense) {
        return (income - expense) * SECOND_PROGRAM_TAX_RATE / 100;
    }

    public static void recommendTaxProgram(int income, int expense) {
        int firstProgramTax = firstProgramCalculation(income);
        int secondProgramTax = secondProgramCalculation(income, expense);
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