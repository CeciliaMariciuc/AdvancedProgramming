import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Token> tokens;
    int tokenNumber;

    public Board(int tokenNr) {
        tokenNumber = tokenNr;
        tokens = new ArrayList<>();
        for (int count = 0; count < tokenNumber; count++) {
            tokens.add(new Token(count));
        }
        Collections.shuffle(tokens);
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public synchronized Token getOneToken(int number){
        Token token = tokens.get(number);
        tokens.remove(number);
        return token;
    }
}
