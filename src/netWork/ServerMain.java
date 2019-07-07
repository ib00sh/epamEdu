package netWork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            socket = server.accept(); // клиент подключился
            System.out.println("Клиент подключился");

            Scanner sc = new Scanner(socket.getInputStream()); //спрашиваем входящий поток

            while (true){
                String string = sc.nextLine();
                if(string.equals("/end")){
                    break;
                }
                System.out.println("Клиент " + string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
