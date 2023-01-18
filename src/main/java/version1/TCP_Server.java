package version1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(6789);
        while (true) {
            System.out.println("I am waiting for new Client, for new Connection :)");
            Socket connection = server.accept(); //waiting for Client/Connection

            InputStream is = connection.getInputStream();
            InputStreamReader isR = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isR);
            String messageFromClient = reader.readLine();
            System.out.println("Clients message: " + messageFromClient);
        }

    }
}
