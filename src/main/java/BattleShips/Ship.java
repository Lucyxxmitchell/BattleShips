package BattleShips;

public class Ship {
    int x;
    int y;
    Direction dir;

    BoardStates[] health = {BoardStates.CONTAINS_SHIP, BoardStates.CONTAINS_SHIP, BoardStates.CONTAINS_SHIP, BoardStates.CONTAINS_SHIP, BoardStates.CONTAINS_SHIP};

    public void update(int[] coordinates) {
        //check if given coordinates are in this ship
        //if so work out which segment is hit
        //update that segment i.e. health[segment#]
    }


    public Ship(int x, int y, Direction d) {
        this.x = x;
        this.y = y;
        this.dir = d;
    }

    public boolean isSunk() {
        for (BoardStates segment : health) {
            if (segment.equals(BoardStates.CONTAINS_SHIP)) {
                return false;
            }
        }
        return true;
    }

}
