package ExoticMeseum;

public class Child {

    // Attributes to store the child details
    private String name;
    private char gender;
    private int age;
    private double ticketCharge;

    // Necessary getters, setters and constructors
    public Child(String name, char gender, int age, double ticketCharge) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.ticketCharge = ticketCharge;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getTicketCharge() {
        return ticketCharge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTicketCharge(double ticketCharge) {
        this.ticketCharge = ticketCharge;
    }

    // Method to calculate the ticket charge to be paid for the child after deducting discount based on age
    public double calculateTicketCharge() {
        // Check the conditions for the age, gender and ticket charge
        if (age > 4 && age < 18 && (gender == 'M' || gender == 'F') && ticketCharge > 0) {
            // Declare a variable to store the discount percentage
            double discountPercentage = 0;
            // Assign the discount percentage based on the age range
            if (age >= 5 && age <= 10) {
                discountPercentage = 45;
            } else if (age >= 11 && age <= 13) {
                discountPercentage = 55;
            } else if (age >= 14 && age <= 17) {
                discountPercentage = 65;
            }
            // Calculate the discount amount
            double discount = (ticketCharge * discountPercentage) / 100;
            // Calculate the ticket charge after deducting the discount
            double finalTicketCharge = ticketCharge - discount;
            // Return the final ticket charge
            return finalTicketCharge;
        } else {
            // Return 0 if any of the conditions are not met
            return 0;
        }
    }
}
