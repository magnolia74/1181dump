public class necessaryProduct extends Product {

    public necessaryProduct(String name, double price) {
        super(name, price);
    }

    public double getTotalPrice() {
        return super.getPrice();
    }
}