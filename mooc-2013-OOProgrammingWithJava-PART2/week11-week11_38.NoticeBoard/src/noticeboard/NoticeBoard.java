package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3, 1));
        JTextField textField = new JTextField();
        JButton button = new JButton("Copy!");
        JLabel label = new JLabel();

        ActionEventListener listener = new ActionEventListener(textField, label);
        button.addActionListener(listener);

        container.add(textField);
        container.add(button);
        container.add(label);
    }
}
