package discountstrategy;

import java.text.NumberFormat;

/**
 * Class formats information for the receipt that will output to a monitor.
 * It implements a FormatStrategy interface that must override those methods.
 * @author Dan Smith
 * @version 1.00
 */
public class FormatForMonitor implements FormatStrategy{
    
    private String getHeader() {
        String header = String.format("%-8s %-18s %8s %8s %10s %8s",
                "Id", "Description", "Qty", "Price", "Discount", "Total") + "\n";
        header += "---------------------------------------------------------"
                + "--------\n";
        return header;
    }

    /**
     * Accepts a receipt object as an argument and optimizes the output for
     * a monitor.
     * @param receipt - Cannot be null
     * @return - Formatted receipt
     */
    @Override
    public String getFormattedData(Receipt receipt) {
        // Needs validation
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String finalString = "\nThank you for shopping at Kohl's\n\n"
                + "Customer name: " + receipt.getCustomer().getName() + "\n"
                + "Receipt Number: " + receipt.getReceiptNo() + "\n"
                + "Date: " + receipt.getFormattedDate() + "\n\n"
                + getHeader();
        for (LineItem li : receipt.getLineItems()) {
            // Used for padding (makes outputs nice)
            finalString += String.format("%-8s %-18s %8s %8s %10s %8s",
                    li.getProductId(),
                    li.getProductName(),
                    li.getQty(),
                    nf.format(li.getPriceBeforeDiscount()),
                    nf.format(li.getDiscountAmt()),
                    nf.format(li.getDiscountedPrice())) + "\n";
        }
        finalString += "\n\n" + String.format("%57s %7s", "Subtotal: ",
                nf.format(receipt.getSubTotal()));
        finalString += "\n" + String.format("%57s %7s", "Tax: ",
                nf.format(receipt.getTaxTotal()));
        finalString += "\n" + String.format("%65s", "-------------");
        finalString += "\n" + String.format("%57s %7s", "Total Due: ",
                nf.format(receipt.getDiscountedTotal() + receipt.getTaxTotal()));
        finalString += "\n\n" + String.format("%57s %7s", "You Saved: ",
                nf.format(receipt.getAmountSaved()));

        return finalString;
    }
    
}
