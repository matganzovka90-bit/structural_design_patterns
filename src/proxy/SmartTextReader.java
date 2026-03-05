package proxy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SmartTextReader implements TextReader {
    @Override
    public char[][] readText(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            char[][] result = new char[lines.size()][];

            for (int i = 0; i < lines.size(); i++) {
                result[i] = lines.get(i).toCharArray();
            }

            return result;

        } catch (IOException e) {
            System.out.println("Error reading file");
            return new char[0][0];
        }
    }
}
