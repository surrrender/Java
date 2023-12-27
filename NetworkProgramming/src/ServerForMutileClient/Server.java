package ServerForMutileClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static volatile int  count = 0;
    public static void main(String[]args) {
        try (ServerSocket serverSocket = new ServerSocket(8088)) {
            while(true){
                if(count<10) {
                    Thread thread = new ServerDaemon(serverSocket.accept());
                    ++count;
                    thread.start();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
