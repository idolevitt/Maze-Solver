package mazer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        addAdjacent(maze, q, row, col + 1, dist, maze.maze[row][col]);
        //updates the node to the left:
        addAdjacent(maze, q, row, col - 1, dist, maze.maze[row][col]);
        //updates the node above:
        addAdjacent(maze, q, row + 1, col, dist, maze.maze[row][col]);
        //updates the node below:
        addAdjacent(maze, q, row - 1, col, dist, maze.maze[row][col]);

    }

    private static void addAdjacent(Maze maze, Queue<Node> q, int row, int col, int dist, Node parent){

        //checks if indexes are valid
        if (!maze.isInBounds(row, col))
            return;

        Node node = maze.maze[row][col];

        if (node.isNode && !node.marked) {
            node.distance = dist + 1;
            node.marked = true;
            node.parent = parent;
            // check if got to target
            if (maze.target == node) {
                maze.printMaze();
            }
            q.add(node);
        }
    }


    public static void DFS(Maze maze) {

        Stack<Node> s = new Stack<>();
        maze.source.marked = true;
        s.push(maze.source);

        while(!s.isEmpty()) {
            Node vertex = s.peek();
            Node unmarkedNeighbor = getUnmarkedNeighbor(maze, vertex);
            if(unmarkedNeighbor == null)
                s.pop();
            else{
                unmarkedNeighbor.parent = vertex;
                unmarkedNeighbor.distance = vertex.distance + 1;
                unmarkedNeighbor.marked = true;
                //////////////////////////////////////////////
                /**
                 * THIS ONE IS OPTIONAL IF YOU WANT TO STOP
                 * THE ALGORITHM WHEN IT GETS TO TARGET
                 */
                /*
                if(unmarkedNeighbor == maze.target) {
                    s.clear();
                    return;
                }
                */
                //////////////////////////////////////////////
                s.push(unmarkedNeighbor);
            }
        }
    }

    public static Node getUnmarkedNeighbor(Maze maze, Node n) {

        int row = n.row;
        int col = n.col;
        // The node to the left:
        if (maze.isInBounds(row, col - 1) && maze.maze[row][col - 1].isNode && !maze.maze[row][col - 1].marked)
            return maze.getNode(row, col - 1);
        // The node to the right:
        if (maze.isInBounds(row, col + 1) && maze.maze[row][col + 1].isNode && !maze.maze[row][col + 1].marked)
            return maze.getNode(row, col + 1);
        // The node above:
        if (maze.isInBounds(row + 1, col) && maze.maze[row + 1][col].isNode && !maze.maze[row + 1][col].marked)
            return maze.getNode(row + 1, col);
        // The node below:
        if (maze.isInBounds(row - 1, col) && maze.maze[row - 1][col].isNode && !maze.maze[row - 1][col].marked)
            return maze.getNode(row - 1, col);

        return null;
    }
}
