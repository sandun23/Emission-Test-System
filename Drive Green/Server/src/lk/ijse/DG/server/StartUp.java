package lk.ijse.DG.server;



import lk.ijse.DG.service.impl.ServiceFactoryImpl;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartUp {
        public static void main(String[] args) throws Exception {

            Registry registry = LocateRegistry.createRegistry(5050);
            registry.rebind("drive", ServiceFactoryImpl.getInstance());
            System.out.println("Hey there good to go..");

        }
    }
