package adapter;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    private final String filePath;

    public MyFileWriter(String filePath) {
        this.filePath = filePath;
    }


    public void write(String text) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeLine(String text) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(text + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
