/**
 * Policy represents an insurance policy with pricing rules.
 * The price rules (from Project 1) are assumed as:
 * Base price: $600
 * + $75 if policyholder age > 50
 * + $100 if policyholder is a smoker
 * + $20 for each BMI point above 35.0 (i.e., max(0, BMI - 35) * 20)
 */
public class Policy {
    private String policyNumber;
    private String providerName;
    private PolicyHolder holder;

    /**
     * Constructs a Policy.
     * @param policyNumber policy number as a string
     * @param providerName insurance provider's name
     * @param holder PolicyHolder object with details about the insured person
     */
    public Policy(String policyNumber, String providerName, PolicyHolder holder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.holder = holder;
    }

    /**
     * Gets the policy number.
     * @return policy number as String
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Gets the provider name.
     * @return provider name as String
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Gets the PolicyHolder associated with this policy.
     * @return PolicyHolder instance
     */
    public PolicyHolder getPolicyHolder() {
        return holder;
    }

    /**
     * Computes the policy price based on the assignment rules.
     * <p>
     * Pricing:
     * <ul>
     *   <li>Base price: $600</li>
     *   <li>Age surcharge: +$75 if policyholder age &gt; 50</li>
     *   <li>Smoking surcharge: +$100 if policyholder is a smoker</li>
     *   <li>BMI surcharge: +$20 for each BMI point above 35.0</li>
     * </ul>
     * @return total policy price as a double
     */
    public double getPrice() {
        double price = 600.0;
        if (holder.getAge() > 50) {
            price += 75.0;
        }
        if (holder.isSmoker()) {
            price += 100.0;
        }
        double bmiOver = Math.max(0.0, holder.getBMI() - 35.0);
        price += bmiOver * 20.0;
        return price;
    }
}
