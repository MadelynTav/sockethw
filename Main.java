package nyc.c4q.madelynTav;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//server
public class Main {

    public static void main(String[] args) throws IOException
    {
         ServerSocket ss= new ServerSocket(3456);

        while (!ss.isClosed()){
            Socket socket= ss.accept();
            BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Received: "+reader.readLine());

            PrintWriter printWriter= new PrintWriter(socket.getOutputStream(),true);
            printWriter.print("Time To fish");

            socket.close();
        }
    }
}
