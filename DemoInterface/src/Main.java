public class Main {

    public static void main(String[] args) {
	// write your code here
        SpotCreator sp1 = new SpotCreator();
        SpotCreator sp2 = new SpotCreator();

        BeatifulDrink drink = new BeatifulDrink();
        Tv tv = new Tv();

        sp1.showDisplay(drink);

        sp2.showDisplay(tv);


    }
}
