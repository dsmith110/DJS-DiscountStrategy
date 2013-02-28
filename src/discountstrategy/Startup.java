package discountstrategy;

/**
 *
 * @author Dan Smith
 * @version 1.00
 */
public class Startup {
    
    public static void main(String[] args) {
        CashRegister cr1 = new CashRegister();
//        cr1.setInputStrategy(new KeyboardInput());
//        cr1.setOutputStrategy(new ConsoleOutput());
        cr1.startNewSale("100");
        cr1.addItemToSale("B205", 2);
        cr1.addItemToSale("A101", 1);
        cr1.addItemToSale("C222", 1);
        cr1.outputReceipt();

        CashRegister cr2 = new CashRegister();
//        cr2.setOutputStrategy(new ConsoleOutput());
//        cr2.setInputStrategy(new KeyboardInput());
        cr2.startNewSale("300");
        cr2.addItemToSale("A101", 1);
        cr2.outputReceipt();
    }
    
}
