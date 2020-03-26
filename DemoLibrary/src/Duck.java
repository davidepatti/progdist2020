public class Duck {
    private static int count = 0;

    public Duck(){
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void getHello() {
        System.out.println("Quack Hello!");
    }
}
