package composite.command;

import composite.LightElementNode;
import composite.LightNode;

public class AddChildCommand implements Command{
    private final LightElementNode parent;
    private final LightNode child;

    public AddChildCommand(LightElementNode parent, LightNode child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void execute() {
        parent.addChild(child);
    }

    @Override
    public void undo() {
        parent.getChildren().remove(child);
    }
}
