import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TransferQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here

        Cat felix = new Cat("felix");
        Cat tom = new Cat("tom");
        Cat sylvester = new Cat("sylvester");
        Food croccantini = new Food();

        felix.setMyfood(croccantini);
        tom.setMyfood(croccantini);
        sylvester.setMyfood(croccantini);

        // the two lines below dont start anything!
        Thread t1 = new Thread(felix);
        Thread t2 = new Thread(tom);

        Thread t3 = new Thread(sylvester,sylvester.getName());

        t1.start();
        t2.start();
        t3.start();

        // other threading style: Thread object embedded inside the runnable
        Dog fido = new Dog();
        Dog pluto = new Dog();

        fido.startMyDog();
        pluto.startMyDog();



        boolean go = true;
        try {
            ServerSocket server = new ServerSocket(7500);
            Socket client = server.accept();

            while (go) {

                Scanner client_scanner = new Scanner(client.getInputStream());
                PrintWriter pw = new PrintWriter(client.getOutputStream());

                String message = client_scanner.nextLine();
                Scanner msg_scanner = new Scanner(message);

                // the first word is the catname
                String cmd = msg_scanner.next();
                // the second, is the lazyness
                int lazyness = msg_scanner.nextInt();

                if (cmd.equals("felix")) {
                    felix.setLazyness(lazyness);
                }
                else if (cmd.equals("tom")) {
                    tom.setLazyness(lazyness);
                }
                else
                {
                    System.out.println("Unknown cat "+cmd);
                    go = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
