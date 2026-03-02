import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

/**
 * Starter demo updated to show pristine immutability in action.
 */
public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t1 = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + t1);

        // Updates must now capture the new instance returned by the service
        IncidentTicket t2 = service.assign(t1, "agent@example.com");
        IncidentTicket t3 = service.escalateToCritical(t2);
        
        System.out.println("\nOriginal ticket remains unchanged: " + t1);
        System.out.println("New escalated ticket: " + t3);

        // Demonstrate external mutation via leaked list reference is no longer possible
        System.out.println("\nAttempting to mutate tags from the outside...");
        List<String> tags = t3.getTags();
        try {
            tags.add("HACKED_FROM_OUTSIDE");
        } catch (UnsupportedOperationException e) {
            System.out.println("Nice! Caught UnsupportedOperationException: List is unmodifiable.");
        }
        
        System.out.println("Final state of escalated ticket tags: " + t3.getTags());
    }
}
