package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductDao {

    HashMap<String, ProductEntity> productRepo = new HashMap<>(); // DB mock via map

    public boolean addProduct(ProductEntity product) {

        if(productRepo.containsKey(product.getId())){
            return false;
        }

        productRepo.put(product.getId(), product);
        return true;
    }

    public boolean deleteProduct(ProductEntity product) {

        if(!productRepo.containsKey(product.getId())){
            return false;
        }

        productRepo.remove(product.getId());
        return true;
    }

    public String getNameById(String id) {
        if(!productRepo.containsKey(id)){
            return "";
        }

        return productRepo.get(id).getName();
    }

    public List<String> findIDsByName(String name) {

        List<String> productIdList =  new ArrayList<>();

        productRepo.forEach((key,val)->{
            if(val.getName().equals(name))
                productIdList.add(key);
        });

        return productIdList;
    }

    public HashMap<String, ProductEntity> getAllProduct() {
        return this.productRepo;
    }



}
