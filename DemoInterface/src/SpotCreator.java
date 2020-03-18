public class SpotCreator {
    public void showDisplay(Advertisable product) {
        System.out.println("***************************************");
        System.out.println("=======================================");
        System.out.println(" BUY    "+product.getLogo()+ " !!!");
        System.out.println("=======================================");
        System.out.println(" Because...");
        System.out.println(product.getSlogan());
        System.out.println("***************************************");

    }
}
