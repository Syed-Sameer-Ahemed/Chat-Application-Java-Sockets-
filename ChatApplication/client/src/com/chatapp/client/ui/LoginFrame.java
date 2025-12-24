package com.chatapp.client.ui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Chat Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Enter Username:", JLabel.CENTER);
        JTextField usernameField = new JTextField();
        JButton loginButton = new JButton("Join Chat");

        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            if (!username.isEmpty()) {
                dispose();
                new ChatFrame(username);
            } else {
                JOptionPane.showMessageDialog(this, "Username required!");
            }
        });

        add(label, BorderLayout.NORTH);
        add(usernameField, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ✅ MAIN METHOD (IMPORTANT)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}
