package StatueInfo;

//Define the StatueInfo class
public class StatueInfo {
 // Declare the attributes
 private String statueName;
 private String origin;
 private String carvingType;
 private double price;

 // Initialize the attributes with a four-argument constructor
 public StatueInfo(String statueName, String origin, String carvingType, double price) {
     this.statueName = statueName;
     this.origin = origin;
     this.carvingType = carvingType;
     this.price = price;
 }

 // Define the getters and setters for the attributes
 public String getStatueName() {
     return statueName;
 }

 public void setStatueName(String statueName) {
     this.statueName = statueName;
 }

 public String getOrigin() {
     return origin;
 }

 public void setOrigin(String origin) {
     this.origin = origin;
 }

 public String getCarvingType() {
     return carvingType;
 }

 public void setCarvingType(String carvingType) {
     this.carvingType = carvingType;
 }

 public double getPrice() {
     return price;
 }

 public void setPrice(double price) {
     this.price = price;
 }

 

 // Define the method to calculate the total statue price to be paid by the customer including the tax%
 public double calculateTotalStatuePrice(int quantity) {
     // Declare a variable to store the tax%
     double tax = 0.0;

     // Check the carvingType and assign the corresponding tax%
     switch (carvingType) {
         case "Wood Carving":
             tax = 0.02;
             break;
         case "Ceramic Figurine":
             tax = 0.05;
             break;
         case "Bronze Sculpture":
             tax = 0.06;
             break;
         case "Stone Carving":
             tax = 0.04;
             break;
         case "Wire Art Sculpture":
             tax = 0.03;
             break;
         default:
             // If the carvingType does not match any of the above types, return -1
             return -1;
     }

     // Check the quantity and price
     if (quantity <= 0 || price <= 0) {
         // If the quantity or price is less than or equal to 0, return -1
         return -1;
     }

     // Calculate the total statue price to be paid
     double totalStatuePrice = quantity * (price + (price * tax));

     // Return the total statue price
     return totalStatuePrice;
 }


}



