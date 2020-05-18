import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class PersonList {
    private ArrayList<Person> list = new ArrayList<>();

    public void addPerson(Person p) {
        list.add(p);
    }

    public ArrayList<Person> getList() {
        //return list;
        ArrayList<Person> anotherlist = new ArrayList<>();
        for (Person p:list) {
            Person x = new Person(p.getName(),p.getAge());
            anotherlist.add(x);
        }

        return anotherlist;
    }
}
