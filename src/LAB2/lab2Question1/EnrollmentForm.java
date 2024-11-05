package LAB2.lab2Question1;

//Create a student enrollment form and render user input details in the confirmation page upon form submit for verification.
import java.awt.*;
import java.awt.event.*;

class EnrollmentForm extends Frame {
    private TextField nameField, ageField;
    private Choice genderChoice, courseChoice;
    private Button submitButton, resetButton;

    public EnrollmentForm() {
        setTitle("Student Enrollment Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 20));
        setBackground(Color.lightGray);

        // Initialize components
        Label nameLabel = new Label("Full Name:");
        nameField = new TextField();

        Label ageLabel = new Label("Age:");
        ageField = new TextField();

        Label genderLabel = new Label("Gender:");
        genderChoice = new Choice();
        genderChoice.add("Male");
        genderChoice.add("Female");
        genderChoice.add("Other");

        Label courseLabel = new Label("Course:");
        courseChoice = new Choice();
        courseChoice.add("Computer Science");
        courseChoice.add("Information Technology");
        courseChoice.add("Electronics");
        courseChoice.add("Mechanical");
        courseChoice.add("Civil");

        submitButton = new Button("Submit");
        resetButton = new Button("Reset");

        // Add components to frame
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(genderLabel);
        add(genderChoice);
        add(courseLabel);
        add(courseChoice);
        add(submitButton);
        add(resetButton);

        // Window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        // Submit button handler
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showConfirmationDialog();
            }
        });

        // Reset button handler
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                ageField.setText("");
                genderChoice.select(0);
                courseChoice.select(0);
            }
        });
    }

    private void showConfirmationDialog() {
        Dialog confirmDialog = new Dialog(this, "Enrollment Details", true);
        confirmDialog.setLayout(new FlowLayout());
        confirmDialog.setSize(300, 200);

        String details = "Name: " + nameField.getText() + "\n" +
                "Age: " + ageField.getText() + "\n" +
                "Gender: " + genderChoice.getSelectedItem() + "\n" +
                "Course: " + courseChoice.getSelectedItem();

        TextArea detailsArea = new TextArea(details, 5, 30);
        detailsArea.setEditable(false);

        Button okButton = new Button("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmDialog.dispose();
                showSuccessPage();
            }
        });

        confirmDialog.add(detailsArea);
        confirmDialog.add(okButton);
        confirmDialog.setLocationRelativeTo(this);
        confirmDialog.setVisible(true);
    }

    private void showSuccessPage() {
        // Create a new frame for success page
        Frame successFrame = new Frame("Enrollment Success");
        successFrame.setSize(400, 300);
        successFrame.setLayout(new BorderLayout(20, 20));
        successFrame.setBackground(new Color(230, 255, 230)); // Light green background

        // Success message panel
        Panel messagePanel = new Panel(new GridLayout(3, 1, 10, 10));
        messagePanel.setBackground(new Color(230, 255, 230));

        Label successLabel = new Label("Enrollment Successful!", Label.CENTER);
        successLabel.setFont(new Font("Arial", Font.BOLD, 20));

        Label nameLabel = new Label("Welcome, " + nameField.getText() + "!", Label.CENTER);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        Label courseLabel = new Label("You are enrolled in " + courseChoice.getSelectedItem(), Label.CENTER);
        courseLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        messagePanel.add(successLabel);
        messagePanel.add(nameLabel);
        messagePanel.add(courseLabel);

        // Button panel
        Panel buttonPanel = new Panel(new FlowLayout());
        buttonPanel.setBackground(new Color(230, 255, 230));

        Button closeButton = new Button("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                successFrame.dispose();
                dispose(); // Close the main form too
                System.exit(0);
            }
        });

        buttonPanel.add(closeButton);

        // Add panels to frame
        successFrame.add(messagePanel, BorderLayout.CENTER);
        successFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Window closing event for success frame
        successFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                successFrame.dispose();
                dispose(); // Close the main form too
                System.exit(0);
            }
        });

        // Hide the original form
        this.setVisible(false);

        // Center and show success frame
        successFrame.setLocationRelativeTo(null);
        successFrame.setVisible(true);
    }

    public static void main(String[] args) {
        EnrollmentForm form = new EnrollmentForm();
        form.setVisible(true);
    }
}