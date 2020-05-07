import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Date;

public class PersonList {
    // wrapping an arraylist into a custom class
    // (1) manage and syncronize access to list
    // (2) add other meta-data (creation, modification date)

    String archive_id;
    String last_modification;
    private ArrayList<Person> list;
    public PersonList() {
        list = new ArrayList<Person>();
    }

    // could also return a boolean to check the validity...
    public synchronized void add(Person p) {
        last_modification = new Date().toString();
        list.add(p);
    }

    /* this would cancel any benefic of sync and private accesss to list
    public ArrayList<Person> getList() {
        return list;
    }
    */

    public ArrayList<Person> getListCopy() {
        ArrayList<Person> a_list = new ArrayList<>();
        a_list.addAll(list);
        return a_list;
    }


    // other solution, use this in ClientManager:
    // pw.println(list);
    @Override
    public String toString() {
        String s;
        s = "BEGIN_LIST";
        s = s+" MOD_DATE: "+last_modification;
        for (Person p : list) {
            s = s+" NAME: "+p.getName();
            s = s+" SURNAME: "+p.getSurname();
            s = s+" AGE: "+p.getAge();
        }
        s = s + "END_LIST";

        return s;
    }
}
