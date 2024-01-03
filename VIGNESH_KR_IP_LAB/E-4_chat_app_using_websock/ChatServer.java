import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServer {
    private List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) {
        new ChatServer().startServer();
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is running on port 12345");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(writer);

                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message, PrintWriter sender) {
        for (PrintWriter client : clients) {
            if (client != sender) {
                client.println(message);
            }
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private Scanner in;

        public ClientHandler(Socket socket) {
            this.socket = socket;

            try {
                this.in = new Scanner(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (in.hasNextLine()) {
                    String message = in.nextLine();
                    broadcastMessage(message, null);
                }
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
