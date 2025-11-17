public class Policy
{
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    private static int policyCount = 0;

    public Policy()
    {
        policyNumber = "";
        providerName = "";
        policyHolder = new PolicyHolder();
        policyCount++;
    }

    public Policy(String policyNumber, String providerName, PolicyHolder policyHolder)
    {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = new PolicyHolder(policyHolder);
        policyCount++;
    }

    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    public PolicyHolder getPolicyHolder()
    {
        return new PolicyHolder(policyHolder);
    }

    public void setPolicyHolder(PolicyHolder policyHolder)
    {
        this.policyHolder = new PolicyHolder(policyHolder);
    }

    public static int getPolicyCount()
    {
        return policyCount;
    }

    public double getPolicyPrice()
    {
        double basePrice = 600.0;

        if (policyHolder.getAge() > 50)
            basePrice += 75.0;

        if (policyHolder.isSmoker())
            basePrice += 100.0;

        double bmi = policyHolder.getBMI();
        if (bmi > 35)
            basePrice += (bmi - 35) * 20.0;

        return basePrice;
    }

    @Override
    public String toString()
    {
        return String.format(
            "Policy Number: %s%n%n" +
            "Provider Name: %s%n%n" +
            "%s" +
            "Policy Price: $%.2f%n",
            policyNumber, providerName, policyHolder.toString(), getPolicyPrice());
    }
}
