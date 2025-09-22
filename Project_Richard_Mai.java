import java.util.Scanner;

public class Project_Richard_Mai { // rename to match your existing project main class if needed
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter the Policy Number: ");
        String policyNumber = in.nextLine().trim();

        System.out.print("Please enter the Provider Name: ");
        String providerName = in.nextLine().trim();

        System.out.print("Please enter the Policyholder's First Name: ");
        String firstName = in.nextLine().trim();

        System.out.print("Please enter the Policyholder's Last Name: ");
        String lastName = in.nextLine().trim();

        System.out.print("Please enter the Policyholder's Age: ");
        int age = Integer.parseInt(in.nextLine().trim());

        System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
        String smokingStatus = in.nextLine().trim();

        System.out.print("Please enter the Policyholder's Height (in inches): ");
        double heightInches = Double.parseDouble(in.nextLine().trim());

        System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        double weightPounds = Double.parseDouble(in.nextLine().trim());

        // Create the Policy object
        Policy policy = new Policy(
                policyNumber,
                providerName,
                firstName,
                lastName,
                age,
                smokingStatus,
                heightInches,
                weightPounds
        );

        // Output
        System.out.println();
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder's First Name: " + policy.getFirstName());
        System.out.println("Policyholder's Last Name: " + policy.getLastName());
        System.out.println("Policyholder's Age: " + policy.getAge());
        System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Policyholder's Height: " + policy.getHeightInches());
        System.out.println("Policyholder's Weight: " + policy.getWeightPounds());
        System.out.printf("Policyholder's BMI: %.2f%n", policy.calculateBMI());
        System.out.printf("Policy Price: $%.2f%n", policy.calculatePolicyPrice());

        in.close();
    }
}
