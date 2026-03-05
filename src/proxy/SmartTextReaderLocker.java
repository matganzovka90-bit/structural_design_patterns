package proxy;

import java.util.regex.Pattern;

public class SmartTextReaderLocker implements TextReader {
    private final TextReader reader;
    private final Pattern forbiddenPattern;

    public SmartTextReaderLocker(TextReader reader, String regex) {
        this.reader = reader;
        this.forbiddenPattern = Pattern.compile(regex);
    }

    @Override
    public char[][] readText(String filePath) {
        if (forbiddenPattern.matcher(filePath).matches()) {
            System.out.println("Access denied!");
            return new char[0][0];
        }

        return reader.readText(filePath);
    }
}
