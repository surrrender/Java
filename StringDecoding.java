package Demo;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringDecoding {
    public static void main(String[]args) throws UnsupportedEncodingException {
        //直接使用默认解码方式
        byte[]bytes = {-28, -67, -96, -27, -91, -67};
        String s = new String(bytes);
        System.out.println(s);
        //用指定解码方式来创建string
        byte[]bytes1 = {-60, -29, -70, -61};
        //String s1 = new String(bytes1);//编码的可逆情况
        String s1 = new String(bytes1,"GB2312");
        System.out.println(s1);

        //可逆与不可逆问题
        String str = "你好";
        //不可逆
        byte[] bytes2 = str.getBytes(StandardCharsets.ISO_8859_1);//适用于西欧的编码
        System.out.println(Arrays.toString(bytes2));
        String newStr = new String(bytes2,"ISO_8859_1");
        System.out.println(newStr);
    }
}
