public interface PricingRule {
    boolean appliesTo(BookingRequest req);
    Money getCost();
}
