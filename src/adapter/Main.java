package adapter;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.log("Програма запущена");
        logger.warn("Попередження");
        logger.error("Сталася помилка");

        MyFileWriter fileWriter = new MyFileWriter("test.txt");
        FileLoggerAdapter fileLoggerAdapter = new FileLoggerAdapter(fileWriter);

        fileLoggerAdapter.log("Файл записано");
        fileLoggerAdapter.warn("Попередження");
        fileLoggerAdapter.error("Сталася помилка");
    }
}
