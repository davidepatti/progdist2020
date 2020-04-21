public class Food {

    int amount = 1000000;

    public synchronized void consumedBy(Cat c) {
        System.out.println("The cat "+c.getName()+ " is going to eat, amount found:"+amount );
        try {
            amount = amount-100;
            Thread.sleep(c.getLazyness());
            System.out.println("The cat "+c.getName()+ " has finished, amount final:"+amount );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void add(int x) {
        System.out.println("ADDING: Current amount "+amount);
        System.out.println("ADDING "+x);
        amount = amount+x;
        System.out.println("END ADDING: Current amount "+amount);
    }
}
