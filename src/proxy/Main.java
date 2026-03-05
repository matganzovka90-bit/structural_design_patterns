package proxy;

public class Main {
    public static void main(String[] args) {

        TextReader reader = new SmartTextReader();

        TextReader checker = new SmartTextChecker(reader);
        checker.readText("test.txt");

        System.out.println("---------------");

        TextReader locker = new SmartTextReaderLocker(reader, ".*secret.*");

        locker.readText("secret.txt");
        locker.readText("public.txt");
    }
}
