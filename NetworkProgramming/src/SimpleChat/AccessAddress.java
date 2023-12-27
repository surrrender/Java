package SimpleChat;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AccessAddress {
    public static void main(String[]args){
        try {
            InetAddress address = InetAddress.getLocalHost();
            String s = address.getHostAddress();
            System.out.println(s);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
