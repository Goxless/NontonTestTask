package repositories;

import static java.util.UUID.randomUUID;

public class ProductEntity {

    private String id;
    private String name;

    public ProductEntity(String name) {
        this.id = randomUUID().toString();
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
