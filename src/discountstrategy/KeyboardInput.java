package discountstrategy;

import java.util.Scanner;
/**
 *
 * @author Dan Smith
 */
public class KeyboardInput implements InputStrategy {
    Scanner keyboard = new Scanner(System.in);
    
    @Override
    public String inputProductId() {
        System.out.print("Enter Product Id: ");
        return keyboard.nextLine();
    }

    @Override
    public int inputQty() {
        System.out.print("Enter Qty: ");
        return Integer.parseInt(keyboard.nextLine());
    }

    @Override
    public String inputCustomerId() {
        System.out.print("Enter Customer Id: ");
        return keyboard.nextLine();
    }
    
}
