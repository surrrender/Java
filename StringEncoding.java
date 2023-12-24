package Demo;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringEncoding {
    public static void main(String[]args) {
        String s = "你好";
        byte [] bytes = s.getBytes();//[-28, -67, -96, -27, -91, -67]
        System.out.println(Arrays.toString(bytes));
        //使用的是哪种类型的编码呢？
        String property = System.getProperty("file.encoding");//-Dfile.encoding=GBK
        System.out.println(property);

        //       //直接通过参数来修改编码方式
//        try {
//            byte[]bytes1 = s.getBytes("GB2312");
//            System.out.println(Arrays.toString(bytes1));//[-60, -29, -70, -61]
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
    }
}
