package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class Startup {
    
    public static void main(String[] args) {
        CashRegister cr = new CashRegister();
        cr.startNewSale("100");
        cr.addItemToSale("A101", 4);
        cr.addItemToSale("C222", 2);
        cr.addItemToSale("B205", 2);
        System.out.println(cr.finalizeSale());
    }
    
}
