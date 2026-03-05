package proxy;

public class SmartTextChecker implements TextReader {
    private final TextReader reader;

    public SmartTextChecker(TextReader reader) {
        this.reader = reader;
    }

    @Override
    public char[][] readText(String filePath) {
        System.out.println("Opening file: " + filePath);

        char[][] data = reader.readText(filePath);

        int lines = data.length;
        int chars = 0;

        for (char[] line : data) {
            chars += line.length;
        }

        System.out.println("File read successfully");
        System.out.println("Lines: " + lines);
        System.out.println("Characters: " + chars);
        System.out.println("Closing file");

        return data;
    }
}
