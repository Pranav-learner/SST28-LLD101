import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));

        List<PricingRule> rules = Arrays.asList(
            new SingleRoomRule(),
            new DoubleRoomRule(),
            new TripleRoomRule(),
            new DeluxeRoomRule(),
            new DefaultRoomRule(),
            new MessRule(),
            new LaundryRule(),
            new GymRule()
        );

        HostelFeeCalculator calc = new HostelFeeCalculator(rules);
        HostelBookingService service = new HostelBookingService(calc, new FakeBookingRepo());
        service.process(req);
    }
}
