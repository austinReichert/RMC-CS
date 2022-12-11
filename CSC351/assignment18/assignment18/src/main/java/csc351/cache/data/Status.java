package csc351.cache.data;

public class Status {
    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public Status setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Status setName(String name) {
        this.name = name;
        return this;
    }
}
