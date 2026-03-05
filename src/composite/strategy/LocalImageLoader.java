package composite.strategy;

import java.io.File;
import java.io.IOException;

public class LocalImageLoader implements  ImageLoaderStrategy {
    @Override
    public void load(String href) throws IOException {
        File file = new File(href);
        if (file.exists()) {
            System.out.println("Loaded image from local file: " + href);
        } else {
            System.out.println("File not found: " + href);
        }
    }
}
