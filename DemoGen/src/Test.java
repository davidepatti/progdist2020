public class Test<T extends Number> {

    T x;

    public Test(T t) {
        this.x = t;
    }

    public T getX() {
        return x;
    }
}
