package csc351.cache;

import csc351.cache.data.*;

import java.util.HashMap;
import java.util.List;

public class FileProcessor {
    private final CodeLookup productLookup;
    private final CodeLookup deviceLookup;
    private final CodeLookup statusLookup;
    int lineNumber = 0;
    private final HashMap<String, Integer> seenDevices = new HashMap<>(10_000);
    private final HashMap<String, Integer> seenProducts = new HashMap<>(14);
    private final HashMap<String, Integer> seenStatuses = new HashMap<>(2);

    public FileProcessor(CodeLookup productLookup, CodeLookup deviceLookup, CodeLookup statusLookup) {
        this.productLookup = productLookup;
        this.deviceLookup = deviceLookup;
        this.statusLookup = statusLookup;
    }

    public List<Transaction> processFile(String identifier) {
        return ResourceReader.read(identifier, this::processLine);
    }

    private Transaction processLine(String line) {
        lineNumber++;
        if (lineNumber % 1000 == 0) {
            System.out.println(System.currentTimeMillis() + " Processed " + lineNumber);
        }

        String[] items = line.split(",");

        if (!seenDevices.containsKey(items[0])) {
            seenDevices.put(items[0], deviceLookup.find(items[0]));
        }
        if (!seenProducts.containsKey(items[1])) {
            seenProducts.put(items[1], productLookup.find(items[1]));
        }
        if (!seenStatuses.containsKey(items[3])) {
            seenStatuses.put(items[3], statusLookup.find(items[3]));
        }

        int deviceId = seenDevices.get(items[0]);
        int productId = seenProducts.get(items[1]);
        int statusId = seenStatuses.get(items[3]);

        return new Transaction()
                .setDeviceId(deviceId)
                .setProductId(productId)
                .setAmount(items[2])
                .setStatusId(statusId)
                .setDate(items[4])
                .setTime(items[5])
                ;
    }
}
