package discountstrategy;

import java.text.NumberFormat;
import java.util.Date;

/**
 *
 * @author Dan Smith
 */
public class FormatForMonitor implements FormatStrategy{
    
    public String getHeader() {
        String header = String.format("%-8s %-18s %8s %8s %10s %8s",
                "Id", "Description", "Qty", "Price", "Discount", "Total") + "\n";
        header += "---------------------------------------------------------"
                + "--------\n";
        return header;
    }

    @Override
    public String getFormattedData(LineItem[] lineItems, Customer customer, int receiptNo, Receipt receipt) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String finalString = "\nThank you for shopping at Kohl's\n\n"
                + "Customer name: " + customer.getName() + "\n"
                + "Receipt Number: " + receiptNo + "\n"
                + "Date: " + new Date().toString() + "\n\n"
                + getHeader();
        for (LineItem li : lineItems) {
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
