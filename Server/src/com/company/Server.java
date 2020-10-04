package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;   // Socket read stream
    private static BufferedWriter out;  // Socket write stream


    public static void init_server() {
        try {
            try  {
                server = new ServerSocket(9001);
                System.out.println("Server started listening");
                clientSocket = server.accept();

                try {
                    // Recieve messages
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    // Send messages
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String client_message = in.readLine();
                    System.out.println(client_message);

                    // Write answer to client
                    out.write("OK");
                    out.newLine();
                    out.flush();

                } finally {
                    // Closing socket
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Server closed");
                server.close();
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
