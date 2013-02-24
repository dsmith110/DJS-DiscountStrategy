package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class Startup {
    
    public static void main(String[] args) {
        CashRegister cr1 = new CashRegister();
//        cr.setInputStrategy(new KeyboardInput());
//        cr.setOutputStrategy(new ConsoleOutput());
        cr1.startNewSale("100");
        cr1.addItemToSale("B205", 2);
        cr1.addItemToSale("A101", 1);
        cr1.addItemToSale("C222", 1);
        cr1.outputReceipt();
        
        CashRegister cr2 = new CashRegister();
        cr2.startNewSale("200");
        cr2.addItemToSale("A101", 1);
        cr2.outputReceipt();
    }
    
}
