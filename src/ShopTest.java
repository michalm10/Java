import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ShopTest {
    Product product0 = new Product("0000", "udjssa", 14.47);
    Product product1 = new Product("0001", "qdcna", 4.47);
    Product product2 = new Product("0002", "sfsca", 15.47);
    Product product3 = new Product("0003", "zcosa", 24.47);
    Product product4 = new Product("0004", "bocasd", 53.47);
    Product product5 = new Product("0005", "miadosf", 32.47);
    Product product6 = new Product("0006", "ghjkas", 164.47);
    Product product7 = new Product("0007", "zcosa", 142.47);
    Product product8 = new Product("0008", "tycnja", 12.47);
    Product product9 = new Product("0009", "dicfjk", 15.47);
    Product product10 = new Product("0010", "bcusics", 90.47);
    Shop shop;

    @Before
    public void init() {
        shop = new Shop();
        shop.add(product0);
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.add(product4);
        shop.add(product5);
        shop.add(product6);
        shop.add(product7);
        shop.add(product8);
        shop.add(product9);
        shop.add(product10);
    }

    @Test
    public void DisplayTest() {
        shop.display(shop.getProductList());
    }

    @Test
    public void sortPriceAsc() {
        Product[] sorted = {product1, product8, product0, product9, product2,
                product3, product5, product4, product10, product7, product6};
                assertArrayEquals(shop.sortPriceAsc(shop.getProductList()), sorted);
    }

    @Test
    public void sortPriceDesc() {
        Product[] sorted = {product6, product7, product10, product4, product5,
                product3, product2, product9, product0, product8, product1};
              assertArrayEquals(  shop.sortPriceDesc(shop.getProductList()), sorted);
    }

    @Test
    public void sortNameAsc() {
        Product[] sorted = {product10, product4, product9, product6, product5,
                product1, product2, product8, product0, product3, product7};
        assertArrayEquals(shop.sortNameAsc(shop.getProductList()), sorted);
    }

    @Test
    public void sortNameDesc() {
        Product[] sorted = {product7, product3, product0, product8, product2,
                product1, product5, product6, product9, product4, product10};
                assertArrayEquals(shop.sortNameDesc(shop.getProductList()), sorted);
    }

    @Test
    public void sum() {
        assertEquals(570.17, shop.getSum(shop.getProductList()), 0.0001);
    }

    @Test
    public void mostExpensive() {
        Product[] list = {product6, product7, product10, product4};
        assertArrayEquals(shop.mostExpensiveList(shop.getProductList(),4), list);
    }

    @Test
    public void cheapest() {
        Product[] list = {product1, product8, product0, product9};
        assertArrayEquals(shop.cheapestList(shop.getProductList(),4), list);
    }

    @Test
    public void min() {
        assertEquals(shop.findCheapest(shop.getProductList()), product1);
    }

    @Test
    public void max() {
        assertEquals(shop.findMostExpensive(shop.getProductList()), product6);
    }
}
