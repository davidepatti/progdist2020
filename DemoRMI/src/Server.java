import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Server extends UnicastRemoteObject implements Services {
    protected Server() throws RemoteException {
    }

    public void Otherstuff() {
        // maybe something other is done here....
        // but it's not part of the interface, so will be not registered
        // and visible externally...
    }

    @Override
    public String getDate() throws RemoteException {
        System.out.println("SERVER LOG: invoked getDate()");
        return new Date().toString();
    }

    @Override
    public String toUP(String s) throws  RemoteException {
        System.out.println("SERVER LOG: invoked toUP()");
        return s.toUpperCase();
    }

    public static void main(String args[]) {
        try {
            Services services = new Server();
            Naming.rebind("dateandtup",services);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
