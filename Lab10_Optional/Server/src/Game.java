import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private String id;
    private Board board;
    private List<Player> playerList;

    public Game(String id) {
        this.id = id;
        playerList = new ArrayList<>();
        this.board = new Board();
    }

    public String getId() {
        return id;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id.equals(game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
