import java.util.List;

public class Game {
    private Board board;
    private List<Player> playerList;
    private boolean finished;
    private int progrSize;

    public Game(Board board, List<Player> playerList, int progrSize) {
        this.board = board;
        this.playerList = playerList;
        this.finished = false;
        this.progrSize = progrSize;
        for(Player player : playerList){
            player.setGame(this);
        }
    }

    public void playGame(){
        for(Player player : playerList){
            new Thread(player).start();
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public synchronized void setFinished() {
        this.finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getProgrSize() {
        return progrSize;
    }

    public void setProgrSize(int progrSize) {
        this.progrSize = progrSize;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
