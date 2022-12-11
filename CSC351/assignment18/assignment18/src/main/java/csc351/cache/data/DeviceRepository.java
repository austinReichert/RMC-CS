package csc351.cache.data;

import csc351.cache.CodeLookup;

import java.util.List;

public class DeviceRepository implements CodeLookup {

    public List<Device> findAll() {
        return read();
    }

    private List<Device> read() {
        return ResourceReader.read("/devices.table", line -> {
            String[] items = line.split(",");
            return new Device()
                    .setId(Integer.parseInt(items[0]))
                    .setName(items[1])
                    ;
        });
    }

    @Override
    public Integer find(String item) {
        return findAll()
                .stream()
                .filter(i -> i.getName().equals(item))
                .map(Device::getId)
                .findFirst()
                .get()
                ;
    }

}
