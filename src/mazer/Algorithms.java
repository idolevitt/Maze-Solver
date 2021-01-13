package mazer;

import java.util.LinkedList;
import java.util.Queue;

public class Algorithms {

    /**
     * solves the maze using addAdjacents
     *
     *
     */
    public static void BFS(Maze maze) {
        Queue<Node> q = new LinkedList<>();
        addAdjacentsToQ(maze, q, maze.source.row, maze.source.col, 0);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            addAdjacentsToQ(maze, q, cur.row, cur.col, cur.distance);
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
    private static void addAdjacentsToQ(Maze maze, Queue<Node> q, int row, int col,int dist) {

        //updates the node to the right:
        addAdjacent(maze, q, row, col + 1, dist);
        //updates the node to the left:
        addAdjacent(maze, q, row, col - 1, dist);
        //updates the node above:
        addAdjacent(maze, q, row + 1, col, dist);
        //updates the node below:
        addAdjacent(maze, q, row - 1, col, dist);

    }

    private static void addAdjacent(Maze maze, Queue<Node> q, int row, int col, int dist){

        if (!maze.isInBounds(row, col))
            return;

        Node node = maze.maze[row][col];

        if (node.isNode && !node.marked) {
            node.distance = dist + 1;
            node.marked = true;
            // check if got to target
            if (maze.target == node) {
                maze.printMaze();
            }
            q.add(node);
        }
    }
}
