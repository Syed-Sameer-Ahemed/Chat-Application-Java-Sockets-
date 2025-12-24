package com.chatapp.client;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter server IP (localhost for same machine): ");
        String serverIp = scanner.nextLine();

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        ChatClient client = new ChatClient(serverIp, 5000, username);
        client.start();

        scanner.close();
    }
}
