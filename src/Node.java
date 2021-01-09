public class Node{

    boolean isPath;
    Node parent;
    int distance;
    boolean marked;

    public Node(boolean isPath,int distance){
        this(isPath, null, distance, false);
    }

    public Node(boolean isPath, Node parent, int distance, boolean marked) {
        this.isPath = isPath;
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
