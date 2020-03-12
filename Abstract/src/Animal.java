
public abstract class Animal {

    private String name;
    private int size;
    public void sleep(){
        System.out.println("ZZZzzzzzZZZzzzz");
    }

    public void roam(){
        System.out.println("generic roaming....");
    }

    public void setName(String n) {
        this.name =n;
    }

    public void setSize(int n) {
        this.size = n;
    }

    /*
    public void makeNoise(){
        // what's the problem in leaving this empty?

    }
     */

    public abstract void makeNoise();

}
