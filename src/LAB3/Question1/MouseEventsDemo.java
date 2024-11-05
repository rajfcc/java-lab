package LAB3.Question1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseEventsDemo extends JFrame implements MouseListener {
    private JLabel statusLabel;

    public MouseEventsDemo() {
        setTitle("Mouse Events Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with white background
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.addMouseListener(this);

        // Create status label
        statusLabel = new JLabel("Move mouse or click in the window");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add components to frame
        add(panel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    // Mouse event handlers
    public void mouseClicked(MouseEvent e) {
        statusLabel.setText("Mouse Clicked at: (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mousePressed(MouseEvent e) {
        statusLabel.setText("Mouse Pressed");
    }

    public void mouseReleased(MouseEvent e) {
        statusLabel.setText("Mouse Released");
    }

    public void mouseEntered(MouseEvent e) {
        statusLabel.setText("Mouse Entered Panel");
    }

    public void mouseExited(MouseEvent e) {
        statusLabel.setText("Mouse Exited Panel");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MouseEventsDemo frame = new MouseEventsDemo();
            frame.setVisible(true);
        });
    }
}
