import java.util.Arrays;

public class Basket {
    private Product[] itemList = new Product[1];
    boolean freeMug, off30, over300, thirdFree;
    private double orderValue;
    private int i;

    public void add(Product product) {
        if (i >= itemList.length)
            itemList = Arrays.copyOf(itemList, (int) (itemList.length * 1.25) + 3);
        itemList[i++] = product;
        Arrays.sort(itemList, 0, i, Comparators.comparatorPriceNameDesc);
        orderValue += product.getDiscountPrice();
        if (product.freeMug && this.getRealValue() > 200) this.freeMug = true;
        if (product.off30) this.off30 = true;
        if (product.over300) this.over300 = true;
        if (product.thirdFree) this.thirdFree = true;
    }

    public void display() {
        for (int j = 0; j < i; j++)
            System.out.println(itemList[j]);
    }

    public void remove(Product product) {
        int j = 0;
        for (; j <= i; j++)
            if (itemList[j] == product) break;
            System.arraycopy(itemList, j + 1, itemList, j, i - j);
            i--;
            orderValue -= product.getDiscountPrice();
    }

    public double getOrderValue() { return orderValue; }
    public double getRealValue() {
        double realValue = orderValue;
        if (i == 3 && thirdFree) realValue -= itemList[2].getPrice();
        if (realValue > 300 && over300) realValue *= 0.95;
        return realValue;
    }

    public Product[] getItemList() { return Arrays.copyOfRange(itemList, 0, i); }

    @Override
    public String toString () {
        return "item count: " + i + " Order value: " + orderValue;
    }
}
