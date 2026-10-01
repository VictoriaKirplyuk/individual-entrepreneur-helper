package dev.victoria.repository;

public class Budget {
    private int income;
    private int expense;

    public Budget(int income, int expense) {
        this.income = income;
        this.expense = expense;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }
}
