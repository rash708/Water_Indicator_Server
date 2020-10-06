package com.company;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static final String UNIQUE_BINDING_NAME = "client.waterIndicator";

    public static void init_server() throws RemoteException, NotBoundException {
        final Registry registry = LocateRegistry.getRegistry(9001);

        IWaterIndicator waterIndicator = (IWaterIndicator) registry.lookup(UNIQUE_BINDING_NAME);

        String waterIndication = waterIndicator.getWaterIndications();

        System.out.println(waterIndication);
    }
}
