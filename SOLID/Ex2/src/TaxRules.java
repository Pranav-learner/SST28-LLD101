public class TaxRules implements TaxStrategy {
    private final String customerType;

    public TaxRules(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public double getTaxRate() {
        if ("student".equalsIgnoreCase(customerType)) return 5.0;
        if ("staff".equalsIgnoreCase(customerType)) return 2.0;
        return 8.0;
    }

    @Override
    public double calculateTax(double subtotal) {
        return subtotal * (getTaxRate() / 100.0);
    }
}
