package bankconsoleapp;

import java.util.Scanner;

public class LoanProcess {
    Scanner scanner = new Scanner(System.in);

    public void loanMethod(Customer customer, int transactionCount, BankPojo bankPojo) {
        System.out.println("Is your account savings or current");
        System.out.println("1.Savings Account");
        System.out.println("2.Current Account");
        int userChoice = scanner.nextInt();
        boolean loop = true;
        try {
            while (loop) {
                switch (userChoice) {
                    case 1:
                        System.out.println("We are not providing loans for savings account");
                        return;
                    case 2:
                        loanProcess(customer,transactionCount,bankPojo);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("You have entered the wrong option");
        }
    }

    void loanProcess(Customer customer, int transactionCount, BankPojo bankPojo) {
        System.out.println("Below criteria should satisfy ");
        System.out.println("1.your annual income should above 1LPA");
        System.out.println("2.Your transaction Count should be greater than 3");
        System.out.println("3.Your bank balance should be higher than 20000");
        int annualIncome = scanner.nextInt();
        try {
            if (annualIncome < 100000) {
                System.out.println("You are not eligible for loan process by annual income ");
            } else {
                if (transactionCount < 3) {
                    System.out.println("You are not eligible for Loan Process by transaction count");
                } else {
                    if (customer.getMoney() < 20000) {
                        System.out.println("You are not eligible for Loan Process");
                    } else {
                        System.out.println("Currently we are providing Loan only for Rupees 1 Lakh");
                        System.out.println("Enter your money");
                        int loanAmount = scanner.nextInt();
                        if(bankPojo.getMoney()<loanAmount){
                            System.out.println("Bank does not have sufficient balance to provide you money");
                            return;
                        }
                        if (loanAmount > 100000) {
                            System.out.println("We are unable to provide this much amount");
                            loanAmount = scanner.nextInt();
                        } else {
                            System.out.println("yes you are available for loan process");
                            System.out.println("There are two ways to repay the loan");
                            System.out.println("10 months and 12 months");
                            System.out.println("Enter the months");
                            int totalMonths = scanner.nextInt();
                            loanDisplay(loanAmount, totalMonths, customer,bankPojo);
                        }
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("You have entered wrong input");
        }
    }
    void loanDisplay(int loanAmount, int totalMonths, Customer customer, BankPojo bankPojo) {
        int k = loanAmount;
        double rateOfInterest;
        int finalLoanAmount = 0;
        int present;
        int payment;
        if (totalMonths == 10) {
            for (int i = 0; i < 10; i++) {
                present = k * 10 / 100;
                payment = k - present;
                k = payment;
            }
             finalLoanAmount = loanAmount+k;
            System.out.println("You should pay loan Amount of " + finalLoanAmount);
            rateOfInterest = finalLoanAmount / 10;
            customer.setRateOfInterest(customer.getRateOfInterest()+rateOfInterest);
            System.out.println("\n----------------------------------------");
        }
        else if(totalMonths==12){
            for(int i = 0; i < 12; i++){
                present = k * 10 / 100;
                payment = k - present;
                k = payment;
            }
            finalLoanAmount = loanAmount+k;
            System.out.println("You should pay loan Amount of " + finalLoanAmount);
            rateOfInterest = finalLoanAmount / 12;
            customer.setRateOfInterest(customer.getRateOfInterest()+rateOfInterest);
        }
        boolean loop = true;
        try {
            while (loop) {
                System.out.println("1.Take Loan");
                System.out.println("2.Exit");
        int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 1:
                        getLoan(customer,finalLoanAmount,bankPojo);
                        break;
                    case 2:
                        loop = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("You have entered the wrong option");
        }
    }
    void getLoan(Customer customer, int finalLoanAmount, BankPojo bankPojo){
        bankPojo.setMoney(bankPojo.getMoney()-finalLoanAmount);
        customer.setMoney(customer.getMoney()+finalLoanAmount);
        System.out.println("Your account has been credited with the loan amount " + customer.getMoney());
        customer.setLoanAmount(customer.getLoanAmount()+finalLoanAmount);
        System.out.println("\n----------------------------------------");
        System.out.printf("|%-15s|  %-35s|\n", "Name", customer.getUsername());
        System.out.printf("|%-15s|  %-35s|\n", "Phone Number", customer.getPhone());
        System.out.printf("|%-15s|  %-35s|\n", "AccountNumber",customer.getAccountNumber());
        System.out.printf("|%-15s|  %-35s|\n",  "Loan Amount", customer.getLoanAmount());
        System.out.printf("|%-15s|  %-35s|\n",  "Balance", customer.getMoney());
        System.out.printf("|%-15s|  %-35s|\n",  "Rate Of Interest", customer.getRateOfInterest());
        System.out.println("\n----------------------------------------");

    }
    void payLoan(Customer customer, BankPojo bankPojo){
        System.out.println("Enter the Loan Amount you want to deposit");
        double loanAmount = scanner.nextDouble();
        if(loanAmount> customer.getMoney()||loanAmount<0){
            System.out.println("Insufficient Balance");
        }
        else{
            customer.setMoney(customer.getMoney()-loanAmount);
            customer.setLoanAmount(customer.getLoanAmount()-loanAmount);
            System.out.println("Loan Repaid Successfully");
            bankPojo.setMoney(bankPojo.getMoney()+loanAmount);
        }
        System.out.println("\n----------------------------------------");
        System.out.printf("|%-15s|  %-35s|\n", "Name", customer.getUsername());
        System.out.printf("|%-15s|  %-35s|\n", "Phone Number", customer.getPhone());
        System.out.printf("|%-15s|  %-35s|\n", "AccountNumber",customer.getAccountNumber());
        System.out.printf("|%-15s|  %-35s|\n",  "Loan Amount", customer.getLoanAmount());
        System.out.printf("|%-15s|  %-35s|\n",  "Balance", customer.getMoney());
        System.out.printf("|%-15s|  %-35s|\n",  "Rate Of Interest", customer.getRateOfInterest());
        System.out.println("\n----------------------------------------");

    }
}

