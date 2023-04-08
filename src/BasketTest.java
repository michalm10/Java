import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BasketTest {
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
    Basket basket;
    Shop shop = new Shop();
    Product[] all = {product6, product7, product10, product4, product5,
            product3, product2, product9, product0, product8, product1};


    @Before
    public void init() {
        shop.applyThirdFree(all);
        shop.over300(all);
        shop.off30(all);
        shop.applyFreeMug(all);
        basket = new Basket();
        basket.add(all[0]);
        basket.add(all[1]);
        basket.add(all[2]);
        basket.add(all[3]);
        basket.add(all[4]);
        basket.add(all[5]);
        basket.add(all[6]);
        basket.add(all[7]);
        basket.add(all[8]);
        basket.add(all[9]);
        basket.add(all[10]);
    }

    @Test
    public void display() {
        basket.display();
    }

    @Test
    public void sort() {
        Product[] sorted = {product6, product7, product10, product4, product5,
                product3, product2, product9, product0, product8, product1};
        assertArrayEquals(basket.getItemList(), sorted);
    }

    @Test
    public void disc() {
        assertEquals(541.6615, (basket.getRealValue()), 0.0001);
    }

    @Test
    public void remove() {
        basket.remove(product0);
        basket.remove(product1);
        basket.remove(product2);
        basket.remove(product3);
        basket.remove(product4);
        basket.remove(product5);
        basket.remove(product8);
        basket.remove(product9);
        assertEquals((164.47 + 142.47) * 0.95, (basket.getRealValue()), 0.0001);
    }

    @Test
    public void Mug() {
        assertEquals(true, basket.freeMug);
    }
}
