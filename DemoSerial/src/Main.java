import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Car smart = new Car();
        Car evoque = new Car();

        smart.setAutocarro(false);
        evoque.setAutocarro(true);

        smart.setNumber("SMR123");
        evoque.setNumber("EV456");

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


    }
}
