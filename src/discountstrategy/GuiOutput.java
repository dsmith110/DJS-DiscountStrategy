package discountstrategy;

import javax.swing.JOptionPane;

/**
 * Class that outputs receipt information in a GUI.
 * TESTING
 * @author Dan Smith
 * @version 1.00
 */
public class GuiOutput implements OutputStrategy {

    @Override
    public void outputReceipt(String receipt) {
        JOptionPane.showMessageDialog(null, receipt);
    }
    
}
