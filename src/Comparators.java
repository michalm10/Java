import java.util.Comparator;

public class Comparators {
    static Comparator<Product> comparatorNamePriceDesc = (a, b) -> {
        if (a.getName().compareTo(b.getName()) != 0)
            return -a.getName().compareTo(b.getName());
        else
            return (int) -(a.getDiscountPrice() - b.getDiscountPrice());
    };

    static Comparator<Product> comparatorNamePriceAsc = (a, b) -> {
        if (a.getName().compareTo(b.getName()) != 0)
            return a.getName().compareTo(b.getName());
        else
            return (int) (a.getDiscountPrice() - b.getDiscountPrice());
    };

    static Comparator<Product> comparatorPriceNameDesc = (a, b) -> {
        if (a.getDiscountPrice() != b.getDiscountPrice())
            return (int) -(a.getDiscountPrice() - b.getDiscountPrice());
        else
            return -a.getName().compareTo(b.getName());
    };

    static Comparator<Product> comparatorPriceNameAsc = (a, b) -> {
        if (a.getDiscountPrice() != b.getDiscountPrice())
            return (int) (a.getDiscountPrice() - b.getDiscountPrice());
        else
            return a.getName().compareTo(b.getName());
    };
}
