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
     * Setting the maze paths and blocks
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
     * sets a given Node to be target
     * @param row
     * @param col
     */
    public void setTarget(int row, int col) {
        if (row < size && col < size && maze[row][col].isNode) {
            this.target = maze[row][col];
        }
    }

    /**
     * sets a given Node to be source
     * important for distance
     * @param row
     * @param col
     */
    public void setSource(int row, int col) {
        if (row < size && col < size && maze[row][col].isNode) {
            this.source = maze[row][col];
            this.source.distance = 0;
            this.source.marked = true;
        }
    }

    /**
     * solves the maze using addAdjacents
     *
     *
     */
    public void solveMaze() {
        Queue<Node> q = new LinkedList<>();
        q = addAdjacents(q, this.source.row, this.source.col);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            q = addAdjacents(q, cur.row, cur.col);
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
    private Queue<Node> addAdjacents(Queue<Node> q, int row, int col) {
        //right - checks if: range is ok , if not marked , if Node (not block)
        if (row < size && col + 1 < size && this.maze[row][col + 1].isNode &&
                !this.maze[row][col + 1].marked && this.maze[row][col + 1].isNode) {
            this.maze[row][col + 1].distance = this.maze[row][col].distance + 1;
            this.maze[row][col + 1].marked = true;
            // check if got to target
            if (this.target == this.maze[row][col + 1]) {
                printMaze();
                return q;
            }
            q.add(this.maze[row][col + 1]);
        }

        //down - checks if: range is ok , if not marked , if Node (not block)
        if (row + 1 < size && col < size && this.maze[row + 1][col].isNode &&
                !this.maze[row + 1][col].marked && this.maze[row + 1][col].isNode) {
            this.maze[row + 1][col].distance = this.maze[row][col].distance + 1;
            this.maze[row + 1][col].marked = true;
            // check if got to target
            if (this.target == this.maze[row + 1][col]) {
                printMaze();
                return q;
            }
            q.add(this.maze[row + 1][col]);
        }

        //left - checks if: range is ok , if not marked , if Node (not block)
        if (row < size && col - 1 >= 0 && this.maze[row][col - 1].isNode &&
                !this.maze[row][col - 1].marked && this.maze[row][col - 1].isNode) {
            this.maze[row][col - 1].distance = this.maze[row][col].distance + 1;
            this.maze[row][col - 1].marked = true;
            // check if got to target
            if (this.target == this.maze[row][col - 1]) {
                printMaze();
                return q;
            }
            q.add(this.maze[row][col - 1]);
        }

        //up - checks if: range is ok , if not marked , if Node (not block)
        if (row - 1 >= 0 && col < size && this.maze[row - 1][col].isNode &&
                !this.maze[row - 1][col].marked && this.maze[row - 1][col].isNode) {
            this.maze[row - 1][col].distance = this.maze[row][col].distance + 1;
            this.maze[row - 1][col].marked = true;
            // check if got to target
            if (this.target == this.maze[row - 1][col]) {
                printMaze();
                return q;
            }
            q.add(this.maze[row - 1][col]);
        }

        return q;
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
