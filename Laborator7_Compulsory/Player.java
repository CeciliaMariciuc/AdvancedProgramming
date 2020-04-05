import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private Game game;
    private List<Token> extractedTokens;
    private int largestProgr;

    public Player(String name) {
        this.name = name;
        extractedTokens = new ArrayList<>();
        this.largestProgr = 0;
    }

    @Override
    public void run() {
        while (!game.getBoard().getTokens().isEmpty() && !game.isFinished()) {
            Token token = this.extractToken(0);
            extractedTokens.add(token);
            System.out.println(name + " a ales : " + token);
           /* if (extractedTokens.size() >= game.getProgrSize()) {
                if (this.checkProgression(game.getProgrSize())) {
                    System.out.println(name + " a castigat! ");
                    game.setFinished();
                    break;
                }
            }
            */
        }

    }

    public synchronized Token extractToken(int number) {
        Board board = game.getBoard();
        Token token = board.getOneToken(number);
        return token;
    }

    public Boolean checkProgression(int k) {
        extractedTokens.sort(Comparator.comparing(Token::getNumber));
        //System.out.println(extractedTokens);
        int ration = extractedTokens.get(1).getNumber() - extractedTokens.get(0).getNumber();
        int progrSize = 2;
        if (progrSize > this.largestProgr) {
            this.setLargestProgr(progrSize);
        }
        for (int count = 2; count < extractedTokens.size(); count++) {
            if ((extractedTokens.get(count).getNumber() - extractedTokens.get(count - 1).getNumber()) != ration) {
                progrSize = 2;
                ration = extractedTokens.get(count).getNumber() - extractedTokens.get(count - 1).getNumber();
            } else {
                progrSize++;
            }
            if (progrSize > this.largestProgr) {
                this.setLargestProgr(progrSize);
            }
            if (progrSize >= k) {
                return true;
            }
        }
        return false;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getLargestProgr() {
        return largestProgr;
    }

    public void setLargestProgr(int largestProgr) {
        this.largestProgr = largestProgr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
