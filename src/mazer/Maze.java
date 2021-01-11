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
     *
     * @param row
     * @param col
     * @return Returns true if (row, col) is in the maze bounds
     */
    public boolean isInBounds(int row, int col){
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
