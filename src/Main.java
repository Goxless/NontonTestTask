import repositories.ProductDao;
import repositories.ProductEntity;

import java.util.Arrays;
import static java.util.UUID.randomUUID;

public class Main {
    private static final ProductDao productDao = new ProductDao();
    public static void main(String[] args) {

        productDao.addMultipleProducts(new ProductEntity("Kolya"),
                new ProductEntity("Dima"),
                new ProductEntity("Petya"),
                new ProductEntity("Kolya"));

        System.out.println("Current repo Values:");
        productDao.getAllProduct().forEach((key, value) -> System.out.println("|" + key + "| |" + value.getName() + "|"));
        System.out.println();

        errorsOutputTest();
    }

    private static void errorsOutputTest(){

        ProductEntity fedyaProd = new ProductEntity("Fedya");

        fedyaProd.setId("0");
        productDao.addProduct(fedyaProd);
        System.out.println("Output of entity adding with existing id: " + productDao.addProduct(fedyaProd)+ " with id = " + fedyaProd.getId());
        productDao.deleteProductByID("0");

        fedyaProd.setId(randomUUID().toString());
        System.out.println("Output of entity adding with correct id: " + productDao.addProduct(fedyaProd) + " with id = " + fedyaProd.getId() + "\n");

        System.out.println("Entities IDs with name of \"" + fedyaProd.getName() + "\" - " + productDao.findIDsByName("Fedya")+ "\n");
        System.out.println("Name with wrong ID of \"wrongid\" - " + productDao.getNameById("wrongid"));
        System.out.println("Name with right ID - " + productDao.getNameById(fedyaProd.getId()) + "\n");

        System.out.println("Fedya deletion result - " + productDao.deleteProduct(fedyaProd));
        System.out.println("repeated Fedya deletion result - " + productDao.deleteProduct(fedyaProd) + "\n");

        System.out.println("All \"Kolya\" product IDs inclusions:");
        System.out.println(productDao.findIDsByName("Kolya"));
    }
}