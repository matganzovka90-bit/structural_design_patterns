package composite.iterator;

import composite.LightElementNode;
import composite.LightNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstIterator implements LightIterator{
    private final Queue<LightNode> queue = new LinkedList<>();

    public BreadthFirstIterator(LightNode root) {
        queue.add(root);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public LightNode next() {
        LightNode node = queue.poll();

        if (node instanceof LightElementNode el) {
            queue.addAll(el.getChildren());
        }

        return node;
    }
}
