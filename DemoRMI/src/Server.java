import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

public class Server extends UnicastRemoteObject implements Services {
    PersonList person_list = new PersonList();

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

    @Override
    public ArrayList<Person> getList() throws RemoteException {
        System.out.println("LOG SERVER: invoking getList()");
        return person_list.getList();
    }

    @Override
    public void addPerson(Person p) throws RemoteException {
        System.out.println("LOG SERVER: invoking addPerson");
        person_list.addPerson(p);
    }

    @Override
    public synchronized void doIntensiveTask() throws RemoteException {
        System.out.println("Thread that invoked doIntensiveTask: "+Thread.currentThread().getName());
        System.out.println("doing something....");
        int i = 0;
        while (i<100) {
            System.out.println("completed "+i+"% ");
            i = i +10;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("COMPLETED!");

    }

    public static void main(String args[]) {
        try {
            Services services = new Server();
            Naming.rebind("listserver",services);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
