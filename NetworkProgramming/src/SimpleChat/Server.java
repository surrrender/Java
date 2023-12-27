package SimpleChat;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static class ReceiveMessages implements Runnable{
        String message;
        Socket socket;
        ReceiveMessages(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                message = reader.readLine();
                while(message!=null){
                    System.out.println("对方："+message);
                    message = reader.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[]args){
        //the()after the try can add some resource that implements AutoCloseable surface,then the resource will
        //close up automatically
        try (ServerSocket serverSocket = new ServerSocket(8088)) {
            Socket socket = serverSocket.accept();
            System.out.println("连接成功，可以开始聊天！");
            Runnable receiveMessages = new ReceiveMessages(socket);
            Thread receive = new Thread(receiveMessages);
            receive.setDaemon(true);//when outer thread shuttle,this thread will shuttle too
            receive.start();

            //the autoFlush is very important.make sure the message is sent immediately
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            Scanner scanner = new Scanner(System.in);
            String OutMessage = scanner.nextLine();
            while(!OutMessage.equals("拜拜")){
                writer.println(OutMessage);
                OutMessage = scanner.nextLine();
            }
            writer.println(OutMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
