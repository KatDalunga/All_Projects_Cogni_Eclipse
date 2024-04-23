package DepositorInfo;

//A class to represent the depositor information
public class DepositorInfo {
 // Attributes
 private String accountNumber;
 private String depositType;
 private int noOfYears;
 private double depositAmount;

 // Constructor
 public DepositorInfo(String accountNumber, String depositType, int noOfYears, double depositAmount) {
     this.accountNumber = accountNumber;
     this.depositType = depositType;
     this.noOfYears = noOfYears;
     this.depositAmount = depositAmount;
 }

 // Getters and setters
 public String getAccountNumber() {
     return accountNumber;
 }

 public void setAccountNumber(String accountNumber) {
     this.accountNumber = accountNumber;
 }

 public String getDepositType() {
     return depositType;
 }

 public void setDepositType(String depositType) {
     this.depositType = depositType;
 }

 public int getNoOfYears() {
     return noOfYears;
 }

 public void setNoOfYears(int noOfYears) {
     this.noOfYears = noOfYears;
 }

 public double getDepositAmount() {
     return depositAmount;
 }

 public void setDepositAmount(double depositAmount) {
     this.depositAmount = depositAmount;
 }

 // A method to calculate the total amount of returns based on the deposit type
 public double calculateTotalAmountOfReturns() {
     // Declare a variable to store the rate of interest
     double rateOfInterest = 0.0;

     // Check the deposit type and assign the corresponding rate of interest
     switch (depositType.toLowerCase()) {
         case "savings":
             rateOfInterest = 0.05;
             break;
         case "fixeddeposit":
             rateOfInterest = 0.10;
             break;
         case "recurringdeposit":
             rateOfInterest = 0.15;
             break;
         case "specialpurposedeposit":
             rateOfInterest = 0.20;
             break;
         default:
             // Return -1 if the deposit type is invalid
             return -1;
     }

     // Check if the deposit amount and no of years are positive
     if (depositAmount > 0 && noOfYears > 0) {
         // Calculate the interest amount
         double interestAmount = (depositAmount*rateOfInterest);

         // Calculate the total amount of returns
         double totalAmountOfReturns = (depositAmount+interestAmount)*noOfYears;

         // Return the total amount of returns
         return totalAmountOfReturns;
     } else {
         // Return -1 if the deposit amount or no of years are negative
         return -1;
     }
 }


}

