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
        distance = Integer.MAX_VALUE;
        marked = false;
    }

    @Override
    public String toString() {
        //TODO: Implement
        return null;
    }
}
