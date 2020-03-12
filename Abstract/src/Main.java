public class Main {

    public static void main(String[] args) {
        Animal c = new Cat();
        Feline f = new Cat();
        c.roam();
        f.roam();

        Animal cane = new Dog();
        Animal cane2 = new Dog();
        cane.roam();

        cane.setSize(10);
        cane2.setSize(10);

        // what happens to the object cane in memory???
        // what happen when uncommenting the line?
        //cane = cane2;

        cane.setName("vercingetorige");
        cane2.setName("vercingetorige");

        if (cane==cane2) {
            System.out.println("I cani sono uguali!");
        }
        else {
            System.out.println("I cani sono diversi");
        }

        System.out.println("hash:"+cane.hashCode());
        Class cl = cane.getClass();
        System.out.println("getclass:"+cl.getName());
        System.out.println(cane.toString());





	// write your code here
    }
}
