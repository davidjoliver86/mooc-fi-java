/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import models.Calculator;

/**
 *
 * @author davido
 */
public class Adder extends BaseListener implements ActionListener {
    
    public Adder(JTextField input, JTextField output, Calculator calculator, JButton zero) {
        super(input, output, calculator, zero);
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.calculator.add(getInputValue());
        this.update();
    }
    
}
