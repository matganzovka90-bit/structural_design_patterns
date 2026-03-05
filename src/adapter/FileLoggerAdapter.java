package adapter;


public class FileLoggerAdapter {
    private final MyFileWriter fileWriter;

    public FileLoggerAdapter(MyFileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void log(String message) {
        fileWriter.writeLine("[LOG] " + message);
    }

    public void error(String message) {
        fileWriter.writeLine("[ERROR] " + message);
    }

    public void warn(String message) {
        fileWriter.writeLine("[WARN] " + message);
    }
}
