package ServerForMutileClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDaemon extends Thread{
    Socket socket;
    BufferedReader reader;
    PrintWriter writer;
    ServerDaemon(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        writer= new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()),true);
    }
    @Override
    public void run() {
        try {
            String name = reader.readLine();
            System.out.println("hello, "+name);
            while(true){
            if(reader.readLine().equals("bye"))break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            --Server.count;
        }
    }
}
