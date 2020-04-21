public class Dog implements Runnable{
    Thread t;

    public Dog(){
        t = new Thread(this);
    }

    public void  startMyDog(){
        System.out.println("starting dog thread....");
        t.start();
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("BAU!!");
    }
}
