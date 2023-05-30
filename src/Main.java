import repositories.ProductDao;
import repositories.ProductEntity;

public class Main {
    public static void main(String[] args) {

        ProductDao productDao = new ProductDao();

        productDao.addProduct(new ProductEntity("Kolya"));
        productDao.addProduct(new ProductEntity("Dima"));
        ProductEntity fedyaProd = new ProductEntity("Fedya");
        productDao.addProduct(fedyaProd);
        productDao.addProduct(new ProductEntity("Petya"));
        System.out.println("adding Kolya result - " + productDao.addProduct(new ProductEntity("Kolya")) + "\n");

        System.out.println("All Fedya product IDs inclusions:");
        System.out.println(productDao.findIDsByName("Fedya") + " with name by id = " + productDao.getNameById("2") + "\n");
        System.out.println("Fedya deletion result - " + productDao.deleteProduct(fedyaProd));
        System.out.println("repeated Fedya deletion result - " + productDao.deleteProduct(fedyaProd) + "\n");

        System.out.println("All Kolya product IDs inclusions:");
        System.out.println(productDao.findIDsByName("Kolya") + "\n");

        System.out.println("Current repo Values:");
        productDao.getAllProduct().forEach((key, value) -> System.out.println("|" + key + "| |" + value.getName() + "|"));

    }
}