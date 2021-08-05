package springs.network.nodes;

import springs.network.core.Strings;

public class Node {

    public String Name;
    public Nodes Children = new Nodes();

    public Node(String name) {
        this.Name = name;
    }

    public void appendTo(Strings s, Integer depth) {
        String indent = new String(new char[depth * 3]).replace("\0", " ");
        s.add(indent + "<" + Name + ">");
        for (Node c : Children)
            c.appendTo(s, depth + 1);
        s.add(indent + "</" + Name + ">");
    }

    public void addChild(Node c) {
        Children.add(c);
    }



}
