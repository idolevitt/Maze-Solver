package mazer;

public class Maze {

    Node[][] maze;
    Node source;
    Node target;
    int size;


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
                    this.maze[i][j] = new Node(true, -1);
                else
                    this.maze[i][j] = new Node(false, -1);
            }
        }
    }

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
                maze += node + "\t";
            }
            maze += "\n";
        }
        System.out.println(maze);
    }
}
