import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
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

            System.out.println("Converted to up:"+server.toUP("ciao!"));

            boolean go = true;
            Scanner user_input = new Scanner(System.in);
            while (go) {
                System.out.println("--------------------------------");
                System.out.println(" 0 - add person");
                System.out.println(" 1 - list ");
                System.out.println(" 2 - quit");
                System.out.println(" 3 - BIG complex computation");
                System.out.println("--------------------------------");
                System.out.print(" choice:");
                int choice = user_input.nextInt();

                switch (choice) {
                    case 0:
                        System.out.print("Name:");
                        String name = user_input.next();
                        System.out.print("Age:");
                        int age = user_input.nextInt();
                        Person x = new Person(name,age);
                        server.addPerson(x);
                        break;
                    case 1:
                        ArrayList<Person> mylist = server.getList();
                        System.out.println("Received list->");
                        System.out.println(mylist);
                        break;
                    case 2:
                        go = false;
                        System.out.println("Quitting client");
                        break;
                    case 3:
                        server.doIntensiveTask();
                        break;

                }

            }

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
