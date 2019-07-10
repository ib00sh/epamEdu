package netWork.client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Conroller implements Initializable {
    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        while (true){
                            String string = in.readUTF();
                            if(string.equals("/serverClosed")) break;
                            textArea.appendText(string + "\n");
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            t1.setDaemon(true);
            t1.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMsg(){
        try {
            out.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
