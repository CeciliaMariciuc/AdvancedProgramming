import java.util.Random;

public class Optional {

    public static void main(String[] args) {
        String[] words = new String[100];
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        for (int j = 0; j < n; j++) {
            Random rand = new Random();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < k; i++) {
                int c = rand.nextInt(args.length - 2) + 2;
                s.append(args[c]);
            }
            words[j] = s.toString();
        }
        for (int j = 0; j < n; j++) {
            System.out.printf("%s ", words[j]);
        }
        boolean[][] m = new boolean[100][100];
        int test, k1, k2, i, j;
        int nrMax = 0;
        int nrMin = 100;

        int[] nrVecini = new int[100];
        for (i = 0; i < n; i++) {
            nrVecini[i] = 0;
            for (j = 0; j < n; j++) {
                if (i != j) {
                    test = 0;
                    for (k1 = 0; k1 < words[i].length() && test == 0; k1++) {
                        for (k2 = 0; k2 < words[j].length() && test == 0; k2++) {
                            if (words[i].charAt(k1) == words[j].charAt(k2)) {
                                test = 1;
                            }
                        }
                    }
                    if (test == 1) {
                        m[i][j] = true;
                        m[j][i] = true;
                        nrVecini[i]++;
                    }
                }
            }
            if (nrVecini[i] > nrMax) nrMax = nrVecini[i];
            if (nrVecini[i] < nrMin) nrMin = nrVecini[i];
        }
     /*   System.out.printf("\n");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.printf("%B ", m[i][j]);
            }
            System.out.printf("\n");
        }
        for (i = 0; i < n; i++) {
            if (nrVecini[i] == nrMax) System.out.printf("%s ", words[i]);
        }
        System.out.printf("\n");
        for (i = 0; i < n; i++) {
            if (nrVecini[i] == nrMin) System.out.printf("%s ", words[i]);
        }*/
        System.out.print("\n");
        //Bonus- Verify if the graph represented by the adjacency matrix created previously is connected - Display the words contained in each connected component.
        int[] visited = new int[100];
        int nrComponents = 0;

        for (i = 0; i < n; i++) {
            if (visited[i] == 0) {
                nrComponents++;
                dfs(i, n, nrComponents, m, visited);
            }
        }
        if (nrComponents == 1) {
            System.out.println("This graph is connected!");
        } else {
            System.out.printf("This graph is not connected. Number of connected components: %d\n", nrComponents);
            for (i = 1; i <= nrComponents; i++) {
                for (j = 0; j < n; j++) {
                    if (visited[j] == i) {
                        System.out.printf("%s ", words[j]);
                    }
                }
                System.out.print("\n");
            }
        }
    }

    public static void dfs(int node, int n, int nrComp, boolean[][] matrix, int[] visited) {
        visited[node] = nrComp;
        for (int i = 0; i < n; i++) {
            if ((visited[i] == 0) && matrix[node][i]) {
                visited[i] = nrComp;
                dfs(i, n, nrComp, matrix, visited);
            }
        }
    }
}
