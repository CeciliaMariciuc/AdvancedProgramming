import java.util.Arrays;

public class Board {
    private int[][] matrix;

    public Board() {
        matrix = new int[15][15];
    }

    boolean movePiece(int lin, int col, String player) {
        if (matrix[lin][col] == 0) {
            if (player.equals("Player1")) {
                matrix[lin][col] = 1;
            } else {
                matrix[lin][col] = 2;
            }
            return true;
        }
        return false;
    }

    String getMatrixToString() {
        String stringMatrix = "";
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                stringMatrix = stringMatrix.concat(Integer.toString(matrix[i][j]));
               // stringMatrix = stringMatrix.concat(" ");
            }
        }
        return stringMatrix;
    }


    public int[][] getMatrix() {
        return matrix;
    }
}
