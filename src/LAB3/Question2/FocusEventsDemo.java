package LAB3.Question2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusEventsDemo extends JFrame {
    private JTextField textField1, textField2;
    private JLabel statusLabel;

    public FocusEventsDemo() {
        setTitle("Focus Events Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel for components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create components
        textField1 = new JTextField();
        textField2 = new JTextField();
        statusLabel = new JLabel("Click in different text fields to see focus events");

        // Add focus listeners
        FocusListener focusListener = new FocusListener() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField) e.getComponent();
                source.setBackground(Color.YELLOW);
                statusLabel.setText("Focus gained in " +
                        (source == textField1 ? "Field 1" : "Field 2"));
            }

            public void focusLost(FocusEvent e) {
                JTextField source = (JTextField) e.getComponent();
                source.setBackground(Color.WHITE);
                statusLabel.setText("Focus lost from " +
                        (source == textField1 ? "Field 1" : "Field 2"));
            }
        };

        // Add listeners to text fields
        textField1.addFocusListener(focusListener);
        textField2.addFocusListener(focusListener);

        // Add components to panel
        panel.add(new JLabel("Field 1:"));
        panel.add(textField1);
        panel.add(new JLabel("Field 2:"));
        panel.add(textField2);

        // Add components to frame
        add(panel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FocusEventsDemo frame = new FocusEventsDemo();
            frame.setVisible(true);
        });
    }
}
