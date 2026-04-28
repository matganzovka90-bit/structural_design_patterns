package composite.visitor;

import composite.LightElementNode;
import composite.LightTextNode;

public class TextSearchVisitor implements Visitor{
    private final String search;
    private int count = 0;

    public TextSearchVisitor(String search) {
        this.search = search;
    }

    @Override
    public void visit(LightTextNode node) {
        if (node.outerHTML().contains(search)) {
            count++;
        }
    }

    @Override
    public void visit(LightElementNode node) {
    }

    public void printResult() {
        System.out.println("Occurrences of \"" + search + "\": " + count);
    }
}
