public class Cat extends Animal {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showAge(){
        System.out.println("Eta gatto:" + this.getAge());

    }

    @Override
    public int getAge() {
        return  super.getAge()*10;
    }
}
