package composite.command;

import composite.LightElementNode;
import composite.LightNode;

public class RemoveChildCommand implements Command{
    private final LightElementNode parent;
    private final LightNode child;

    public RemoveChildCommand(LightElementNode parent, LightNode child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void execute() {
        parent.getChildren().remove(child);
    }

    @Override
    public void undo() {
        parent.addChild(child);
    }
}
