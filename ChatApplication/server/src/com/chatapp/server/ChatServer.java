package com.chatapp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class ChatServer {

    private int port;
    protected static HashSet<ClientHandler> clients = new HashSet<>();

    public ChatServer(int port) {
        this.port = port;
    }

    public void startServer() {
        System.out.println("🔵 Chat Server started on port " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("🟢 New client connected");

                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }

        } catch (IOException e) {
            System.out.println("❌ Server error: " + e.getMessage());
        }
    }

    // Broadcast message to all clients
    protected static void broadcastMessage(String message, ClientHandler excludeUser) {
        for (ClientHandler client : clients) {
            if (client != excludeUser) {
                client.sendMessage(message);
            }
        }
    }

    // Remove disconnected client
    protected static void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        System.out.println("🔴 Client disconnected");
    }
}
