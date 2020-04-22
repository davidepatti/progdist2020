public class Test {

    public static void main(String args[]) {
        Job some_work = new Job();

        Thread t = new Thread(some_work);
        t.start();


        for (int i = 0; i < 10; i++) {
            System.out.println("I'm waiting in the main " + i);
            try {
                Thread.sleep(1000 * i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        some_work.stop();
    }
}
