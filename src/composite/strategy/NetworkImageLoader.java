package composite.strategy;

import java.io.IOException;
import java.net.URL;

public class NetworkImageLoader implements ImageLoaderStrategy {
    @Override
    public void load(String href) throws IOException {
        try {
            URL url = new URL(href);
            System.out.println("Loaded image from network: " + url);
        } catch (Exception e) {
            System.out.println("Failed to load image from URL: " + href);
        }
    }
}
