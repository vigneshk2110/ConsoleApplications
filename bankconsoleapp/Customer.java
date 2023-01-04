package bankconsoleapp;

import java.util.Stack;

public class Customer {
    private String username;
    String password;
    private String name;
    private String address;
    private String phone;
    private double money;
    private  long accountNumber;
    private double rateOfInterest;

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    private double loanAmount;
    public  Stack<String> transactions = new Stack<>();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public  Stack<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions.push(transactions);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getMoney() {
        return money;
    }


    public void setMoney(double money) {
        this.money = money;
    }

    Customer(String username, String password, String name, String phone, long accountNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.accountNumber = accountNumber;
    }

}

