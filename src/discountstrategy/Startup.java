package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class Startup {
    
    public static void main(String[] args) {
        CashRegister cr = new CashRegister();
//        cr.setInputStrategy(new KeyboardInput());
//        cr.setOutputStrategy(new ConsoleOutput());
        cr.startNewSale("100");
        cr.addItemToSale("B205", 2);
        cr.addItemToSale("A101", 1);
        cr.addItemToSale("C222", 1);
        cr.outputReceipt();
    }
    
}
