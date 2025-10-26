import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Demo program for Project 2.
 * Reads policy records from PolicyInformation.txt and prints each policy,
 * plus counts of smokers and non-smokers.
 */
public class Demo {
    // Format helpers
    private static final DecimalFormat MONEY = new DecimalFormat("$#,##0.00");
    private static final DecimalFormat ONE_DEC = new DecimalFormat("0.0");
    private static final DecimalFormat TWO_DEC = new DecimalFormat("0.00");

    public static void main(String[] args) {
        String path = "PolicyInformation.txt"; // file should be in project folder
        ArrayList<Policy> policies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (true) {
                String policyNumber = readNextNonEmpty(br);
                if (policyNumber == null) break; // end of file

                String providerName = readNextNonEmpty(br);
                String firstName = readNextNonEmpty(br);
                String lastName = readNextNonEmpty(br);
                String ageStr = readNextNonEmpty(br);
                String smokingStr = readNextNonEmpty(br);
                String heightStr = readNextNonEmpty(br);
                String weightStr = readNextNonEmpty(br);

                if (providerName == null || firstName == null || lastName == null ||
                    ageStr == null || smokingStr == null || heightStr == null || weightStr == null) {
                    // Incomplete record at EOF; stop
                    break;
                }

                int age = Integer.parseInt(ageStr.trim());
                boolean smoker = smokingStr.trim().equalsIgnoreCase("smoker");
                double heightIn = Double.parseDouble(heightStr.trim());
                double weightLb = Double.parseDouble(weightStr.trim());

                PolicyHolder holder = new PolicyHolder(firstName.trim(), lastName.trim(), age, smoker, heightIn, weightLb);
                Policy policy = new Policy(policyNumber.trim(), providerName.trim(), holder);
                policies.add(policy);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        int smokerCount = 0;
        int nonSmokerCount = 0;

        for (Policy p : policies) {
            PolicyHolder h = p.getPolicyHolder();
            double bmi = h.getBMI();

            System.out.println("Policy Number: " + p.getPolicyNumber());
            System.out.println();
            System.out.println("Provider Name: " + p.getProviderName());
            System.out.println();
            System.out.println("Policyholder's First Name: " + h.getFirstName());
            System.out.println();
            System.out.println("Policyholder's Last Name: " + h.getLastName());
            System.out.println();
            System.out.println("Policyholder's Age: " + h.getAge());
            System.out.println();
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + (h.isSmoker() ? "smoker" : "non-smoker"));
            System.out.println();
            System.out.println("Policyholder's Height: " + TWO_DEC.format(h.getHeightInInches()) + " inches");
            System.out.println();
            System.out.println("Policyholder's Weight: " + TWO_DEC.format(h.getWeightInPounds()) + " pounds");
            System.out.println();
            System.out.println("Policyholder's BMI: " + TWO_DEC.format(bmi));
            System.out.println();
            System.out.println("Policy Price: " + MONEY.format(p.getPrice()));
            System.out.println();
            System.out.println(); // blank line between policies

            if (h.isSmoker()) smokerCount++; else nonSmokerCount++;
        }

        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println();
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }

    /**
     * Reads next non-empty trimmed line, skipping blank spacer lines.
     * @param br buffered reader
     * @return the next non-empty line or null at EOF
     * @throws IOException if I/O error occurs
     */
    private static String readNextNonEmpty(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().length() > 0) return line.trim();
        }
        return null;
        }
}
