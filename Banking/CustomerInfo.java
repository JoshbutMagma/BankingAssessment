
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
public class CustomerInfo
{
    //initialising variables.
    private String accountName;
    private String accountAddress;
    private int accountNumber;
    private String accountType;
    private double accountBalance;
    Random Random = new Random();
    
    /** //Info creator with all info
    public void infoCreator(String accountName, String accountAddress, int accountNumber, String accountType, double accountBalance){
        this.accountName = accountName;
        this.accountAddress = accountAddress;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        
        System.out.println(accountName + ", " + accountAddress + ", " + accountNumber + ", " + accountType + ", " + accountBalance);
    }*/
    //Info Creator with just name, address, and type
    public void infoCreator(String accountName, String accountAddress, String accountType){
        this.accountName = accountName;
        this.accountAddress = accountAddress;
        this.accountNumber = Random.nextInt(99999999);
        this.accountType = accountType;
        this.accountBalance = 0.0;
        
        System.out.println("The account is under the name " + accountName + " who lives at " + accountAddress + ", the bank number is " + accountNumber + ", the account type is " + accountType + ", and the account balance is " + accountBalance);
    }
}
