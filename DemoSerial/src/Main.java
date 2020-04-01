import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Car smart = new Car();
        Car evoque = new Car();
/*
        smart.setAutocarro(false);
        evoque.setAutocarro(true);

        smart.setNumber("SMR123");
        evoque.setNumber("EV456");

        smart.setProducer("Mercedes");
        evoque.setProducer("Land Rover");

        try {
            var fos = new FileOutputStream("cars.ser");
            var os = new ObjectOutputStream(fos);

            os.writeObject(smart);
            os.writeObject(evoque);;
            os.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

*/
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("cars.ser"));

            smart = (Car)is.readObject();
            evoque = (Car)is.readObject();
            is.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("cars:");
        System.out.println(smart);
        System.out.println(evoque);
    }
}
