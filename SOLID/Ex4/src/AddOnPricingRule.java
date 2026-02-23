class MessRule implements PricingRule {
    public boolean appliesTo(BookingRequest req) { return req.addOns.contains(AddOn.MESS); }
    public Money getCost() { return new Money(1000.0); }
}

class LaundryRule implements PricingRule {
    public boolean appliesTo(BookingRequest req) { return req.addOns.contains(AddOn.LAUNDRY); }
    public Money getCost() { return new Money(500.0); }
}

class GymRule implements PricingRule {
    public boolean appliesTo(BookingRequest req) { return req.addOns.contains(AddOn.GYM); }
    public Money getCost() { return new Money(300.0); }
}
