package mazer;

public class Main {

    public static void main(String[] args) {

        //////////////////
        //  Example 1:  //
        //////////////////


        Maze maze = new Maze(5);

        // s - source, t - target , * - block
        // 0  0  0  0  0
        // 0  s  0  0  0
        // 0  0  *  *  0
        // 0  0  *  t  0
        // 0  0  0  0  0


        //Setting the blocks:

        int[][] arr = new int[5][5];
        arr[2][3] = -1;
        arr[2][2] = -1;
        arr[3][2] = -1;
        maze.setMaze(arr);

        //Setting source and target:

        maze.setSource(1,1);
        maze.setTarget(3,3);

        maze.setMaze(arr);

        System.out.println(maze.target);

        maze.printMaze();

        //Solve:

        Algorithms.BFS(maze);

        System.out.println(maze.target);

        //////////////////
        //  Example 2:  //
        //////////////////


        Maze hardPathExample = new Maze(5);

        // s - source, t - target , * - block
        // 0  0  0  *  t
        // 0  *  0  *  0
        // 0  *  0  *  0
        // 0  *  0  *  0
        // s  *  0  0  0

        //Setting the blocks:

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

        //Setting source and target:

        hardPathExample.setSource(4,0);
        hardPathExample.setTarget(0,4);
        hardPathExample.printMaze();

        //Solve:

        Algorithms.DFS(hardPathExample);

        System.out.println(hardPathExample.target.marked);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(hardPathExample.maze[i][j].marked == true)
                    System.out.print(1 + "\t");
                else
                    System.out.print(0 + "\t");

            }
            System.out.println();
        }

    }





}
