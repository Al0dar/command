package springs.network.nodes;

import springs.network.core.Strings;

import java.util.ArrayList;

public class Nodes extends ArrayList<Node> {

    public static void test1() {

        System.out.println("[Nodes.test1]");

        Node root = new Node("root");
        {
            Node child = new Node("child1");
            root.addChild(child);
            child.addChild(new Node("c1a"));
            child.addChild(new Node("c1b"));
            child.addChild(new Node("c1b"));
        }
        {
            Node child = new Node("child2");
            root.addChild(child);
            child.addChild(new Node("c2a"));
            child.addChild(new Node("c2b"));
            child.addChild(new Node("c2b"));
        }

        Strings o = new Strings();
        root.appendTo(o, 0);
        for (String s : o)
            System.out.println(s);

    }

}
