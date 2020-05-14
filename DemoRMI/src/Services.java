import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Services extends Remote {

    public String getDate() throws RemoteException;
    public String toUP(String s) throws RemoteException;
}
