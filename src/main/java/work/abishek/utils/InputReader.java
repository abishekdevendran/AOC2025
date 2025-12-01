package work.abishek.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputReader {
    public static List<String> read(String filename) {
        try {
            var url = InputReader.class.getClassLoader().getResource(filename);
            var path = Path.of(url.toURI());
            return Files.readAllLines(path);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read " + filename, e);
        }
    }
}
