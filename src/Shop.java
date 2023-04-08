import java.util.Arrays;

public class Shop {
    Product[] productList = new Product[0];
    private int i;

    public Product findMostExpensive(Product[] p) {
        return Arrays.stream(p).max(Comparators.comparatorPriceNameAsc).orElse(null);
    }

    public Product findCheapest(Product[] p) {
        return Arrays.stream(p).min(Comparators.comparatorPriceNameAsc).orElse(null);
    }
    
    public Product[] sortNameAsc(Product[] p) {
        Arrays.sort(p, Comparators.comparatorNamePriceAsc);
        return p;
    }
    public Product[] sortNameDesc(Product[] p) {
        Arrays.sort(p, Comparators.comparatorNamePriceDesc);
        return p;
    }

    public Product[] sortPriceAsc(Product[] p) {
        Arrays.sort(p, Comparators.comparatorPriceNameAsc);
        return p;
    }

    public Product[] sortPriceDesc(Product[] p) {
        Arrays.sort(p, Comparators.comparatorPriceNameDesc);
        return p;
    }
    
    public double getSum(Product[] p) {
        double sum = 0;
        for (Product product : p)
            sum += product.getPrice();
        return sum;
    }

    public void display(Product[] p) {
        for (Product product : p)
            System.out.println(product);
    }

    public Product[] mostExpensiveList(Product[] p, int n) {
        Arrays.sort(p, Comparators.comparatorPriceNameDesc);
        return Arrays.copyOfRange(p, 0, n);
    }

    public Product[] cheapestList(Product[] p, int n) {
        Arrays.sort(p, Comparators.comparatorPriceNameAsc);
        return Arrays.copyOfRange(p, 0, n);
    }

    public void add(Product product) {
        if (i >= productList.length)
            productList = Arrays.copyOf(productList, (int) (productList.length * 1.25) + 3);
        productList[i++] = product;
    }

    public void applyFreeMug(Product[] p) {
        for (Product product : p)
            product.freeMug = true;
    }

    public void off30(Product[] p) {
        for (Product product : p)
            product.off30 = true;
    }

    public void over300(Product[] p) {
        for (Product product : p)
            product.over300 = true;
    }

    public void applyThirdFree(Product[] p) {
        for (Product product : p)
            product.thirdFree = true;
    }

    public Product[] getProductList() {
        return Arrays.copyOfRange(productList, 0, i);
    }
}
