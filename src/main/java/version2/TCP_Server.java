package version2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {
    public static void someMethod() throws Exception {
        TCP_Client b = new TCP_Client();
        Thread t = new Thread(b);
        t.start();

        ServerSocket server = new ServerSocket(6790);

        System.out.println("I am waiting for new Client, for new Connection :)");

        Socket connection = server.accept(); //waiting for Client/Connection

        InputStream is = connection.getInputStream();
        InputStreamReader isR = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isR);
        String messageFromClient = reader.readLine();
        System.out.println("Clients message: " + messageFromClient);

        server.close();
    }

    public static void main(String[] args) throws Exception {
        someMethod();
    }

    static class TCP_Client implements Runnable {
        public void run() {
            try (
                    Socket client = new Socket("127.0.0.1", 6789);
                    OutputStream os = client.getOutputStream();
                    OutputStreamWriter osW = new OutputStreamWriter(os);
                    BufferedWriter bW = new BufferedWriter(osW);
            ) {
                bW.write("Salam Server :)");
            } catch (Exception ex) {
                System.out.println("Meow Exception :D");
            }
        }
    }

}
