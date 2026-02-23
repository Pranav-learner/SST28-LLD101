public class DiscountRules implements DiscountStrategy {
    private final String customerType;

    public DiscountRules(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public double calculateDiscount(double subtotal, int distinctLines) {
        if ("student".equalsIgnoreCase(customerType)) {
            if (subtotal >= 180.0) return 10.0;
            return 0.0;
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            if (distinctLines >= 3) return 15.0;
            return 5.0;
        }
        return 0.0;
    }
}
