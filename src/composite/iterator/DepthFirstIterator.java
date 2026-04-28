package composite.iterator;

import composite.LightElementNode;
import composite.LightNode;

import java.util.List;
import java.util.Stack;

public class DepthFirstIterator implements LightIterator{
    private final Stack<LightNode> stack = new Stack<>();

    public DepthFirstIterator(LightNode root) {
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public LightNode next() {
        LightNode node = stack.pop();

        if (node instanceof LightElementNode el) {
            List<LightNode> children = el.getChildren();

            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }

        return node;
    }
}
