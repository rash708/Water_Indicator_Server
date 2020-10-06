package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader command_reader;   // Reads commands from terminal
    private static BufferedReader in;               // Socket read stream
    private static BufferedWriter out;              // Socket write stream


    public static void init_server() {
        try {
            try  {
                server = new ServerSocket(9001);
                System.out.println("Server started listening");
                clientSocket = server.accept();
                try {
                    command_reader = new BufferedReader(new InputStreamReader(System.in));

                    // Recieve messages
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    // Send messages
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    // Send server command
                    String command = command_reader.readLine();
                    out.write(command);
                    out.newLine();
                    out.flush();

                    // Read indications recieved from client
                    String client_message = in.readLine();
                    System.out.println(client_message);

                } finally {
                    // Closing socket
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                server.close();
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
