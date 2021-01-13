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

        arr[3][1] = -1;
        arr[1][3] = -1;
        maze.setMaze(arr);

        maze.setSource(1,1);
        maze.setTarget(3,3);

        System.out.println(maze.target);

        maze.printMaze();

        Algorithms.BFS(maze);

        System.out.println(maze.target);

        Maze hardPathExample = new Maze(5);

        // s - source, t - target , * - block
        // 0  0  0  1  t
        // 0  1  0  1  0
        // 0  1  0  1  0
        // 0  1  0  1  0
        // s  1  0  0  0

        int[][] mazeArray = new int[5][5];
        for (int i = 0; i < 4; i++) {
            mazeArray[i + 1][1] = -1;
            mazeArray[i][3] = -1;
        }
        hardPathExample.setMaze(mazeArray);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(mazeArray[i][j] + "\t");
            }
            System.out.println();
        }

        hardPathExample.setSource(4,0);
        hardPathExample.setTarget(0,4);
        hardPathExample.printMaze();

        Algorithms.BFS(hardPathExample);

    }





}
