
/**
 * Store and edit banking information for customers.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
public class CustomerInfo
{
    //initialising variables.
    private String accountName;
    private String accountAddress;
    private int accountNumber;
    private String accountType;
    private double accountBalance;
    File bankData = new File("BankData.csv");
    Random Random = new Random();
    
    //Info Creator with just name, address, and type
    public void infoCreator(String accountName, String accountAddress, String accountType){
        this.accountName = accountName;
        this.accountAddress = accountAddress;
        this.accountNumber = Random.nextInt(99999999);
        this.accountType = accountType;
        this.accountBalance = 0.0;
        
        infoPrinter();
        
        //This is where the info for the new account is saved to the file
        try{
            FileWriter myWriter = new FileWriter(bankData);
            
            myWriter.write(accountName + "," + accountAddress + "," + accountNumber + "," + accountType + "," + accountBalance);
            
            myWriter.flush();
            myWriter.close();
        }catch(IOException e){
            System.out.println("Unexpected error, please try again");
        }
    }
    
    //Numerous getters for the various values
    public void infoPrinter(){
        System.out.println("The account is under the name " + accountName + " who lives at " + accountAddress + ", the bank number is " + accountNumber + ", the account type is " + accountType + ", and the account balance is " + accountBalance);
    }
    public String nameGetter(){
        return(this.accountName);
    }
    public String addressGetter(){
        return(this.accountAddress);
    }
    public int numberGetter(){
        return(this.accountNumber);
    }
    public String typeGetter(){
        return(this.accountType);
    }
    public double balanceGetter(){
        return(this.accountBalance);
    }
    
    //Numerous setters for the various values
    public void nameSetter(String newName){
        this.accountName = newName;
    }
    public void addressSetter(String newAddress){
        this.accountAddress = newAddress;
    }
    public void balanceSetter(double newBalance){
        this.accountBalance = newBalance;
    }
    //This method allows deposits/withdrawals
    public void balanceChanger(String direction, double value){
        if(direction.equals("DEPOSIT")){
            this.accountBalance = accountBalance + value;
        } else if(direction.equals("WITHDRAW")){
            this.accountBalance = accountBalance - value;
        }
    }
}
