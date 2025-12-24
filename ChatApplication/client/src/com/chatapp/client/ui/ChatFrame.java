package com.chatapp.client.ui;

import javax.swing.*;
import java.awt.*;
import com.chatapp.client.ChatClient;

public class ChatFrame extends JFrame {

    private MessagePanel messagePanel;
    private JTextField inputField;
    private ChatClient client;

    public ChatFrame(String username) {
        setTitle("Chat - " + username);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        messagePanel = new MessagePanel();
        inputField = new JTextField();
        JButton sendButton = new JButton("Send");

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(messagePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        client = new ChatClient("localhost", 5000, username, messagePanel);
        client.start();

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void sendMessage() {
        String msg = inputField.getText().trim();
        if (!msg.isEmpty()) {
            client.sendMessage(msg);
            inputField.setText("");
        }
    }
}
