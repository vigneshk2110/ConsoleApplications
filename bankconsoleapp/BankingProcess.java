package bankconsoleapp;

import java.util.Scanner;

public class BankingProcess {
    public int transactionCount;
    Scanner scannerObject = new Scanner(System.in);

    public void displayMethod(Customer customer,BankPojo bankPojo) {
        System.out.println("\n----------------------------------------");
        System.out.printf("|%-15s|  %-20s|\n", "Name", customer.getUsername());
        System.out.printf("|%-15s|  %-20s|\n", "Phone Number", customer.getPhone());
        System.out.printf("|%-15s|  %-20s|\n", "AccountNumber",customer.getAccountNumber());
        System.out.printf("|%-15s|  %-20s|\n",   "Customer Loan Amount", customer.getLoanAmount());
        System.out.printf("|%-15s|  %-20s|\n",   "Customer Balance", customer.getMoney());
        System.out.printf("|%-15s|  %-20s|\n",   "Customer Rate Of Interest", customer.getRateOfInterest());
        System.out.println("\n----------------------------------------");
        boolean loop = true;
        while (loop) {
            System.out.println("1.To view the about Loan and to get the loan");
            System.out.println("2.To rePay the loan");
            System.out.println("3.Perform Deposit");
            System.out.println("4.Perform withdraw");
            System.out.println("5.Check Balance");
            System.out.println("6.Transaction History");
            System.out.println("7.perform transaction");
            System.out.println("8.Perform transaction from one accoubnt");
            System.out.println("91.Exit");
            int chooseToPerform =scannerObject.nextInt();
            switch (chooseToPerform) {
                case 1:
                    new LoanProcess().loanMethod(customer,transactionCount,bankPojo);
                    break;
                case 2:
                    new LoanProcess().payLoan(customer,bankPojo);
                case 3:
                    System.out.println("Enter the amount to deposit");
                    int amount = scannerObject.nextInt();
                    deposit(customer, amount);
                    break;
                case 4:
                    withdraw(customer);
                    break;
                case 5:
                    checkBalance(customer);
                    break;
                case 6:
                    transaction(customer);
                    break;
                case 7:
                     transactionFromAccountToOther(customer);
                    break;
                case 8:
                    transactionFromOneAccountFromAccountNumber(customer);
                    break;
                case 9:
                    loop = false;
                    return;
            }

        }
        System.out.println("TERMINATED!!!!");

    }

    private void deposit(Customer customer, int amount) {
        if (amount > 0) {
            customer.setMoney(customer.getMoney() + amount);
            System.out.println("the amount you have been deposited at your " + " is " + amount);
            System.out.println("YOUR BALANCE IS " + customer.getMoney());
            String transation = "Deposited amount is "+ String.valueOf(amount);
            transact(transation,customer);
            transactionCount++;
        } else {
            System.out.println("Please enter the valid amount from rupees 0");
        }

    }

    public void transact(String transation, Customer customer) {
        customer.setTransactions(transation);
    }

    private void withdraw(Customer customer) {
        System.out.println("YOUR BALANCE IS " +customer.getMoney());
        System.out.println("ENTER THE AMOUNT TO BE WITHDRAW");
        int amount = scannerObject.nextInt();
        if (amount > 0) {
            if (amount > customer.getMoney()) {
                System.out.println("INSUFFICIENT BALANCE");
            } else {
                customer.setMoney(customer.getMoney() - amount);
                System.out.println("SUCCESSFULLY WITHDRAW OF " + amount);
                String transation = "Withdrawed amount is "+ String.valueOf(amount);
                transact(transation,customer);
                transactionCount++;
            }
        } else {
            System.out.println("Please enter the valid amount from rupees 0");
        }
        System.out.println("YOUR BALANCE IS " + customer.getMoney());
    }

    private void checkBalance(Customer customer) {
        if (customer.getMoney() > 0) {
            System.out.println("YOUR BALANCE IS " + customer.getMoney());
        } else {
            System.out.println("You don't have money in your account");
            String transation = "Check Balance is " + String.valueOf(customer.getMoney());
            transact(transation,customer);
            transactionCount++;
        }
    }

    private void transaction(Customer customer) {
        System.out.println("Your transaction History is");
        for(String s: customer.getTransactions()){
            System.out.println(customer.getTransactions());
        }
    }
    public void transactionFromAccountToOther(Customer customer) {
        System.out.println("Enter the userName you want to Send");
        String payeeUser = scannerObject.next();
        System.out.println("Enter the amount you want to transfer");
        int amount = scannerObject.nextInt();
        if (amount < 0 || amount > customer.getMoney()) {
            System.out.println("Insufficient balance");
        }

        while (!Main.customerDetails.containsKey(payeeUser)) {
            System.out.println("Details Not Found");
            payeeUser = scannerObject.next();
            break;
        }
        var payeeCustomer = Main.customerDetails.get(payeeUser);
        payeeCustomer.setMoney(payeeCustomer.getMoney() + amount);
        customer.setMoney(customer.getMoney() - amount);
        System.out.println("successfully transferred " + amount);

    }
    public void transactionFromOneAccountFromAccountNumber(Customer customer) {
        System.out.println("Enter the accountNumber you want to transfer");
        long accountNumber = scannerObject.nextLong();
        System.out.println("Enter the amount you want to transfer");
        int amount = scannerObject.nextInt();
        if (amount < 0 || amount > customer.getMoney()) {
            System.out.println("transfer cancelled");
            amount = scannerObject.nextInt();
        }
        while (!Main.transferDetails.containsValue(accountNumber)) {
            System.out.println("Details not found");
            accountNumber = scannerObject.nextLong();
            break;
        }
        var payeeCustomer = Main.transferDetails.get(accountNumber);
        payeeCustomer.setMoney(payeeCustomer.getMoney() + amount);
        customer.setMoney(customer.getMoney() - amount);
        System.out.println("Successfully transfeered " + amount);
    }


}



