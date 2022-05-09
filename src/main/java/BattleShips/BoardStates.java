package BattleShips;

public enum BoardStates {
    EMPTY(" "),
    CONTAINS_SHIP("@"),
    DESTROYED("X"),
    QUERIED("O");

    private final String label;

    BoardStates(String label) {
        this.label = label;
    }

    @Override
    public String toString(){
        return label;
    }
}