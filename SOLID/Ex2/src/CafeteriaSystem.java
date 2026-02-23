import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final Persistence persistence;
    private final InvoicePrinter printer;
    private final PricingEngine pricingEngine = new PricingEngine();
    private int invoiceSeq = 1000;

    public CafeteriaSystem(Persistence persistence, InvoicePrinter printer) {
        this.persistence = persistence;
        this.printer = printer;
    }

    public CafeteriaSystem() {
        this(new FileStore(), new InvoiceFormatter());
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> orderLines) {
        String invId = "INV-" + (++invoiceSeq);
        
        TaxStrategy taxStrategy = new TaxRules(customerType);
        DiscountStrategy discountStrategy = new DiscountRules(customerType);

        Invoice invoice = pricingEngine.createInvoice(invId, orderLines, menu, taxStrategy, discountStrategy);
        
        printer.print(invoice);

        String formatted = printer.format(invoice);
        persistence.save(invId, formatted);
        
        System.out.println("Saved invoice: " + invId + " (lines=" + persistence.countLines(invId) + ")");
    }
}
