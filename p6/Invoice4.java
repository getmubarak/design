import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// ================================================================
// client
// ================================================================

public class InvoiceApp {
    public static void main(String[] args) {
        printTotal("KST", new KstTax());   // 1200 + 60  = 1260.0
        printTotal("CST", new CstTax());   // 1200 + 530 = 1730.0
        printTotal("GST", new GstTax());   // 1200 + 0   = 1200.0
    }

    private static void printTotal(String label, Tax tax) {
        Invoice invoice = new Invoice(tax);
        invoice.addItem(new InvoiceLineItem(400, 3));
        System.out.println(label + " total: " + invoice.getTotal());
    }
}

// ================================================================
// contract
// ================================================================

interface Tax {
    double compute(double amount);
}

// ================================================================
// invoicing
// ================================================================

class InvoiceLineItem {
    private final double price;
    private final int quantity;

    InvoiceLineItem(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    double getLineTotal() {
        return price * quantity;
    }
}

class Invoice {
    private final Tax tax;
    private final List<InvoiceLineItem> items = new ArrayList<>();

    Invoice(Tax tax) {
        this.tax = Objects.requireNonNull(tax, "Tax is required");
    }

    void addItem(InvoiceLineItem item) {
        items.add(item);
    }

    double getSubtotal() {
        return items.stream()
                    .mapToDouble(InvoiceLineItem::getLineTotal)
                    .sum();
    }

    double getTotal() {
        double subtotal = getSubtotal();
        return subtotal + tax.compute(subtotal);
    }
}

// ================================================================
// taxing
// ================================================================

class KstTax implements Tax {
    private static final double RATE = 0.05;
    private static final double THRESHOLD = 1000;

    @Override
    public double compute(double amount) {
        return amount > THRESHOLD ? amount * RATE : 0;
    }
}

class CstTax implements Tax {
    private static final double RATE = 0.025;
    private static final double FIXED_FEE = 500;

    @Override
    public double compute(double amount) {
        return amount * RATE + FIXED_FEE;
    }
}

class GstTax implements Tax {
    private static final double THRESHOLD = 5000;
    private static final double RATE_BELOW = 0.3;
    private static final double RATE_ABOVE = 0.4;

    @Override
    public double compute(double amount) {
        double rate = amount < THRESHOLD ? RATE_BELOW : RATE_ABOVE;
        return Math.max(0, amount - THRESHOLD) * rate;
    }
}
