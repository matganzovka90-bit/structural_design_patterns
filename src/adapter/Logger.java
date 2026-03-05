package adapter;

public class Logger {
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";

    public void log(String message) {
        System.out.println(GREEN + "[LOG] " + message + RESET);
    }

    public void error(String message) {
        System.out.println(RED + "[ERROR] " + message + RESET);
    }

    public void warn(String message) {
        System.out.println(YELLOW + "[WARN] " + message + RESET);
    }
}
