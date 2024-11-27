package LAB2.lab2Question2;

import java.awt.*;
import java.awt.event.*;

class LoginSystem {
    // Static credentials for testing
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password123";

    private Frame loginFrame;
    private TextField usernameField;
    private TextField passwordField;
    private Label errorLabel;

    public LoginSystem() {
        createLoginPage();
    }

    private void createLoginPage() {
        loginFrame = new Frame("Login");
        loginFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        loginFrame.setLayout(null); // Using null layout for absolute positioning
        loginFrame.setBackground(new Color(240, 240, 240));

        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Calculate center position for login panel
        int loginPanelWidth = 400;
        int loginPanelHeight = 300;
        int startX = (screenWidth - loginPanelWidth) / 2;
        int startY = (screenHeight - loginPanelHeight) / 2;

        // Create login panel
        Panel loginPanel = new Panel(null);
        loginPanel.setBounds(startX, startY, loginPanelWidth, loginPanelHeight);
        loginPanel.setBackground(Color.WHITE);

        // Add components to login panel
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font inputFont = new Font("Arial", Font.PLAIN, 14);

        Label titleLabel = new Label("User Login", Label.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(100, 20, 200, 40);

        Label usernameLabel = new Label("Username:");
        usernameLabel.setFont(labelFont);
        usernameLabel.setBounds(50, 80, 100, 30);

        usernameField = new TextField();
        usernameField.setFont(inputFont);
        usernameField.setBounds(50, 110, 300, 30);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(labelFont);
        passwordLabel.setBounds(50, 150, 100, 30);

        passwordField = new TextField();
        passwordField.setEchoChar('*');
        passwordField.setFont(inputFont);
        passwordField.setBounds(50, 180, 300, 30);

        Button loginButton = new Button("Login");
        loginButton.setFont(labelFont);
        loginButton.setBounds(150, 230, 100, 35);
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);

        errorLabel = new Label("", Label.CENTER);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(50, 270, 300, 20);

        // Add components to panel
        loginPanel.add(titleLabel);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(errorLabel);

        // Add login panel to frame
        loginFrame.add(loginPanel);

        // Add action listeners
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateLogin();
            }
        });

        // Add window listener
//        loginFrame.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });

        // Add key listener for Enter key
        KeyListener enterKeyListener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    validateLogin();
                }
            }
        };
        usernameField.addKeyListener(enterKeyListener);
        passwordField.addKeyListener(enterKeyListener);
    }

    private void validateLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            loginFrame.setVisible(false);
            showHomePage(username);
        } else {
            errorLabel.setText("Invalid username or password!");
            passwordField.setText("");
        }
    }

    private void showHomePage(String username) {
        Frame homeFrame = new Frame("Homepage");
        homeFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        homeFrame.setLayout(new BorderLayout(20, 20));
        homeFrame.setBackground(new Color(240, 240, 240));

        // Create top panel for welcome message and logout button
        Panel topPanel = new Panel(new BorderLayout());
        topPanel.setBackground(new Color(70, 130, 180));
        topPanel.setPreferredSize(new Dimension(homeFrame.getWidth(), 60));

        Label welcomeLabel = new Label("Welcome, " + username + "!", Label.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);
        topPanel.add(welcomeLabel, BorderLayout.CENTER);

//        Button logoutButton = new Button("Logout");
//        logoutButton.setBackground(new Color(220, 220, 220));
//        Panel logoutPanel = new Panel(new FlowLayout(FlowLayout.RIGHT));
//        logoutPanel.setBackground(new Color(70, 130, 180));
//        logoutPanel.add(logoutButton);
//        topPanel.add(logoutPanel, BorderLayout.EAST);

        // Create content panel
        Panel contentPanel = new Panel(new GridBagLayout());
        contentPanel.setBackground(new Color(240, 240, 240));
        Label contentLabel = new Label("Welcome to the Homepage", Label.CENTER);
        contentLabel.setFont(new Font("Arial", Font.BOLD, 24));
        contentPanel.add(contentLabel);

        // Add panels to frame
        homeFrame.add(topPanel, BorderLayout.NORTH);
        homeFrame.add(contentPanel, BorderLayout.CENTER);

        // Add action listeners
//        logoutButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                homeFrame.dispose();
//                usernameField.setText("");
//                passwordField.setText("");
//                errorLabel.setText("");
//                loginFrame.setVisible(true);
//            }
//        });

//        homeFrame.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });

        homeFrame.setVisible(true);
    }

    public void show() {
        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        LoginSystem loginSystem = new LoginSystem();
        loginSystem.show();
    }
}
