import java.util.*;

public class PricingEngine {
    public Invoice createInvoice(String invId, List<OrderLine> orderLines, Map<String, MenuItem> menu, TaxStrategy taxStrategy, DiscountStrategy discountStrategy) {
        double subtotal = 0.0;
        List<Invoice.InvoiceLine> lines = new ArrayList<>();

        for (OrderLine ol : orderLines) {
            MenuItem item = menu.get(ol.itemId);
            double lineTotal = item.price * ol.qty;
            subtotal += lineTotal;
            lines.add(new Invoice.InvoiceLine(item.name, ol.qty, lineTotal));
        }

        double tax = taxStrategy.calculateTax(subtotal);
        double taxPct = taxStrategy.getTaxRate();
        double discount = discountStrategy.calculateDiscount(subtotal, orderLines.size());
        double total = subtotal + tax - discount;

        return new Invoice(invId, lines, subtotal, taxPct, tax, discount, total);
    }
}
