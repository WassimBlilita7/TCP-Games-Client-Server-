package tcpserver;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) throws IOException {
         ServerSocket welcomeSocket = new ServerSocket(7000);
         Scanner input = new Scanner(System.in);
         int a = input.nextInt();
         Thread t = new Thread(new Accepter_clients(welcomeSocket,a));
         t.start();
         System.out.println("Serveur prét:!");        
    }
    
}
class Accepter_clients implements Runnable{
    ServerSocket socketserver;
    int n;
    int i =0;
    String m;
    public Accepter_clients(ServerSocket s,int a){
        socketserver = s;
        n =a;
    }
    
    @Override
    public void run() {
        try{
          Socket clientSocket = socketserver.accept();
          DataInputStream inFromClient = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
          DataOutputStream outToClient = new DataOutputStream (clientSocket.getOutputStream());
          while(i<5){
           int r = inFromClient.readInt();
           System.out.println(n);
           System.out.println(r);
           if(r ==n){
                m = "ganier";
                System.out.println(m);
                outToClient.writeBytes(m);
                break;
                   }
           else{
               m ="perdu";
               System.out.println(m);
               outToClient.writeBytes(m);
           }
           i = i+1;
          }
           clientSocket.close();
        } catch (IOException e) {   
        }
      
    }

}
