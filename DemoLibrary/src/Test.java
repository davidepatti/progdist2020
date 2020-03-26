import java.util.ArrayList;
import java.lang.Math;

public class Test {
    public static void main(String[] args) {
        // write your code here

        // why can't do this?
        //Utilita u = new Utilita();

        System.out.println("Time in millis: "+Utilita.tellMeTime());

        Duck d1 = new Duck();
        Duck d2 = new Duck();
        Duck d3 = new Duck();

        System.out.println("getcount: "+d1.getCount());

        String n = String.valueOf(44);

        Integer x = 5;

        String b = Integer.toBinaryString(240);

        System.out.println(b);




        Duck.getHello();
        // why the following doesn't work?
        // d1.getHello();

        // why is it possible the following?
        Test t = new Test();

        System.out.println(Math.atan(2.444));

        var lista = new ArrayList<String>();
        var listainteri = new ArrayList<Integer>();

        lista.add("pippo");
        String s = "ciao";
        lista.add(s);

        System.out.println(lista);
        lista.add(1, "intruso");
        System.out.println(lista);
        //lista.clear();
        System.out.println(lista);

        if (lista.contains("ciao")) {
            System.out.println("contiene ciao");
        }

        int i = 30;
        String prova = String.format("ciao %2.3f fine",2.43434);
        System.out.println(prova);

        Integer io;
        listainteri.add(45);

    }
}
