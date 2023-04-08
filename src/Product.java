public class Product {
    private String code, name;
    private double price, discountPrice;
    boolean freeMug, off30, over300, thirdFree;

    Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getDiscountPrice() { return discountPrice; }

    void SetCode(String code) { this.code = code; }
    void SetName(String name) { this.name = name; }
    void SetPrice(double price) { this.price = price; }
    void SetDiscount(double discountPrice) { this.discountPrice = discountPrice; }

    @Override
    public String toString () {
        return "Code: " + code + ", Name: " + name + ", Price: " + price + ", Discount Price: " + discountPrice;
    }
}
