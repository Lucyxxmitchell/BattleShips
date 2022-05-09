package BattleShips;

public class Game {

    public void play() {
        Board playerBoard = new Board();
        Board computerBoard = new Board();
        displayBoard(playerBoard.board, computerBoard.board);
        IO.displayInstructions();
        for (int i = 0; i < 5; i++) {
            setUpPlayerBoard(playerBoard);
            setUpComputerBoard(computerBoard);
        }
        displayBoard(playerBoard.board, computerBoard.board);
        System.out.println("Game In the works...Come back another time to play");
    }

    public void displayBoard(BoardStates[][] playerBoard, BoardStates[][] computerBoard) {
        System.out.println("     Y O U          C O M P U T E R  ");
        System.out.println("   0123456789          0123456789");

        for (int i = 0; i < playerBoard.length; i++) {
            char c = (char) ('A' + i);
            System.out.print(c + " |");

            for (int j = 0; j < playerBoard[i].length; j++) {
                System.out.print(playerBoard[i][j]);
            }

            System.out.print("| " + "    " + c + " | ");
            for (int j = 0; j < computerBoard[i].length; j++) {
                if (!(computerBoard[i][j].equals( BoardStates.CONTAINS_SHIP))) {
                    System.out.print(computerBoard[i][j]);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("| ");
        }
    }

    public void setUpPlayerBoard(Board board) {
        boolean checkEmptySpot = false;
        int count = 0;

        while (!checkEmptySpot) {
            int[] validPoints = IO.getPoints();
            Direction direction = IO.getDirection();

            checkEmptySpot = board.checkFreeSpace(validPoints, direction);

            count = count + 1;
            if (checkEmptySpot) {
                board.place(validPoints, direction);

            }
        }
    }
    public void setUpComputerBoard(Board board){
        boolean checkEmptySpot = false;

        while (!checkEmptySpot) {
            int[] computerPoints = Computer.getComputerPoints();
            Direction direction = Computer.getComputerDirection();
            checkEmptySpot = board.checkFreeSpace(computerPoints, direction);
            if (checkEmptySpot){
                board.place(computerPoints, direction);
                System.out.println("SHIP PLACED SUCCESSFULLY");
            }
        }
    }

}

