
/**
 * Have a banking system capable of creating or deleting accounts, reading account data, or editing the balance of an account.
 *
 * Joshua Hunter
 * 24/03/25-09/04/25
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
        
        CustomerInfo person1 = new CustomerInfo();
        person1.infoCreator("David", 12345678, "10 Ruby St.", "Everyday", 0.0);
        CustomerInfo person2 = new CustomerInfo();
        person2.infoCreator("Bill", "23 Amethyst St.", "Everyday");
    }
}
