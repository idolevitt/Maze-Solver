package mazer;

public class Main {

    public static void main(String[] args) {
        Maze maze = new Maze(5);

        // s - source, t - target , * - block
        // 0  0  0  0  0
        // 0  s  0  0  0
        // 0  0  0  0  0
        // 0  0  0  t  0
        // 0  0  0  0  0

        int[][] arr = new int[5][5];
        maze.setMaze(arr);

        maze.setSource(1,1);
        maze.setTarget(4,4);
        maze.printMaze();

        maze.solveMaze();

    }





}
