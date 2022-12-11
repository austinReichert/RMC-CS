package csc351.cache;

import csc351.cache.data.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        DeviceRepository deviceRepository = new DeviceRepository();
        StatusRepository statusRepository = new StatusRepository();
        ProductRepository productRepository = new ProductRepository();
        FileProcessor fileProcessor = new FileProcessor(productRepository, deviceRepository, statusRepository);

        verify(fileProcessor, "small");
        // verify(fileProcessor, "large");
    }

    private static void verify(FileProcessor fileProcessor, String id) {
        List<Transaction> processLines = fileProcessor.processFile("/" + id + ".csv");
        List<Transaction> goldLines = ResourceReader.read("/" + id + "-gold.csv", (line) -> {
            String[] split = line.split(",");
            return new Transaction()
                    .setDeviceId(Integer.parseInt(split[0]))
                    .setProductId(Integer.parseInt(split[1]))
                    .setStatusId(Integer.parseInt(split[2]))
                    .setAmount(split[3])
                    .setDate(split[4])
                    .setTime(split[5])
                    ;
        });
        if (processLines.size() != goldLines.size()) {
            throw new IllegalStateException("Gold file has a different number of lines than the processed file");

        }
        for (int i = 0; i < processLines.size(); i++) {
            if (!processLines.get(i).equals(goldLines.get(i)))
                throw new IllegalStateException("Line" + (i + 1) + " doesn't match gold file");
        }
    }
}
