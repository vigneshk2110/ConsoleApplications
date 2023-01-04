package bankconsoleapp;

import java.util.Map;
import java.util.Scanner;

public class BankAdmin {
    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
     void bankAdmin(){
         try{
             while(loop){
         System.out.println("1.Display Available Users in the bank");
         int adminChoice = scanner.nextInt();
                 switch(adminChoice){
                     case 1:
                         displayUsers();
                         break;
                     case 2:
                         loop = false;
                         return;
                 }
             }

         }catch (Exception e){
             System.out.println("You have entered a wrong option");
         }
     }
        void displayUsers(){
            System.out.println("Available users in Bank");
            for(Map.Entry<String,Customer> entrySet : Main.customerDetails.entrySet()){
                System.out.println(entrySet.getKey() + " ");
            }
            System.out.println("Available Bank Admin in bank");
            for(Map.Entry<String,BankPojo> entrySet : Main.bankPojoMap.entrySet()){
                System.out.println(entrySet.getKey() + " ");
            }

        }
        void loanProcess(Customer customer){

        }



}
