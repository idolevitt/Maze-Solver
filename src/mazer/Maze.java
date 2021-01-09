package mazer;

public class Maze {

    Node[][] maze;

    /**
     * prints if there is path from source to target.
     * if solved prints length of path
     * @return solved or not and num of moves
     */
    @Override
    public String toString() {
        return "Maze is " +
                ((this.target) ? "solved! \n took: " + this.target.distance + " moves" : "not solved!");
    }

    public void printTable () {
        //TODO: Implement
    }
}
