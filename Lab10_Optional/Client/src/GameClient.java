import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    String serverAddress = "127.0.0.1";
    int PORT = 8100;

    public void displayMatrix(String matrix) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.printf("%c ", matrix.charAt(i * 15 + j));
            }
            System.out.print("\n");
        }
    }

    public GameClient() {
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Introduceti comanda: ");
        while (!(command = scanner.nextLine()).equals("exit")) {
            try (
                    Socket socket = new Socket(serverAddress, PORT);
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                printWriter.println(command);
                String response = reader.readLine();
                if (command.contains("submit move")) {
                    if (!response.equals("Pozitie invalida!") && !response.equals("Pozitia este deja ocupata!")) {
                        displayMatrix(response);
                    }
                }
                else {
                    System.out.println(response);
                }
            } catch (UnknownHostException exception) {
                System.err.println("No server listening... " + exception);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        System.out.println("Client closed");
    }

    public static void main(String[] args) {
        new GameClient();
    }
}
