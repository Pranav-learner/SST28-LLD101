class SingleRoomRule implements PricingRule {
    public boolean appliesTo(BookingRequest req) { return req.roomType == LegacyRoomTypes.SINGLE; }
    public Money getCost() { return new Money(14000.0); }
}

class DoubleRoomRule implements PricingRule {
    public boolean appliesTo(BookingRequest req) { return req.roomType == LegacyRoomTypes.DOUBLE; }
    public Money getCost() { return new Money(15000.0); }
}

class TripleRoomRule implements PricingRule {
    public boolean appliesTo(BookingRequest req) { return req.roomType == LegacyRoomTypes.TRIPLE; }
    public Money getCost() { return new Money(12000.0); }
}

class DeluxeRoomRule implements PricingRule {
    public boolean appliesTo(BookingRequest req) { return req.roomType == LegacyRoomTypes.DELUXE; }
    public Money getCost() { return new Money(16000.0); }
}

class DefaultRoomRule implements PricingRule {
    public boolean appliesTo(BookingRequest req) { 
        return req.roomType != LegacyRoomTypes.SINGLE && 
               req.roomType != LegacyRoomTypes.DOUBLE && 
               req.roomType != LegacyRoomTypes.TRIPLE && 
               req.roomType != LegacyRoomTypes.DELUXE;
    }
    public Money getCost() { return new Money(16000.0); }
}
