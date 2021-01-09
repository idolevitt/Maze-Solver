package mazer;

public class Node{

    boolean isNode;
    Node parent;
    int distance;
    boolean marked;

    public Node(boolean isNode, int distance){
        this(isNode, null, distance, false);
    }

    public Node(boolean isNode, Node parent, int distance, boolean marked) {
        this.isNode = isNode;
        parent = null;
        distance = -1;
        marked = false;
    }

    /**
     * prints all stats of Node
     * @return stats of Node
     */
    @Override
    public String toString() {
        return "this is a - " + ((this.isNode) ? "path" : "block") +  "\n" +
                "parent is: " + this.parent +
                "distance from source: " + this.distance +
                "Node is " + ((this.marked) ? "" : "not") + "marked";
    }
}
