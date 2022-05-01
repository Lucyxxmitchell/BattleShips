import java.util.List;
import java.util.Scanner;

public class LogIn {
    private final Scanner userInput = new Scanner(System.in);
    private final Game game = new Game();

    private String input(String message) {
        System.out.println(message);
        return userInput.nextLine();
    }

    private String getPassword(String emailAddress){
        AllCustomers allCustomers = new AllCustomers();
        String password = "";
        List<Customer> listOfCustomers = allCustomers.getListOfCustomers();
        for (Customer customer :listOfCustomers){
            if (customer.getEmailAddress().equals(emailAddress)){
                password = customer.getPassword();
            }
        }
        return password;
    }

    public void logIn() {
        String emailAddress = input("Enter email address");
        String password = getPassword(emailAddress);
        boolean loggedIn = false;

        if (password == "") {
            System.out.println("You are not a user");
        }
        else if (password.equals(input("Enter password"))){
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