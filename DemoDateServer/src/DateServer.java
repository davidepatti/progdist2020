import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    public static void main(String args[]) throws IOException {
        ServerSocket server;
        if (args.length!=1) {
            System.out.println("Usage: java DateServer <PORT_NUMBER>");
            return;
        }

        int port = Integer.parseInt(args[0]);

        System.out.println("Starting server on port " + port);
        server = new ServerSocket(port);

        while (true) {
            try {
                System.out.println("Listening on port " + port);
                Socket socket = server.accept();
                System.out.println("Accepted connection from "+socket.getRemoteSocketAddress());
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                Date d = new Date();
                String datestring = d.toString();
                System.out.println("Sending "+datestring+" to "+socket.getRemoteSocketAddress());
                // increase to simulate a time consuming process...
                Thread.sleep(100);
                System.out.println("...DONE!");
                pw.println(datestring);
                pw.flush();
                socket.close();
            } catch (IOException | InterruptedException e) {
                System.out.println("Cannot start server on port " + port);
                e.printStackTrace();
            }
        }


    }
}
