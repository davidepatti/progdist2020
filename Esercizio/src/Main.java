public class Main {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A a2 = new C();

        System.out.println("test1 ----------------");
        b.m1();
        c.m2();
        a.m3();
        System.out.println("test2 ----------------");
        c.m1();
        c.m2();
        c.m3();
        System.out.println("test3 ----------------");

        a.m1();
        b.m2();
        c.m3();
        System.out.println("test4 ----------------");
        a2.m1();
        a2.m2();
        a2.m3();
    }
}
