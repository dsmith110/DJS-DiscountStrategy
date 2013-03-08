package discountstrategy;

import java.util.*;
/**
 * Class simulates a database with methods to locate and return information
 * about customers and products. It also has methods to "query" for information
 * based on customer Id and product Id.
 * @author Dan Smith
 * @version 1.00
 */
public class FakeDatabase  {
    // Trying out Maps
    private Map custMap = new HashMap();
    private Map prodMap = new HashMap();
    
    private Customer[] customers = {
        new Customer("100", "John Smith"),
        new Customer("200", "Sally Jones"),
        new Customer("300", "Bob Clementi")
    };
    
    Product[] products = {
        new Product("A101", "Baseball Hat", 19.95, new VariableRateDiscount(0.30)),
        new Product("B205", "Men's Dress Shirt", 35.50, new QtyVariableRateDiscount(.10, 2)),
        new Product("C222", "Women's Socks", 9.50, new NoDiscount())
    };

    public FakeDatabase() {
        for(Product p : products) {
            prodMap.put(p.getProdId(), p);
        }
        for(Customer c : customers) {
            custMap.put(c.getCustId(), c);
        }
    }
    /**
     * Accepts a customer Id string as an argument and "queries" the database.
     * If the customer is found it returns information about that customer.
     * @param custId - Must be a valid string
     * @return - assigns customer information and returns a customer object.
     */
    public final Customer findCustomer(final String custId) {
        // validation is needed
        Customer customer = null;
//        for (Customer c : customers) {
//            if (custId.equals(c.getCustId())) {
//                customer = c;
//                break;
//            }
//        }
        customer = (Customer)custMap.get(custId);

        return customer;
    }

    /**
     * Accepts a customer Id string as an argument and "queries" the database.
     * If the customer is found it returns information about that customer.
     * @param prodId - Must be a valid string
     * @return - assigns product information and returns a product object.
     */
    public final Product findProduct(final String prodId) {
        // validation is needed
        Product product = null;
//        for (Product p : products) {
//            if (prodId.equals(p.getProdId())) {
//                product = p;
//                break;
//            }
//        }
        product = (Product)prodMap.get(prodId);

        return product;
    }
}
