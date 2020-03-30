/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JTextField;
import models.Calculator;

/**
 *
 * @author davido
 */
public class BaseListener {

    JTextField input;
    JTextField output;
    Calculator calculator;
    JButton zeroButton;
    
    public BaseListener(JTextField input, JTextField output, Calculator calculator, JButton zero) {
        this.input = input;
        this.output = output;
        this.calculator = calculator;
        this.zeroButton = zero;
    }

    public int getInputValue() {
        try {
            return Integer.parseInt(this.input.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public void update() {
        this.input.setText("");
        int val = this.calculator.getValue();
        this.output.setText(String.format("%d", val));
        if (val == 0) {
            zeroButton.setEnabled(false);
        }
        else {
            zeroButton.setEnabled(true);
        }
    }
}
