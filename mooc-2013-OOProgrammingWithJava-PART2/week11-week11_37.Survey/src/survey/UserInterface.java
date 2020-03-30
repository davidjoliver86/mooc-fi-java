package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    private void createComponents(Container contentPane) {
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        JLabel areYou = new JLabel("Are you?");
        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");

        JLabel why = new JLabel("Why?");

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton noReason = new JRadioButton("No reason.");
        JRadioButton becauseItsFun = new JRadioButton("Because it is fun!");
        buttonGroup.add(noReason);
        buttonGroup.add(becauseItsFun);

        JButton done = new JButton("Done!");

        contentPane.add(areYou);
        contentPane.add(yes);
        contentPane.add(no);
        contentPane.add(why);
        contentPane.add(noReason);
        contentPane.add(becauseItsFun);
        contentPane.add(done);
    }
}
