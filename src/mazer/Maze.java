package mazer;

public class Maze {

    Node[][] maze;

    //some comment
    @Override
    public String toString() {
        return "Maze is " +
                ((this.target) ? "solved! \n took: " + this.target.distance + " moves" : "not solved!");
    }

    public void printTable () {
        //TODO: Implement
    }
}
