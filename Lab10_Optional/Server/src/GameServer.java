import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private List<Game> gameList = new ArrayList<>();
    public static final int PORT = 8100;
    private Game currentGame;

    public boolean createGame(String id) {
        Game game = new Game(id);
        game.addPlayer(new Player("Player1"));
        if (gameList.contains(game)) {
            return false;
        }
        gameList.add(game);
        currentGame = game;
        return true;
    }

    public boolean joinGame(String id) {
        for (Game game : gameList) {
            if (game.getId().equals(id)) {
                Player player = new Player("Player2");
                game.addPlayer(player);
                currentGame = game;
                return true;
            }
        }
        return false;
    }

    public String submitMove(Game game, String player, int lin, int col) {
        System.out.println(lin);
        System.out.println(col);
        if (lin < 0 || lin >= 15 || col < 0 || col >= 15) {
            return "Pozitie invalida!";
        }
        if (game.getBoard().movePiece(lin, col, player)) {
            return game.getBoard().getMatrixToString();
        }
        return "Pozitia este deja ocupata!";
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Server is running ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket, this).start();
            }
        } catch (IOException exception) {
            System.err.println("Exception " + exception);
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }
}
