import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        // usual stuff here... menu, etc...

        String address = args[0];
        String rmi_name = args[1];

        try {
            Services server = (Services) Naming.lookup("rmi://"+address+"/"+rmi_name);

            System.out.println("L'ora attuale e': ");
            System.out.println(server.getDate());

            Scanner s = new Scanner(System.in);
            String line = s.nextLine();

            System.out.println("Converted to up:"+server.toUP(line));

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
