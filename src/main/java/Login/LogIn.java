package Login;

import BattleShips.Game;
import Console.ConsoleInput;
import Player.Player;
import Player.AllPlayers;
import java.util.List;

public class LogIn {
    private final Game game = new Game();
    public static ConsoleInput userInput = new ConsoleInput();
    public boolean loggedIn = false;

    private String getPassword(String emailAddress) {
        AllPlayers allPlayers = new AllPlayers();
        String password = "";
        List<Player> listOfPlayers = allPlayers.getListOfPlayers();
        for (Player player : listOfPlayers) {
            if (player.getEmailAddress().equals(emailAddress)) {
                password = player.getPassword();
            }
        }
        return password;
    }

    public boolean logIn() {
        String emailAddress = userInput.input("Enter email address");
        String password = getPassword(emailAddress);

        if (password == "") {
            System.out.println("You are not a user");
        } else if (password.equals(userInput.input("Enter password"))) {
            System.out.println("You are logged in");
            loggedIn = true;
        } else {
            System.out.println("Wrong password, no second chances");
        }
        return loggedIn;


    }

    public void play() {
        game.play();
    }

    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        boolean loggedIn = logIn.logIn();
        if (loggedIn) {
            logIn.play();

        }
    }
}