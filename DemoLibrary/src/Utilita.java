import java.util.Calendar;

public class Utilita {

    private Utilita() {
        System.out.println("Non parlo...");

    }
    public static long tellMeTime() {
        var c = Calendar.getInstance();
        return c.getTimeInMillis();

    }
}
