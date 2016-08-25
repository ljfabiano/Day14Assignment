import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by jfabiano on 8/25/2016.
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("This is the client");

        try {

            // connect to the server on the target port
            Socket clientSocket = new Socket("10.0.0.139", 8005);

            // once we connect to the server, we also have an input and output stream
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // send the server an arbitrary message
            out.println("Marvin says hello!");
           Thread.sleep(2000);
                // read what the server returns
                String serverResponse = in.readLine();
            System.out.println("server response = " + serverResponse);

            // close the connection
            clientSocket.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
