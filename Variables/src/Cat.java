public class Cat {
    private String name;
    private int remaining_lives;

    public void talk(){
        System.out.println("Miaooo, mi rimangono  "+ getRemaining_lives() + " vite..");
    }

    public void die(){
        setRemaining_lives(getRemaining_lives() - 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRemaining_lives() {
        return remaining_lives;
    }

    public void setRemaining_lives(int remaining_lives) {
        if (remaining_lives<1) {
            System.out.println("invalid value!");
        }
        else {
            this.remaining_lives = remaining_lives;
        }
    }
}
