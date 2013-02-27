package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class Receipt {

    private static int receiptNo;
    private double tax = .055;
    
    private FormatStrategy fs = new FormatForMonitor();
    private Customer customer;
    private LineItem[] lineItems = new LineItem[0];
    
    // Needed to lookup customer information
    FakeDatabase fakeDatabase = new FakeDatabase();
    
    public Receipt() {
        receiptNo++;
    }
    
    // Sets customer reference if it finds in "db" from Id
    public void findCustomer(String custId) {
        // Needs validation
        this.setCustomer(fakeDatabase.findCustomer(custId));
    }
    
    // Instantiates new LineItem and sends info to addToArray
    public void addLineItem(String product, int qty) {
        // Needs validation
        LineItem item = new LineItem(product, qty);
        addToArray(item);
    }
    
    // Resizes array and adds new LineItem to it
    private void addToArray(LineItem item) {
        // Needs validation
        // Makes temp array bigger than lineItems by 1
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        // Adds the item to the temp array
        tempItems[lineItems.length] = item;
        // Sets reference pointer to newly made array
        lineItems = tempItems;
    }
    
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

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) {
        this.lineItems = lineItems;
    }
    
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
    
    

    public static int getReceiptNo() {
        return receiptNo;
    }

    public static void setReceiptNo(int receiptNo) {
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
}
