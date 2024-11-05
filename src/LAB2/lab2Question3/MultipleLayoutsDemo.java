package LAB2.lab2Question3;

import javax.swing.*;
import java.awt.*;

public class MultipleLayoutsDemo extends JFrame {
    public MultipleLayoutsDemo() {
        setTitle("Multiple Layouts Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Top panel with FlowLayout
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        topPanel.setBorder(BorderFactory.createTitledBorder("FlowLayout"));
        topPanel.add(new JButton("Button 1"));
        topPanel.add(new JButton("Button 2"));
        topPanel.add(new JButton("Button 3"));

        // Center panel with GridLayout
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createTitledBorder("GridLayout"));
        centerPanel.add(new JButton("1"));
        centerPanel.add(new JButton("2"));
        centerPanel.add(new JButton("3"));
        centerPanel.add(new JButton("4"));

        // Right panel with BoxLayout
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createTitledBorder("BoxLayout"));
        rightPanel.add(new JButton("Top"));
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(new JButton("Middle"));
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(new JButton("Bottom"));

        // Bottom panel with GridBagLayout
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setBorder(BorderFactory.createTitledBorder("GridBagLayout"));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        bottomPanel.add(new JButton("Wide Button"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        bottomPanel.add(new JButton("Left"), gbc);

        gbc.gridx = 1;
        bottomPanel.add(new JButton("Right"), gbc);

        // Add all panels to main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);

        // Set frame properties
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MultipleLayoutsDemo frame = new MultipleLayoutsDemo();
            frame.setVisible(true);
        });
    }
}
