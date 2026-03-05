package composite.flyweight;

import composite.LightElementNode;
import composite.LightNode;
import composite.LightTextNode;
import composite.enums.ClosingType;
import composite.enums.DisplayType;

import java.util.ArrayList;
import java.util.List;

public class BookParser {

    public static List<LightNode> parse(String text) {

        String[] lines = text.split("\n");
        List<LightNode> result = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            String tag;

            if (i == 0) {
                tag = "h1";
            } else if (line.startsWith(" ")) {
                tag = "blockquote";
                line = line.trim();
            } else if (line.length() < 20) {
                tag = "h2";
            } else {
                tag = "p";
            }

            ElementFlyweight flyweight =
                    ElementFlyweightFactory.get(
                            tag,
                            DisplayType.BLOCK,
                            ClosingType.PAIRED
                    );

            LightElementNode element = new LightElementNode(flyweight);
            element.addChild(new LightTextNode(line));

            result.add(element);
        }

        return result;
    }
}