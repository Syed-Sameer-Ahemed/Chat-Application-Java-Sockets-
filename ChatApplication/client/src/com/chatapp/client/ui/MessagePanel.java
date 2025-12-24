package com.chatapp.client.ui;

import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {

    private JTextArea textArea;

    public MessagePanel() {
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addMessage(String message) {
        textArea.append(message + "\n");
    }
}
