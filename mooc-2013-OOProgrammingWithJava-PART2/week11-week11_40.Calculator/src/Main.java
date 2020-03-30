

import javax.swing.SwingUtilities;
import models.Calculator;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GraphicCalculator(new Calculator()));
    }
}
