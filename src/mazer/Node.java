package mazer;

public class Node{

    boolean isNode;
    Node parent;
    int distance;
    boolean marked;
    int row;
    int col;

    public Node(boolean isNode, int distance, int row, int col){
        this(isNode, null, distance, false, row, col);
    }

    public Node(boolean isNode, Node parent, int distance, boolean marked, int row, int col) {
        this.isNode = isNode;
        this.parent = null;
        this.distance = -1;
        this.marked = false;
        this.row = row;
        this.col = col;

    }

    /**
     * prints all stats of Node
     * @return stats of Node
     */
    @Override
    public String toString() {
        return "this is a - " + ((this.isNode) ? "path" : "block") +  "\n" +
                ((this.parent != null) ? "parent is: " + this.parent.row + "  " + this.parent.col +  "\n" : "parentless \n") +
                "distance from source: " + this.distance + "\n" +
                "Node is " + ((this.marked) ? "" : "not ") + "marked \n";
    }
}
