package BagParadise;

public class BagInfo {

    // Attributes to store the bag details
    private String customerName;
    private int bagId;
    private String bagBrand;
    private String bagType;
    private double bagPrice;

    // Necessary getters, setters and 5-argument constructor
    public BagInfo(String customerName, int bagId, String bagBrand, String bagType, double bagPrice) {
        this.customerName = customerName;
        this.bagId = bagId;
        this.bagBrand = bagBrand;
        this.bagType = bagType;
        this.bagPrice = bagPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getBagId() {
        return bagId;
    }

    public String getBagBrand() {
        return bagBrand;
    }

    public String getBagType() {
        return bagType;
    }

    public double getBagPrice() {
        return bagPrice;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setBagId(int bagId) {
        this.bagId = bagId;
    }

    public void setBagBrand(String bagBrand) {
        this.bagBrand = bagBrand;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public void setBagPrice(double bagPrice) {
        this.bagPrice = bagPrice;
    }

    // Method to calculate the total price to be paid by the customer after deducting the discount price
    public double calculateTotalPrice() {
        // Check the conditions for the bag brand and bag price
        if (bagBrand != null && bagPrice > 0) {
            // Declare a variable to store the discount percentage
            double discountPercentage = 0;
            // Assign the discount percentage based on the bag brand, ignoring case
            switch (bagBrand.toLowerCase()) {
                case "americantourister":
                    discountPercentage = 15;
                    break;
                case "baggit":
                    discountPercentage = 18;
                    break;
                case "louisvuitton":
                    discountPercentage = 25;
                    break;
                case "gucci":
                    discountPercentage = 20;
                    break;
                default:
                    // Return -1 if the bag brand does not match any of the eligible brands
                    return -1;
            }
            // Calculate the discount amount
            double discount = (bagPrice * discountPercentage) / 100;
            // Calculate the total price after deducting the discount
            double totalPrice = bagPrice - discount;
            // Return the total price
            return totalPrice;
        } else {
            // Return -1 if the bag brand is null or the bag price is less than or equal to 0
            return -1;
        }
    }
}

