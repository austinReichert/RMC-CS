package csc351.cache.data;

public class Device {
    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public Device setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Device setName(String name) {
        this.name = name;
        return this;
    }
}
