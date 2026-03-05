package composite.strategy;

import java.io.IOException;

public interface ImageLoaderStrategy {
    void load(String href) throws IOException;
}
