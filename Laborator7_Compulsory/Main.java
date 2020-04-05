import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Player> playerList = Arrays.asList(new Player("Ana"), new Player("Mihai"));
        Game game = new Game(new Board(20), playerList,10);
        game.playGame();
        /*
        if(!game.isFinished()){
            playerList = game.getPlayerList();
            int largestProgr=0;
            Player winner = null;
            for(Player player : playerList) {
                if (player.getLargestProgr() > largestProgr) {
                    largestProgr = player.getLargestProgr();
                    winner = player;
                }
            }
            System.out.println(winner.getName() + " a castigat!");
        }
        */
    }
}
