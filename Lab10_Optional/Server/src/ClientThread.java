import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null;
    GameServer gameServer;

    public ClientThread(Socket socket, GameServer gameServer) {
        this.socket = socket;
        this.gameServer = gameServer;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            System.out.println("Request receive from client: " + request);
            if (request.equals("stop")) {
                String response = "Server stopped!";
                printWriter.println(response);
                printWriter.flush();
                socket.close();
                System.exit(0);
            } else {
                String response = null;
                if (request.contains("create game")) {
                    boolean result = gameServer.createGame(request.substring(12));
                    if (result) {
                        response = "Jocul a fost creat! Bun venit player 1!";
                    } else {
                        response = "Exista deja un joc cu acest nume!";
                    }
                }
                if (request.contains("join game")) {
                    boolean result = gameServer.joinGame(request.substring(10));
                    if (result) {
                        response = "Ai intrat in joc! Bun venit player 2!";
                    } else {
                        response = "Nu exista un joc cu acest nume!";
                    }
                }
                if (request.contains("submit move")) {
                    String[] splitReq = request.trim().split("\\s+");
                    response = gameServer.submitMove(gameServer.getCurrentGame(),splitReq[2],Integer.parseInt(splitReq[3]),Integer.parseInt(splitReq[4]));
                }
                printWriter.println(response);
                printWriter.flush();
            }
        } catch (IOException exception) {
            System.err.println("Communication error... " + exception);
        } finally {
            try {
                socket.close();
            } catch (IOException exception) {
                System.err.println(exception);
            }
        }
    }
}
