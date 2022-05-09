package BattleShips;

public class Ship {
    int x;
    int y;
    Direction dir;

    BoardStates[] health = {BoardStates.CONTAINS_SHIP, BoardStates.CONTAINS_SHIP, BoardStates.CONTAINS_SHIP, BoardStates.CONTAINS_SHIP, BoardStates.CONTAINS_SHIP};

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
