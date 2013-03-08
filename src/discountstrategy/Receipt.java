package discountstrategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This class holds information about receipt numbers, tax calculated from sale,
 * format string for formatting dates output on the receipt, a date property,
 * format strategy for displaying the receipt, a customer property to display 
 * customer info on receipt, and an array of line items. Class also calculates
 * grand total, subtotal, discounted total.
 * @author Dan Smith
 * @version 1.00
 */
public class Receipt {

    private static int receiptNo;
    private double tax = .055;
    private String format = "MM/dd/yyyy hh:mm a";
    
    private Date date;
    private FormatStrategy fs = new FormatForMonitor();
    private Customer customer;
    private List<LineItem> lineItems = new ArrayList<LineItem>();
//    private LineItem[] lineItems = new LineItem[0];
    
    // Needed to lookup customer information
    private FakeDatabase fakeDatabase = new FakeDatabase();
    
    /**
     * Default constructor adds one to the receipt number every time a receipt
     * is created.
     */
    public Receipt() {
        receiptNo++;
    }
    
    // Sets customer reference if it finds in "db" from Id
    public void findCustomer(String custId) {
        // Needs validation
        this.setCustomer(fakeDatabase.findCustomer(custId));
    }
    
    /**
     * Method creates a lineItem based on product and quantity arguments.
     * If the lineItem is instantiated, it then passes the item to addToArray
     * method.
     * @param product - Must be in correct format
     * @param qty - Must be greater than 0.
     */
    public void addLineItem(String product, int qty) {
        // Needs validation
        LineItem item = new LineItem(product, qty);
        addToArray(item);
    }
    
    /*
     * Private method 
     */
    private void addToArray(LineItem item) {
        // Needs validation
        lineItems.add(item);
        // Makes temp array bigger than lineItems by 1
//        LineItem[] tempItems = new LineItem[lineItems.length + 1];
//        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
//        // Adds the item to the temp array
//        tempItems[lineItems.length] = item;
//        // Sets reference pointer to newly made array
//        lineItems = tempItems;
    }
    
    /**
     * Method used to calculate grand total of all the lineItems before the 
     * discounts are applied to the products.
     * @return - grand total of all products
     */
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

    public double getDiscountedTotal() {
        double dTotal = 0;
        for(LineItem li : lineItems) {
            dTotal += li.getDiscountedPrice();
        }
        return dTotal;
    }
    
    public double getAmountSaved() {
        return this.getGrandTotal() - this.getDiscountedTotal();
    }
    
    public double getTaxTotal() {
        return this.getGrandTotal() * tax;
    }
    
    public String getFinalizedSaleString() {
        return fs.getFormattedData(this);
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

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

//    public LineItem[] getLineItems() {
//        return lineItems;
//    }
//
//    public void setLineItems(LineItem[] lineItems) {
//        this.lineItems = lineItems;
//    }
    
    public String getCustomerId() {
        return customer.getCustId();
    }
    
    public void setCustomer(Customer c) {
        // Needs validation
        this.customer = c;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public int getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        // Needs validation
        Receipt.receiptNo = receiptNo;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        // Needs validation
        this.tax = tax;
    }

    public FormatStrategy getFs() {
        return fs;
    }

    public void setFs(FormatStrategy fs) {
        // Needs validation
        this.fs = fs;
    }

    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        date = c.getTime();
        String formatedDate = sdf.format(date);
        return formatedDate;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
