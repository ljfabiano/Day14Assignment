import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by jfabiano on 8/25/2016.
 */
public class ConnectionHandler implements Runnable{
    Socket connection;
    public ConnectionHandler()
    {

    }
    public ConnectionHandler(Socket incomingConnection)
    {
        this.connection = incomingConnection;
    }
    public void run()
    {
        handleInput();
    }
    public void handleInput() {
        try

        {
            // start a server on a specific port. This is what needs to happen in a thread
            //ServerSocket serverListener = new ServerSocket(8005);
            //Socket clientSocket = serverListener.accept();//
//Server myServer = new Server(connection);
            // display information about who just connected to our server
            System.out.println("Incoming connection from " + connection.getInetAddress().getHostAddress());

            // this is how we read from the client
            BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(this.connection.getInputStream()));
            // this is how we write back to the client
            PrintWriter outputToClient = new PrintWriter(this.connection.getOutputStream(), true);

            // read from the input until the client disconnects
            String inputLine = "Initial value";
            //(inputLine = inputFromClient.readLine()) != null
//            while (true)
//            {
//                //Socket incomingConnection = .accept();
//                //Server handlingServer = new Server(incomingConnection);
//                Thread handlingThread = new Thread();
//                handlingThread.start();
//                //hanleIncomintConnection(incomingConnection);
//            }
            while ((inputLine = inputFromClient.readLine()) != null) {
                //Socket clientSocket = serverListener.accept();
                System.out.println("Received message: " + inputLine + " from " + connection.toString());
                outputToClient.println("Message received loud and clear");
            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
