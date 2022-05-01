import java.util.Scanner;


public class Game {
    Scanner scanner = new Scanner(System.in);

    public void play() {
        Board playerBoard = new Board();
        Board computerBoard = new Board();
        displayBoard(playerBoard.board, computerBoard.board);
        System.out.println("Now it's time to place your ships");
        System.out.println("You will place 5 ships, all will be 3 pegs in length.");
        System.out.println("First you will be asked to enter the starting co-ordinates of your ship. Enter the letter then the number like this: B3 ");
        System.out.println("Then you will be asked for the direction of your ships, Enter D for down and R for right.");
        for (int i = 0; i < 5; i++) {
            setUpPlayerBoard(playerBoard);
            setUpComputerBoard(computerBoard);
        }

        displayBoard(playerBoard.board, computerBoard.board);
        // display board
        //ask user where to hit
        //display hit, miss, sunk
        //computers turn
        //if won end game
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
            int[] validPoints = IO.getPoints(scanner);
            System.out.println(validPoints[1] + "," + validPoints[0]);
            Direction direction = IO.getDirection(scanner);

            System.out.println(direction);

            checkEmptySpot = board.checkFreeSpace(validPoints, direction);
            System.out.println(checkEmptySpot);
            System.out.println(count);
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
            }
        }
    }

}

