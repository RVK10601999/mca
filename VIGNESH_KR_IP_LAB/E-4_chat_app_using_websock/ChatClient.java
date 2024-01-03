import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends JFrame {
    private Socket socket;
    private Scanner in;
    private PrintWriter out;

    private JTextArea chatArea;
    private JTextField messageField;

    public ChatClient() {
        setTitle("Chat Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane);

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(messageField.getText());
                messageField.setText("");
            }
        });
        add(messageField, BorderLayout.SOUTH);

        connectToServer();

        setVisible(true);
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 12345);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            new Thread(new ServerListener()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        out.println(message);
    }

    private void appendMessage(String message) {
        chatArea.append(message + "\n");
    }

    private class ServerListener implements Runnable {
        @Override
        public void run() {
            try {
                while (in.hasNextLine()) {
                    String message = in.nextLine();
                    appendMessage(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatClient();
            }
        });
    }
}
