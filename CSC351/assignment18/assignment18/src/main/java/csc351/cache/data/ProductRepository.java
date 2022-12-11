package csc351.cache.data;

import csc351.cache.CodeLookup;

import java.math.BigDecimal;
import java.util.List;

public class ProductRepository implements CodeLookup {
    public List<Product> findAll() {
        return read();
    }

    public Integer find(String item) {
        return findAll()
                .stream()
                .filter(i -> i.getName().equals(item))
                .map(Product::getId)
                .findFirst()
                .get()
                ;
    }
    private List<Product> read() {
        return ResourceReader.read("/product.table", line -> {
            String[] items = line.split(",");
            return new Product()
                    .setId(Integer.parseInt(items[0]))
                    .setName(items[1])
                    .setPrice(new BigDecimal(items[2]));
        });
    }

}
