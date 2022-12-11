package csc351.cache.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ResourceReader {

    public static <Type> List<Type> read(String resource, Function<String, Type> type) {
        ArrayList<Type> types = new ArrayList<>();
        try (InputStream data = DeviceRepository.class.getResourceAsStream(resource)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(data))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.isBlank()) continue;
                    types.add(type.apply(line));
                }
            }
        } catch (IOException e) {
        }
        return types;
    }
}
