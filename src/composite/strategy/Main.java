package composite.strategy;

import composite.LightElementNode;
import composite.enums.ClosingType;
import composite.enums.DisplayType;

public class Main {
    public static void main(String[] args) {
        LightElementNode div = new LightElementNode("div", DisplayType.BLOCK, ClosingType.PAIRED);

        LightImageNode localImg = new LightImageNode("/Users/adminadmin/Downloads/images.jpeg", new LocalImageLoader());
        LightImageNode networkImg = new LightImageNode("https://static.vecteezy.com/system/resources/thumbnails/045/132/934/small/a-beautiful-picture-of-the-eiffel-tower-in-paris-the-capital-of-france-with-a-wonderful-background-in-wonderful-natural-colors-photo.jpg", new NetworkImageLoader());

        div.addChild(localImg);
        div.addChild(networkImg);

        System.out.println("=== LightHTML with Images ===");
        System.out.println(div.outerHTML());

        System.out.println("\n=== Loading Images ===");
        localImg.load();
        networkImg.load();
    }
}
