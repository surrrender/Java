package ServerForMutileClient;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[]args){
        for(int i=0;i<12;i++){
            Thread thread = new clientThread("thread"+i);
            thread.start();
        }
    }
    public static class clientThread extends Thread{
        clientThread(String name){
            this.setName(name);
        }
        @Override
        public void run() {
            try (Socket socket = new Socket("localhost",8088)){
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
                writer.println(this.getName());
                Thread.sleep(3000);
                writer.println("bye");
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

