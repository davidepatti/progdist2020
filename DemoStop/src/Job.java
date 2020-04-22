public class Job implements Runnable {

    private boolean go = true;

    public synchronized void stop(){
        go = false;
    }

    private synchronized boolean isStopped() {
        if (go==true) return false;
        return true;
    }


    @Override
    public void run() {
        System.out.println("Starting thread...");

        while (!isStopped()) {
            System.out.println("DOIN SOMETHING IMPORTANT");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("FINISH!");
        }

    }
}
