
/**
 * Have a banking system capable of creating or deleting accounts, reading account data, or editing the balance of an account.
 *
 * Joshua Hunter
 * 24/03/25-09/04/25
 * 
 * To do list:
 * Have the software auto remove old data
 * Fix the thing where opening a new account deletes the old one
 * Have the software save to file when it closes as opposed to opening an account
 * Lay out framework for EDIT, MOVE, CLOSE
 * Finish working on /\ as well as finishing VIEW, STOP
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
public class main
{
    /**
     * This method allows me to receive inputs and remove commas from said inputs
     * This is so that when the info is eventually stored to a file seperated by commas, the datapoints won't be messed up because of any commas
     */
    private static String commaCheck(){
        Scanner Keyboard = new Scanner(System.in);
        String input = "";
        int subtract;
        boolean errorCheck = true;
        
        while(errorCheck){
            input = Keyboard.nextLine();
            if(input.length()>20){
                System.out.println("Length error: input is too long. Please reinput using less than 20 characters.");
                System.out.println("If you need to go over 20 characters, please abreviate longer names.");
            }else{
                errorCheck = false;
            }
        }
        input = input.replace(",","");
        
        //We'll be determining what in a string we'll be looking at based off of static positions in the string. This short addition allows us to have values of uniform length, allowing us to pinpoint exactly what we're looking at
        subtract = 20-input.length();
        for(int i=0; i<subtract; i++){
            input = input.concat(" ");
        }
        
        return input;
    }
    //This will be where most of the main banking will be done
    public static void main(String[] args){
        //Initialising file and variables
        System.out.print('\u000c');
        File bankData = new File("BankData.txt");
        Scanner readInfo = new Scanner("BankData.txt");
        Scanner Keyboard = new Scanner(System.in);
        CustomerInfo TestPerson = new CustomerInfo();
        ArrayList<String> allAccounts = new ArrayList<String>();
        String mainInput;
        String input;
        boolean stillRunning = true;
        boolean errorBlock;
        boolean rightType;
        String name = "";
        String outpName;
        String address = "";
        String type = "";
        String account;
        double currentBalance;
        double balanceMoved;
        
        //This is where all the old info is inserted into the program
        while(readInfo.hasNextLine()){
            allAccounts.add(readInfo.nextLine());
        }
        
        //This is where the banker will be able to do banking
        System.out.println("Hello! I'll be your virtual banking assistant for today.");
        while(stillRunning){
            //this is where the banker will be able to input what they would like the software to do
            System.out.println("What would you like help with today? You can: view or edit an account, move money in or out of an account, open or close and account, or end the software.");
            System.out.println("Valid inputs are: VIEW, EDIT, MOVE, OPEN, CLOSE, STOP");
            System.out.print("I would like to: ");
            mainInput = Keyboard.nextLine();
            mainInput = mainInput.toUpperCase();
            
            //This is where the bankers inputs will be used to determine what the software does next
            if(mainInput.equals("VIEW")){
                /**
                 * This is where the client will be able to view all banking info
                 */
                System.out.println();
                System.out.println("You have selected 'View an account'.");
                System.out.println("A full list of every account name:");
                for(int i=0; i<allAccounts.size(); i++){
                    System.out.println((i+1) + ". " + allAccounts.get(i));
                }
                System.out.println();
            }else if(mainInput.equals("EDIT")){
                /**
                 * This is where the client will be able to edit pre-existing info
                 */
            }else if(mainInput.equals("MOVE")){
                /**
                 * This is where we'll be able to move money in or out of accounts
                 */
            }else if(mainInput.equals("OPEN")){
                /**
                 * This will be where new info is created using the method in CustomerInfo
                 */
                rightType = true;
                System.out.println();
                System.out.println("You have selected 'Open a new account'.");
                System.out.println("What is the name that the account should be opened under?");
                System.out.print("The account name should be under: ");
                name = commaCheck();
                outpName = name.trim();
                
                System.out.println("What is the address for " + outpName);
                System.out.print(outpName + " lives at: ");
                address = commaCheck();
                
                System.out.println("What type of account should this be?");
                System.out.println("Valid inputs are: EVERYDAY, SAVINGS, CURRENT.");
                while(rightType){
                    System.out.print("This account type will be: ");
                    type = Keyboard.nextLine();
                    type = type.toUpperCase();
                    if(type.equals("EVERYDAY")||type.equals("SAVINGS")||type.equals("CURRENT")){
                        if(!type.equals("EVERYDAY")){
                            type = type.concat(" ");
                        }
                        rightType = false;
                    }else{System.out.println("Bad input, please try again");}
                }
            
                TestPerson.infoCreator(name, address, type);
                System.out.println();
            }else if(mainInput.equals("CLOSE")){
                /**
                 * This is where we can delete any pre-existing accounts
                 */
            }else if(mainInput.equals("STOP")){
                /**
                 * This will be where the updated information is saved to the file, and the software can be closed
                 */
                System.out.println();
                try{
                    FileWriter writeInfo = new FileWriter("BankData.txt");
                    
                    for(String infoWriter:allAccounts){
                        writeInfo.write(infoWriter + "\n");
                    }
                    
                    writeInfo.flush();
                    writeInfo.close();
                }catch(IOException e){
                    System.out.println("Unexpected error, please try again");
                }
                System.out.println("Changes saved to system, thank you for using the virtual banking assistant");
                stillRunning = false;
            }else{
                System.out.println("Bad input, please try again");
                System.out.println();
            }
        }
    }
}
