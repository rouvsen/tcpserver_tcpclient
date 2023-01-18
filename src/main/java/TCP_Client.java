import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCP_Client {
    public static void main(String[] args) throws Exception {

        try (
                Socket client = new Socket("127.0.0.1", 6789);
                OutputStream os = client.getOutputStream();
                OutputStreamWriter osW = new OutputStreamWriter(os);
                BufferedWriter bW = new BufferedWriter(osW);
        ) {
            bW.write("Salam Server :)");
        }

    }
}
