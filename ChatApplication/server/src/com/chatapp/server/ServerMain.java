package com.chatapp.server;

public class ServerMain {
    public static void main(String[] args) {
        int port = 5000; // Server port
        ChatServer server = new ChatServer(port);
        server.startServer();
    }
}
