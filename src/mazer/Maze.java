package mazer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Maze {

    Node[][] maze;
    Node source;
    Node target;
    int size;

    /**
     * constructor of maze
     * @param size
     */
    public Maze(int size) {
        this.maze = new Node[size][size];
        this.size = size;
    }


    /**
     * Setting the maze nodes and blocks where: 0 = path, 1 = block
     * @param maze
     */
    public void setMaze(int[][] maze) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (maze[i][j] == 0)
                    this.maze[i][j] = new Node(true, -1, i, j);
                else
                    this.maze[i][j] = new Node(false, -1, i, j);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * sets a given Node to be source
     * important for distance
     * @param row
     * @param col
     */
    public void setSource(int row, int col) {
        if (isInBounds(row, col) && maze[row][col].isNode) {
            this.source = maze[row][col];
            this.source.distance = 0;
            this.source.marked = true;
        }
        else{
            System.out.println("Source out of bounds or not a valid node(block)");
        }
    }

    /**
     * sets a given Node to be target
     * @param row
     * @param col
     */
    public void setTarget(int row, int col) {
        if (isInBounds(row, col) && maze[row][col].isNode) {
            this.target = maze[row][col];
        }
        else {
            System.out.println("Source out of bounds or not a valid node(block)");
        }
    }

    /**
     * solves the maze using addAdjacents
     *
     *
     */
    public void solveMaze() {
        Queue<Node> q = new LinkedList<>();
        addAdjacents(q, this.source.row, this.source.col, 0);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            addAdjacents(q, cur.row, cur.col, cur.distance);
        }
    }

    /**
     *
     * Improvements!!
     * adding another function to do all 4 options instead of the repetitions
     * understand how to stop run when getting to target
     *
     * @param q
     * @param row
     * @param col
     * @return
     */
    private void addAdjacents(Queue<Node> q, int row, int col,int dist) {

        //updates the node to the right:
        addAdjacent(q, row, col + 1, dist);
        //updates the node to the left:
        addAdjacent(q, row, col - 1, dist);
        //updates the node above:
        addAdjacent(q, row + 1, col, dist);
        //updates the node below:
        addAdjacent(q, row - 1, col, dist);

    }

    private void addAdjacent(Queue<Node> q, int row, int col, int dist){

        if (!isInBounds(row, col))
            return;

        Node node = this.maze[row][col];

        if (node.isNode && !node.marked) {
            node.distance = dist + 1;
            node.marked = true;
            // check if got to target
            if (this.target == node) {
                printMaze();
            }
            q.add(node);
        }
    }

    /**
     *
     * @param row
     * @param col
     * @return Returns true if (row, col) is in the maze bounds
     */
    private boolean isInBounds(int row, int col){
        if(row < size && row >= 0 && col < size && col >=0)
            return true;
        return false;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////





    /**
     * prints if there is path from source to target.
     * if solved prints length of path
     * @return solved or not and num of moves
     */
    @Override
    public String toString() {
        return "Maze is " +
                ((this.target.marked) ? "solved! \n took: " + this.target.distance + " moves" : "not solved!");
    }


    public void printMaze () {
        String maze = "";
        for (Node[] row: this.maze){
            for (Node node: row){
                maze += node.distance + "\t";
            }
            maze += "\n";
        }
        System.out.println(maze);
    }
}
