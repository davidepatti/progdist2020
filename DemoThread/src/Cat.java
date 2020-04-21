public class Cat implements Runnable {
    private String name;
    private int lazyness;
    private Food myfood;


    public void setMyfood(Food myfood) {
        this.myfood = myfood;
    }

    public Cat(String catname) {
        setName(catname);
        lazyness = 1000;
    }
    public void sayMiao() {
        System.out.println(getName() +"---> MIAO");
    }

    public void setLazyness(int lazyness) {
        this.lazyness = lazyness;
    }

    public int getLazyness(){
        return this.lazyness;
    }

    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("*****" + Thread.currentThread().getName());
                Thread.sleep(lazyness);
                sayMiao();
                Thread.sleep(lazyness);
                myfood.consumedBy(this);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
