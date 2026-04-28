package composite.command;

import composite.LightElementNode;

public class AddClassCommand implements Command{
    private final LightElementNode node;
    private final String className;

    public AddClassCommand(LightElementNode node, String className) {
        this.node = node;
        this.className = className;
    }

    @Override
    public void execute() {
        node.addClass(className);
    }

    @Override
    public void undo() {
        node.getClasses().remove(className);
    }
}
