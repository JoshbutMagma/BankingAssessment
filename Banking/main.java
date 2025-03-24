
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
        String mainInput;
        String input;
        boolean stillRunning = true;
        boolean errorBlock;
        //These 3 likely won't be permanent, but will help me with the process of creating accounts
        String name;
        String address;
        String type;
        
        //This is where the banker will be able to do banking
        System.out.println("Hello! I'll be your virtual banking assistant for today.");
        while(stillRunning==true){
            errorBlock = true;
            System.out.println("What would you like help with today? You can: view or edit an account, move money in or out of an account, open or close and account, or end the software.");
            System.out.println("Valid inputs are: VIEW, EDIT, MOVE, OPEN, CLOSE, STOP");
            mainInput = Keyboard.nextLine();
            mainInput = mainInput.toUpperCase();
            
            if(mainInput=="OPEN"){
                while(errorBlock==true){
                    System.out.println("Will this new account use a custom number and balance or will we start from scratch?");
                    System.out.println("Valid inputs are: CUSTOM, NEW");
                    input = Keyboard.nextLine();
                    input = input.toUpperCase();
                    
                    /**
                     * this will be where new info is created using the method in CustomerInfo
                     */
                    if(input=="CUSTOM"){
                        
                        errorBlock = false;
                    }else if(input=="NEW"){
                        
                        errorBlock = false;
                    }else{
                        System.out.println("Bad input, please try again");
                    }
                }
            }else if(mainInput=="STOP"){
                /**
                 * This will be where the updated information is saved to the file
                 */
                stillRunning = false;
            }else{
                System.out.println("Bad input, please try again");
            }
        }
    }
}
