package repositories;

public class ProductEntity {

    private static int largestProductID = 0;
    private String id;
    private String name;

    public ProductEntity(String name) {
        this.id = Integer.toString(largestProductID++);
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
