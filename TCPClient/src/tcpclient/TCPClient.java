package tcpclient;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class TCPClient {
 public static void main(String[] args) {
        try{
            Socket clientSocket = new Socket ("localhost",8000);
            DataOutputStream outToServer = new DataOutputStream (clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader (new InputStreamReader(System.in));
            int j =0;
            String Result;
            Scanner input = new Scanner(System.in);
            while(j<5){
               int c = input.nextInt();
               outToServer.writeInt(c);
               Result = inFromServer.readLine();
               System.out.println( Result);
               j=j+1;
            }
        }
        catch(SocketTimeoutException e){}
        catch(SocketException e){}
        catch(IOException e){}
    }
    
}
