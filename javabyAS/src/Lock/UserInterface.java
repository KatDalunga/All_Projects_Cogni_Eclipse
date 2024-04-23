package Lock;

import java.util.Scanner;

//Define the UserInterface class
public class UserInterface {

public static Lock extractDetails(String lockDetails) {
	     // Split the lockDetails by colon
	     String[] details = lockDetails.split(":");

	     // Parse the lockModel, codeLength, and lockState from the details
	     String lockModel = details[0];
	     int codeLength = Integer.parseInt(details[1]);
	     String lockState = details[details.length - 1];

	     // Parse the code from the details
	     int[] code = new int[codeLength];
	     for (int i = 0; i < codeLength; i++) {
	         code[i] = Integer.parseInt(details[i+2]);
	     }

	     // Create and return a new Lock object with the parsed details
	     return new Lock(lockModel, codeLength, code, lockState);
	 }

	
	
	

// Define the main method
public static void main(String[] args) {
   // Create a scanner object to read the user input
   Scanner scanner = new Scanner(System.in);

   // Prompt the user to enter the lock details
   System.out.println("Enter the details");
   String lockDetails = scanner.nextLine();

   // Extract the lock object from the lock details
   Lock lock = extractDetails(lockDetails);
   	
   if(lock.getLockState().equalsIgnoreCase("unlocked")) {
	   System.out.println("Lock is already unlocked.");
	   System.exit(0);
   }
   int length=lock.getCodeLength();
   System.out.println("Enter the code attempts of length  "+length);
   int[] arr=new int[length];
   for(int i=0;i<length;i++) {
	   arr[i]=scanner.nextInt();
   }
   String str=lock.enterCodeToUnlock(arr);
   if(lock.getLockState().equalsIgnoreCase("locked")) {
	   System.out.println(str);
   }
   else {
	   System.out.println(lock.getLockModel());
	   System.out.println(length);
	   System.out.println(lock.getLockState());
	   System.out.println(str);
   }
   
   
   
   // Close the scanner object
   scanner.close();
}
}
