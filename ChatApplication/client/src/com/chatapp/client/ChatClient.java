package com.chatapp.client;

import java.io.*;
import java.net.Socket;
import com.chatapp.client.ui.MessagePanel;

public class ChatClient {

    private String serverIp;
    private int port;
    private String username;
    private MessagePanel messagePanel;

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ChatClient(String serverIp, int port, String username, MessagePanel panel) {
        this.serverIp = serverIp;
        this.port = port;
        this.username = username;
        this.messagePanel = panel;
    }

    public void start() {
        try {
            socket = new Socket(serverIp, port);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println(username);

            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        messagePanel.addMessage(msg);
                    }
                } catch (IOException e) {
                    messagePanel.addMessage("⚠ Disconnected from server");
                }
            }).start();

        } catch (IOException e) {
            messagePanel.addMessage("❌ Unable to connect");
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
