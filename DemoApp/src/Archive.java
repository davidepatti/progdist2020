import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Archive implements Serializable {
    ArrayList<Person> content = new ArrayList<Person>();
    String creation_date;
    String last_modification;

    public Archive(){
        creation_date = new Date().toString();
    }

    public void add(Person p) {
        System.out.println("Adding person to archive");
        content.add(p);
        Date d = new Date();
        last_modification = d.toString();
        System.out.println("Added person to archive!");
    }

    public void create() {
        content.clear();
        System.out.println("Cleared content");
        Date d = new Date();
        creation_date = d.toString();
        last_modification = null;
    }

    public void show(){
        System.out.println("----------------------------------------");
        System.out.println("Create on:"+creation_date);
        System.out.println("Last mod:"+last_modification);
        for (Person p: content) {
            System.out.println("-->"+p);
        }
        System.out.println("----------------------------------------");
    }

}
