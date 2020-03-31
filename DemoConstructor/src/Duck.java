public class Duck extends Animal {
    int size;

    // what's the difference when constructor with parameter is removed?
    public Duck(int size){
        this.size = size;
        System.out.println("I'm born and I'm of size:"+size);
    }
}
