
/**
 * Have a banking system capable of creating or deleting accounts, reading account data, or editing the balance of an account.
 *
 * Joshua Hunter
 * 24/03/25-09/04/25
 * 
 * To do list:
 * Set out framework for ArrayList with Arrays
 * Lay out framework for VIEW, EDIT, MOVE, CLOSE
 * Finish working on /\ as well as finishing OPEN and STOP
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class main
{
    //This will be where most of the main banking will be done
    public static void main(String[] args){
        //Initialising file and variables
        System.out.print('\u000c');
        File bankData = new File("BankData.csv");
        Scanner Keyboard = new Scanner(System.in);
        CustomerInfo TestPerson = new CustomerInfo();
        String mainInput;
        String input;
        boolean stillRunning = true;
        boolean errorBlock;
        boolean rightType;
        //These 3 likely won't be permanent, but will help me with the process of creating accounts
        String name;
        String address;
        String type = "";
        
        //This is where the banker will be able to do banking
        System.out.println("Hello! I'll be your virtual banking assistant for today.");
        while(stillRunning==true){
            errorBlock = true;
            rightType = true;
            System.out.println("What would you like help with today? You can: view or edit an account, move money in or out of an account, open or close and account, or end the software.");
            System.out.println("Valid inputs are: VIEW, EDIT, MOVE, OPEN, CLOSE, STOP");
            System.out.print("I would like to: ");
            mainInput = Keyboard.nextLine();
            mainInput = mainInput.toUpperCase();
            
            if(mainInput.equals("OPEN")){
                while(errorBlock==true){
                    /**
                     * this will be where new info is created using the method in CustomerInfo
                     */
                    System.out.println("You have selected 'open a new account'.");
                    
                    System.out.println("What is the name that the account should be opened under?");
                    System.out.print("The account name should be under: ");
                    name = Keyboard.nextLine();
                    
                    System.out.println("What is the address for " + name);
                    System.out.print(name + " lives at: ");
                    address = Keyboard.nextLine();
                    
                    System.out.println("What type of account should this be?");
                    System.out.println("Valid inputs are: EVERYDAY, SAVINGS, CURRENT.");
                    while(rightType==true){
                        System.out.print("This account type will be: ");
                        type = Keyboard.nextLine();
                        type = type.toUpperCase();
                        if(type.equals("EVERYDAY")||type.equals("SAVINGS")||type.equals("CURRENT")){
                            rightType = false;
                        }else{System.out.println("Bad input, please try again");}
                    }
                    
                    TestPerson.infoCreator(name, address, type);
                    errorBlock = false;
                }
            }else if(mainInput.equals("STOP")){
                /**
                 * This will be where the updated information is saved to the file
                 */
                System.out.println("Changs saved to system, thank you for using my virtual banking assistance");
                stillRunning = false;
            }else{
                System.out.println("Bad input, please try again");
            }
        }
    }
}
