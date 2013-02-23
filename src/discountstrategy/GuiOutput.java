package discountstrategy;

import javax.swing.JOptionPane;
/**
 *
 * @author Dan Smith
 */
public class GuiOutput implements OutputStrategy {

    @Override
    public void outputReceipt(String receipt) {
        JOptionPane.showMessageDialog(null, receipt);
    }
    
}
