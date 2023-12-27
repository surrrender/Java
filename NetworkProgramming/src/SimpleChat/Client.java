package SimpleChat;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/*
客户端使用一个线程来专门接收信息，保证收发信息不冲突，且设置当主线程结束，此线程因会被同时关闭。
 */
public class Client {
    /*
    专门用来接受信息的线程
     */
    public static class ReceiveMessage extends Thread {
        String messages;
        Socket socket;
        ReceiveMessage(Socket socket)
        {
            this.socket = socket;
        }
        @Override
        public void run() throws RuntimeException{
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                messages = reader.readLine();
                while(messages!=null){
                    System.out.println("对方："+messages);
                    messages = reader.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[]args) {
        try {
            Socket socket = new Socket("localhost",8088);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

            ReceiveMessage thread = new ReceiveMessage(socket);
            thread.setDaemon(true);
            thread.start();

            Scanner scanner = new Scanner(System.in);
            String out = scanner.nextLine();
            while(!out.equals("拜拜")) {
                writer.println(out);
                out = scanner.nextLine();
            }
            writer.println("拜拜");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

