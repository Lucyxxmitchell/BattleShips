package Login;

import BattleShips.Game;
import Console.ConsoleInput;
import Player.Player;
import Player.AllPlayers;
import java.util.List;

public class LogIn {
    private final Game game = new Game();


    private String getPassword(String emailAddress){
        AllPlayers allPlayers = new AllPlayers();
        String password = "";
        List<Player> listOfPlayers = allPlayers.getListOfPlayers();
        for (Player player : listOfPlayers){
            if (player.getEmailAddress().equals(emailAddress)){
                password = player.getPassword();
            }
        }
        return password;
    }

    public void logIn() {
        String emailAddress = ConsoleInput.input("Enter email address");
        String password = getPassword(emailAddress);
        boolean loggedIn = false;

        if (password == "") {
            System.out.println("You are not a user");
        }
        else if (password.equals(ConsoleInput.input("Enter password"))){
            System.out.println("You are logged in");
            loggedIn = true;
        }
        else {
            System.out.println("Wrong password, no second chances");
        }
        if (loggedIn) {
            game.play();
        }
    }

    public void play(){
        game.play();
    }

    public static void main(String[] args){
        LogIn logIn = new LogIn();
//        logIn.logIn();
        logIn.play();
    }
}