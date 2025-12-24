package com.chatapp.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String username;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Read username
            username = in.readLine();
            System.out.println("👤 User connected: " + username);

            ChatServer.broadcastMessage("🟢 " + username + " joined the chat", this);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(username + ": " + message);
                ChatServer.broadcastMessage(username + ": " + message, this);
            }

        } catch (IOException e) {
            System.out.println("⚠ Client error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ChatServer.removeClient(this);
            ChatServer.broadcastMessage("🔴 " + username + " left the chat", this);
        }
    }

    // Send message to client
    void sendMessage(String message) {
        out.println(message);
    }
}
