package com.company;
import com.company.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Server server_socket = new Server();
        server_socket.init_server();
    }
}
