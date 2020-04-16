public class Cat implements Runnable {
    private String name;
    private int lazyness;

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

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(lazyness);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sayMiao();
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
