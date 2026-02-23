public interface InvoicePrinter {
    void print(Invoice invoice);
    String format(Invoice invoice);
}
