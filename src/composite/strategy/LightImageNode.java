package composite.strategy;

import composite.LightNode;

public class LightImageNode extends LightNode {
    private final String href;
    private final ImageLoaderStrategy loaderStrategy;

    public LightImageNode(String href, ImageLoaderStrategy loaderStrategy) {
        this.href = href;
        this.loaderStrategy = loaderStrategy;
    }

    public void load() {
        try {
            loaderStrategy.load(href);
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    @Override
    public String outerHTML() {
        return "<img src=\"" + href + "\"/>";
    }

    @Override
    public String innerHTML() {
        return "";
    }
}
