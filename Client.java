package nyc.c4q.madelynTav;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * Created by c4q-madelyntavarez on 10/17/15.
 */
public class Client
{
    public static void main(String[] args) throws IOException
    {
        Socket client= new Socket("localhost",3456);

        PrintWriter out = new PrintWriter(client.getOutputStream(),true);
        Scanner scanner= new Scanner(System.in);
        int timeOffset=scanner.nextInt();

        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("hh:mm:ss");
        TimeZone timeZone= new SimpleTimeZone(timeOffset,"2");
        simpleDateFormat.setTimeZone(timeZone);
        System.out.println(timeZone);
        System.out.println(simpleDateFormat.toString());
        out.print(simpleDateFormat.getCalendar());


        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(bufferedReader.readLine());

        client.close();
    }
}
