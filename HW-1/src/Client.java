import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Client extends Application {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    private TextArea chatArea;
    private TextField messageField;
    private PrintWriter writer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chat Client");

        chatArea = new TextArea();
        chatArea.setEditable(false);

        messageField = new TextField();
        messageField.setOnAction(event -> sendMessage());

        Button sendButton = new Button("Send");
        sendButton.setOnAction(event -> sendMessage());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(chatArea, messageField, sendButton);

        primaryStage.setScene(new Scene(layout, 400, 300));
        primaryStage.show();

        connectToServer();
        loadChatHistory();
    }

    private void connectToServer() {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream(), true);

            new Thread(() -> {
                String message;
                try {
                    while ((message = reader.readLine()) != null) {
                        Platform.runLater(() -> chatArea.appendText(message + "\n"));
                        saveChatHistory(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            writer.println(message);
            messageField.setText("");
        }
    }

    private void loadChatHistory() {
        try {
            Path historyPath = Paths.get("chat_history.txt");
            if (Files.exists(historyPath)) {
                Files.lines(historyPath).forEach(line -> chatArea.appendText(line + "\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveChatHistory(String message) {
        try {
            Path historyPath = Paths.get("chat_history.txt");
            Files.write(historyPath, (message + "\n").getBytes(), java.nio.file.StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}