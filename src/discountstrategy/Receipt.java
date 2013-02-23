package discountstrategy;

import java.text.NumberFormat;

/**
 *
 * @author Dan Smith
 */
public class Receipt {
    // There can be only one
    private static int receiptNo;
    // Not sure if this should go here
    private double tax = .055;
    
    private Customer customer;
    private LineItem[] lineItems = new LineItem[0];
    
    // Needed to lookup customer information
    FakeDatabase fakeDatabase = new FakeDatabase();
    
    public Receipt() {
        receiptNo++;
    }
    
    // Sets customer reference if it finds in "db" from Id
    public void findCustomer(String custId) {
        this.setCustomer(fakeDatabase.findCustomer(custId));
    }
    
    // Instantiates new LineItem and sends info to addToArray
    public void addLineItem(String product, int qty) {
        LineItem item = new LineItem(product, qty);
        addToArray(item);
    }
    
    // Resizes array and adds new LineItem to it
    private void addToArray(LineItem item) {
        // Makes temp array bigger than lineItems by 1
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        // Not sure what this does
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        // Sets a reference in temp array to lineItems index
        tempItems[lineItems.length] = item;
        // Sets reference pointer to newly made array
        lineItems = tempItems;
    }
    
    // Not sure if this should go here
    public double getGrandTotal() {
        double gTotal = 0;
        for(LineItem li : lineItems) {
            gTotal += li.getPriceBeforeDiscount();
        }
        return gTotal;
    }
    
    public double getSubTotal() {
        double sTotal = 0;
        for(LineItem li : lineItems) {
            sTotal += li.getDiscountedPrice();
        }
        return sTotal;
    }
    // Not sure if this should go here
    public double getDiscountedTotal() {
        double dTotal = 0;
        for(LineItem li : lineItems) {
            dTotal += li.getDiscountedPrice();
        }
        return dTotal;
    }
    
    // Not sure if this should go here
    public double getAmountSaved() {
        return this.getGrandTotal() - this.getDiscountedTotal();
    }
    
    // Not sure if this should go here
    public double getTaxTotal() {
        return this.getGrandTotal() * tax;
    }
    
    // Seperate class?
    public String getFinalizedSale() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String finalString = "\nThank you for shopping at Kohl's\n\n" +
                "Customer name: " + customer.getName() + "\n" +
                "Receipt Number: " + receiptNo + "\n\n" +
                getHeader();
        for(LineItem li : lineItems) { 
            finalString += li.getLineItemDetails();
        }
        finalString += "\n\n" + String.format("%57s %7s", "Subtotal: ", 
                nf.format(this.getSubTotal()));
        finalString += "\n" + String.format("%57s %7s", "Tax: ", 
                nf.format(this.getTaxTotal()));
        finalString += "\n" + String.format("%65s", "-------------");
        finalString += "\n" + String.format("%57s %7s", "Total Due: ", 
                nf.format(this.getDiscountedTotal() + this.getTaxTotal()));
        finalString += "\n\n" + String.format("%57s %7s", "You Saved: ",
                nf.format(this.getAmountSaved()));
        
        return finalString;
    }
    
    // Seperate class?
    public String getHeader() {
        String header = String.format("%-8s %-18s %8s %8s %10s %8s",
                "Id", "Description", "Qty", "Price", "Discount", "Total") + "\n";
        header += "---------------------------------------------------------" +
                "--------\n";
        return header;
    }
    
    public void setCustomerName(String custName) {
        customer.setName(custName);
    }
    
    public void setCustomerId(String custId) {
        customer.setCustId(custId);
    }
    
    public String getCustomerName() {
        return customer.getName();
    }
    
    public String getCustomerId() {
        return customer.getCustId();
    }
    
    public void setCustomer(Customer c) {
        this.customer = c;
    }

    public static int getReceiptNo() {
        return receiptNo;
    }

    public static void setReceiptNo(int receiptNo) {
        Receipt.receiptNo = receiptNo;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    
    public static void main(String[] args) {
        Receipt r = new Receipt();
        r.findCustomer("100");
        r.addLineItem("A101", 2);
        r.addLineItem("B205", 2);
        System.out.println(r.getFinalizedSale());
    }
}
