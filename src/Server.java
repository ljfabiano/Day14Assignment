import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

/**
 * Created by jfabiano on 8/25/2016.
 */
public class Server {
    //Socket connection;
    //public Server()
    //{

    //}
    //public Server(Socket incomingConnection)
    //{
    //    this.connection = incomingConnection;
    //}
    public void setConnection()
    {
        try {
            System.out.println("Server called");
            ServerSocket serverListener = new ServerSocket(8005);
            while(true) {
                //ServerSocket serverListener = new ServerSocket(8005);
                Socket clientSocket = serverListener.accept();//create new connection handler just accepted, and create the connection handler object, then create the thread, and then pass it the thread
                ConnectionHandler myHandler = new ConnectionHandler(clientSocket);
                Thread handlingThread = new Thread(myHandler);
                handlingThread.start();
            }
            //Thread myThread = new Thread();
            //myHandler.
//            while (true)
//            {
//                //Socket incomingConnection = serverListener.accept();
//                //Server handlingServer = new Server(incomingConnection);
//                //Thread handlingThread = new Thread(handlingServer);
//                //handlingThread.start();
//                //hanleIncomintConnection(incomingConnection);
//            }
            //ServerSocket serverListener = new ServerSocket(8005);
        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }
    /*public void handleInput() {
        try

        {
            // start a server on a specific port. This is what needs to happen in a thread
            //ServerSocket serverListener = new ServerSocket(8005);
            //Socket clientSocket = serverListener.accept();//
            System.out.println("Server called");
            ServerSocket serverListener = new ServerSocket(8005);
            Socket clientSocket = serverListener.accept();//

            // display information about who just connected to our server
            System.out.println("Incoming connection from " + clientSocket.getInetAddress().getHostAddress());

            // this is how we read from the client
            BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // this is how we write back to the client
            PrintWriter outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);

            // read from the input until the client disconnects
            String inputLine = "Initial value";
            //(inputLine = inputFromClient.readLine()) != null
            while (true)
            {
                Socket incomingConnection = serverListener.accept();
                SampleServer handlingServer = new SampleServer(incomingConnection);
                Thread handlingThread = new Thread(handlingServer);
                handlingThread.start();
                //hanleIncomintConnection(incomingConnection);
            }
//            while ((inputLine = inputFromClient.readLine()) != null) {
//                //Socket clientSocket = serverListener.accept();
//                System.out.println("Received message: " + inputLine + " from " + clientSocket.toString());
//                outputToClient.println("Message received loud and clear");
//            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }*/
}
