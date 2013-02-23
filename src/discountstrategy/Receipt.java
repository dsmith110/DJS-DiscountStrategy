package discountstrategy;

import java.text.NumberFormat;

/**
 *
 * @author Dan Smith
 */
public class Receipt {
    private static int receiptNo;
    private double tax = .055;
    private Customer customer;
    private LineItem[] lineItems = new LineItem[0];
    FakeDatabase fakeDatabase = new FakeDatabase();
    
    public Receipt() {
        receiptNo++;
    }
    
    public void findCustomer(String custId) {
        this.setCustomer(fakeDatabase.findCustomer(custId));
    }
    
    public void addLineItem(String product, int qty) {
        LineItem item = new LineItem(product, qty);
        addToArray(item);
    }
    
    private void addToArray(LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }
    
    public double getGrandTotal() {
        double gTotal = 0;
        for(LineItem li : lineItems) {
            gTotal += li.getPriceBeforeDiscount();
        }
        return gTotal;
    }
    
    public double getDiscountedTotal() {
        double dTotal = 0;
        for(LineItem li : lineItems) {
            dTotal += li.getDiscountedPrice();
        }
        return dTotal + this.getTaxTotal();
    }
    
    public double getAmountSaved() {
        double amtSaved = 0;
        for(LineItem li : lineItems) {
            amtSaved += li.getDiscountAmt();
        }
        return amtSaved;
    }
    
    public double getTaxTotal() {
        return this.getGrandTotal() * tax;
    }
    
    public String getFinalizedSale() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String finalString = "Thank you for shopping at Kohl's\n\n" +
                "Customer name: " + customer.getName() + "\n" +
                "Receipt Number: " + receiptNo + "\n\n" +
                getHeader();
        for(LineItem li : lineItems) { 
            finalString += li.getLineItemDetails();
        }
        finalString += "\n\n" + String.format("%57s %7s", "Subtotal: ", 
                nf.format(this.getGrandTotal()));
        finalString += "\n" + String.format("%57s %7s", "Tax: ", 
                nf.format(this.getTaxTotal()));
        finalString += "\n" + String.format("%65s", "-------------");
        finalString += "\n" + String.format("%57s %7s", "Total Due: ", 
                nf.format(this.getDiscountedTotal()));
        finalString += "\n\n" + String.format("%57s %7s", "You Saved: ",
                nf.format(this.getAmountSaved()));
        
        return finalString;
    }
    
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
