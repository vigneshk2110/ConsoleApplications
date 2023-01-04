package bankconsoleapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
   public static Map<String, Customer> customerDetails = new HashMap<>();
    public static Map<Long,Customer> transferDetails = new HashMap<>();
    public static Map<String,BankPojo> bankPojoMap = new HashMap<>();
     static Scanner scanner = new Scanner(System.in);
    String username;
    String password;
    private static long accountNumber = 2022000;
    public static void main(String[] args){
        Main main = new Main();
        main.userDetails();
    }
    void userDetails() {
        BankPojo bankPojo = new BankPojo("bank","password",1000000000);
        bankPojoMap.put("bank",bankPojo);
        try {
            while (true) {
                System.out.println("WELCOME TO BANK");
                System.out.println("1.Register account");
                System.out.println("2.For Banking Person Login");
                System.out.println("3.User Login");
                System.out.println("4.Exit");
                System.out.print("\nEnter your choice :");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter name");
                        String name = scanner.nextLine();
                        while (!name.matches(("^[aA-zZ][aA-zZ\\s.]{2,29}$"))) {
                            System.out.println("Enter a valid userName");
                            name = scanner.next();
                        }
                        System.out.print("Enter contact number");
                        String phone = scanner.nextLine();
                        while (!phone.matches(("^[6789][0-9]{9}$"))) {
                            System.out.println("Enter a valid mobile Phone Number");
                            phone = scanner.next();
                        }
                        System.out.println("Set username");
                        username = scanner.next();
                        while (!username.matches(("^[aA-zZ][aA-zZ\\s.]{2,29}$"))) {
                            System.out.println("Enter a Valid UserName");
                            username = scanner.next();
                        }
                        while (customerDetails.containsKey(username)) {
                            System.out.println("Username already exists. Set again :");
                            username = scanner.next();
                        }
                        System.out.println("Enter a password");
                        System.out.println("Kindly Set A Password that should contains the below:");
                        System.out.println("1 uppercase ,   1 lowercase ,   1 special character ,  1 numerical value");
                        password = scanner.next();
                        scanner.nextLine();
                        while (!password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))//catching exception
                        {
                            System.out.println("Enter The Valid Password");
                            password = scanner.next();
                        }
                        System.out.println("Your New Account Number is " + ++accountNumber);
                        Customer customer = new Customer(username, password, name, phone ,accountNumber);
                        customerDetails.put(username, customer);
                        transferDetails.put(accountNumber, customer);
                        break;
                    case 2:
                        System.out.println("Enter username :");
                        username = scanner.next();
                        scanner.nextLine();
                        System.out.println("Enter password :");
                        password = scanner.next();
                       bankPojoMap.put(username,bankPojo);
                        if (bankPojoMap.containsKey(username)) {
                                if (bankPojo.password.equals(password)) {
                                    System.out.println("welcome Bank Admin " + username);
                                    new BankAdmin().bankAdmin();
                                    break;
                                }
                        } else {
                            System.out.println("You havent registered yet");
                        }
                       break;
                    case 3:
                        System.out.println("Enter username :");
                        username = scanner.next();
                        scanner.nextLine();
                        System.out.println("Enter password :");
                        password = scanner.next();
                        System.out.println("Enter account Number");
                        long accountNumber = scanner.nextLong();
                        if (customerDetails.containsKey(username)) {
                            customer = customerDetails.get(username);
                            if (customer.getAccountNumber() == accountNumber) {
                                if (customer.password.equals(password)) {
                                    System.out.println("welcome user " + username);
                                    new BankingProcess().displayMethod(customer,bankPojo);
                                }
                            }
                        } else {
                            System.out.println("You havent registered yet");
                        }

                    break;
                    case 4:
                        System.out.println("\nThank you for choosing Bank.");
                        System.exit(1);
                        break;
                }
            }
        }catch (Exception e){
            System.out.println("You have entered a wrong input");
        }
    }


}




