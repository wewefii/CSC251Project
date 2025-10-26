/**
 * PolicyHolder represents an individual who holds an insurance policy.
 */
public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private boolean smoker; // true if smoker, false if non-smoker
    private double heightInInches;
    private double weightInPounds;

    /**
     * Constructs a PolicyHolder.
     * @param firstName policyholder's first name
     * @param lastName policyholder's last name
     * @param age policyholder's age in whole years
     * @param smoker true if smoker, false if non-smoker
     * @param heightInInches height in inches
     * @param weightInPounds weight in pounds
     */
    public PolicyHolder(String firstName, String lastName, int age, boolean smoker,
                        double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smoker = smoker;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    /** @return policyholder's first name */
    public String getFirstName() { return firstName; }

    /** @return policyholder's last name */
    public String getLastName() { return lastName; }

    /** @return policyholder's age in whole years */
    public int getAge() { return age; }

    /** @return true if the policyholder is a smoker, false otherwise */
    public boolean isSmoker() { return smoker; }

    /** @return height in inches */
    public double getHeightInInches() { return heightInInches; }

    /** @return weight in pounds */
    public double getWeightInPounds() { return weightInPounds; }

    /**
     * Calculates the Body Mass Index (BMI) using the imperial formula.
     * BMI = (weight * 703) / (height^2)
     * @return BMI value as a double
     */
    public double getBMI() {
        return (weightInPounds * 703.0) / (heightInInches * heightInInches);
    }
}
