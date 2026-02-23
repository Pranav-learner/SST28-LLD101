public interface TaxStrategy {
    double calculateTax(double subtotal);
    double getTaxRate();
}
