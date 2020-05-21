
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerInterface {

    @Override
    public double getSum(double a, double b) throws RemoteException{
        return a+b;
    }

    public Server() throws RemoteException {
        // if not local, specify YOUR PORT avoid random assignation
        super(7500);
    }

    public static void main(String[] args){
        try {
            // if not localhost
            System.setProperty("java.rmi.server.hostname","whitelodge.ns0.it");
            Registry registry = LocateRegistry.getRegistry();


            ServerInterface server = new Server();
           // Naming.rebind("calculator",server);
            registry.bind("calculator",server);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
