public class luxuryProduct extends Product {

    public luxuryProduct(String name, double price) {
        super(name, price);
    }

    public double getTotalPrice() {
        return super.getPrice() * 1.0575;
    }
}