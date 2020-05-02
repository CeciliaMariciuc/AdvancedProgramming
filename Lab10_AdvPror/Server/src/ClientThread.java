import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            System.out.println("Request receive from client: "+request);
            if (request.equals("stop")) {
                String response = "Server stopped!";
                printWriter.println(response);
                printWriter.flush();
                socket.close();
                System.exit(0);
            } else {
                String response = "Server received the request ... " + request;
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
