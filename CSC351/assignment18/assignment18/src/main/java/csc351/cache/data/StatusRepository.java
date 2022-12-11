package csc351.cache.data;

import csc351.cache.CodeLookup;

import java.util.List;

public class StatusRepository implements CodeLookup {
    public List<Status> findAll() {
        return read();
    }

    public Integer find(String item) {
        return findAll()
                .stream()
                .filter(i -> i.getName().equals(item))
                .map(Status::getId)
                .findFirst()
                .get()
                ;
    }


    private List<Status> read() {
        return ResourceReader.read("/status.table", line -> {
            String[] items = line.split(",");
            return new Status()
                    .setId(Integer.parseInt(items[0]))
                    .setName(items[1])
                    ;
        });
    }
}
