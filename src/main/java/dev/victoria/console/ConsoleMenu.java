package dev.victoria.console;

public class ConsoleMenu {
    public static void start() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Вас приветствует программа-помощник индивидуальному предпринимателю!");
        System.out.print("Пожалуйста, следуйте инструкции. ");
        System.out.println("Для завершения программы введите end.");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void display() {
        System.out.println("Выберите операцию и введите её номер:");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать систему налогообложения");
    }

    public static void end() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Программа завершена!");
        System.out.println("---------------------------------------------------------------------");

    }
}
