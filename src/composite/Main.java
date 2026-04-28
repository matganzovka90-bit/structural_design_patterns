package composite;

import composite.command.AddClassCommand;
import composite.command.Command;
import composite.command.CommandManager;
import composite.enums.ClosingType;
import composite.enums.DisplayType;
import composite.flyweight.BookParser;
import composite.flyweight.ElementFlyweightFactory;
import composite.flyweight.MemoryCalculator;
import composite.iterator.LightIterator;
import composite.state.DisabledState;
import composite.state.HiddenState;
import composite.state.NormalState;
import composite.template_method.LifecycleTemplate;
import composite.template_method.LoggingLifecycle;
import composite.visitor.TagCountVisitor;
import composite.visitor.TextSearchVisitor;

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

        System.out.println("\n=== DFS Traversal (ul) ===");

        LightIterator dfs = ul.createDFSIterator();

        while (dfs.hasNext()) {
            LightNode node = dfs.next();
            System.out.println(node.outerHTML());
        }


        System.out.println("\n=== BFS Traversal (ul) ===");

        LightIterator bfs = ul.createBFSIterator();

        while (bfs.hasNext()) {
            LightNode node = bfs.next();
            System.out.println(node.outerHTML());
        }

        System.out.println("\n=== Command Pattern ===");

        CommandManager manager = new CommandManager();

        Command addClass = new AddClassCommand(ul, "active");
        manager.executeCommand(addClass);

        System.out.println("After adding class:");
        System.out.println(ul.outerHTML());

        manager.undo();

        System.out.println("After undo:");
        System.out.println(ul.outerHTML());


        System.out.println("\n=== STATE: Normal ===");
        System.out.println(ul.outerHTML());

        ul.setState(new HiddenState());

        System.out.println("\n=== STATE: Hidden ===");
        System.out.println(ul.outerHTML());

        ul.setState(new DisabledState());

        System.out.println("\n=== STATE: Disabled ===");
        System.out.println(ul.outerHTML());

        ul.setState(new NormalState());

        System.out.println("\n=== Visitor: UL ===");

        TagCountVisitor tagVisitor = new TagCountVisitor();
        ul.accept(tagVisitor);
        tagVisitor.printStats();

        System.out.println("\n=== Visitor: HTML Tree ===");

        TagCountVisitor tagVisitor2 = new TagCountVisitor();

        for (LightNode root : htmlTree) {
            root.accept(tagVisitor2);
        }

        tagVisitor2.printStats();

        TextSearchVisitor searchVisitor = new TextSearchVisitor("Romeo");

        for (LightNode root : htmlTree) {
            root.accept(searchVisitor);
        }

        searchVisitor.printResult();


        System.out.println("\n=== TEMPLATE METHOD (Lifecycle Hooks) ===");

        LifecycleTemplate lifecycle = new LoggingLifecycle();
        ul.setLifecycle(lifecycle);

        System.out.println(ul.outerHTML());
    }
}