
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import listeners.Adder;
import listeners.Subtractor;
import listeners.Zeroer;
import models.Calculator;

public class GraphicCalculator implements Runnable {

    private JFrame frame;
    private Calculator calculator;
   
    public GraphicCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 150));
        createComponents(frame);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3, 1));
        
        JTextField output = new JTextField("0");
        output.setEnabled(false);
        container.add(output);
        
        JTextField input = new JTextField("0");
        container.add(input);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        
        JButton add = new JButton("+");
        JButton subtract = new JButton("-");
        JButton zero = new JButton("Z");
        zero.setEnabled(false);
        
        add.addActionListener(new Adder(input, output, calculator, zero));
        subtract.addActionListener(new Subtractor(input, output, calculator, zero));
        zero.addActionListener(new Zeroer(input, output, calculator, zero));
        
        panel.add(add);
        panel.add(subtract);
        panel.add(zero);
        container.add(panel);
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
