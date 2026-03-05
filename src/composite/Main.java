package composite;

import composite.enums.ClosingType;
import composite.enums.DisplayType;
import composite.flyweight.BookParser;
import composite.flyweight.ElementFlyweightFactory;
import composite.flyweight.MemoryCalculator;
import composite.observer.ClickListener;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        LightElementNode ul = new LightElementNode(
                "ul",
                DisplayType.BLOCK,
                ClosingType.PAIRED
        );
        ul.addClass("menu");

        LightElementNode li1 = new LightElementNode(
                "li",
                DisplayType.INLINE,
                ClosingType.PAIRED
        );
        li1.addChild(new LightTextNode("Home"));

        ul.addChild(li1);

        System.out.println("=== Composite ===");
        System.out.println(ul.outerHTML());
        System.out.println("Children count: " + ul.getChildrenCount());


        System.out.println("\n\n\nFlyweight");
        String bookText = """
            ACT V
            Scene I. Mantua. A Street.
            Scene II. Friar Laurence’s Cell.
            Scene III. A churchyard; in it a Monument belonging to the Capulets.
            
             Dramatis Personae
            
            ESCALUS, Prince of Verona.
            MERCUTIO, kinsman to the Prince, and friend to Romeo.
            PARIS, a young Nobleman, kinsman to the Prince.
            Page to Paris.
            """;

        List<LightNode> htmlTree = BookParser.parse(bookText);

        System.out.println("=== HTML OUTPUT ===");
        for (LightNode node : htmlTree) {
            System.out.println(node.outerHTML());
        }

        int totalNodes = MemoryCalculator.countNodes(htmlTree);

        System.out.println("\n=== MEMORY INFO ===");
        System.out.println("Total nodes in tree: " + totalNodes);
        System.out.println("Flyweights created: " +
                ElementFlyweightFactory.cacheSize());

        System.out.println("\n=== Observer ===");

        ClickListener clickListener = new ClickListener();

        ul.addEventListener("click", clickListener);

        ul.triggerEvent("click");
    }
}