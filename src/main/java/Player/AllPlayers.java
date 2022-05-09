package Player;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import ReadFile.ReadDelimitedFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllPlayers {
    private final List<Player> listOfPlayers = new ArrayList();
    private boolean PlayersLoaded = false;

    public AllPlayers() {
    }

    private List<String[]> loadRawPlayers() {
        ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
        return readDelimitedFile.getFileData("accounts.csv");
    }

    private List<Player> loadAsPlayers() {
        List<String[]> rawPlayers = this.loadRawPlayers();
        Iterator var2 = rawPlayers.iterator();

        while(var2.hasNext()) {
            String[] rawPlayer = (String[])var2.next();
            this.listOfPlayers.add(new Player(rawPlayer[0], rawPlayer[1], rawPlayer[2], rawPlayer[3]));
        }

        this.PlayersLoaded = true;
        return this.listOfPlayers;
    }

    public List<Player> getListOfPlayers() {
        if (!this.PlayersLoaded) {
            this.loadAsPlayers();
        }

        return this.listOfPlayers;
    }
}
