
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
    private int accountNumber;
    private String accountAddress;
    private String accountType;
    private double accountBalance;
    File bankData = new File("BankData.csv");
    Random Random = new Random();
    
    //Info creator with all info
    public void infoCreator(String accountName, int accountNumber, String accountAddress, String accountType, double accountBalance){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountAddress = accountAddress;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        
        System.out.println(accountName + ", " + accountNumber + ", " + accountAddress + ", " + accountType + ", " + accountBalance);
    }
    //Info Creator wiht just name, address, and type
    public void infoCreator(String accountName, String accountAddress, String accountType){
        this.accountName = accountName;
        this.accountNumber = Random.nextInt(99999999);
        this.accountAddress = accountAddress;
        this.accountType = accountType;
        this.accountBalance = 0.0;
        
        System.out.println(accountName + ", " + accountNumber + ", " + accountAddress + ", " + accountType + ", " + accountBalance);
    }
}
