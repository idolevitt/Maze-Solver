package mazer;

public class Main {

    public static void main(String[] args) {
        Maze maze = new Maze(5);

        // s - source, t - target , * - block
        // 0  0  0  0  0
        // 0  s  0  0  0
        // 0  0  *  *  0
        // 0  0  *  t  0
        // 0  0  0  0  0

        int[][] arr = new int[5][5];
        arr[2][3] = -1;
        arr[2][2] = -1;
        arr[3][2] = -1;
        maze.setMaze(arr);

        maze.setSource(1,1);
        maze.setTarget(4,4);

        System.out.println(maze.target);

        maze.printMaze();

        maze.solveMaze();

        System.out.println(maze.target);

    }





}
