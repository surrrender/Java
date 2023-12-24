package Demo;

public class Char {
    public static void main(String[]args){
        //直接使用字符常量
        char c1 = 'a';
        char c2 = '马';
        //使用Unicode编码值
        char c3 = 39532;
        char c4 = 0x9a6c;
        //使用Unicode码值形式
        char c5 = '\u9a6c';// \为转义 寻找9a64在u下对应的字符
        System.out.println(c2);
    }
    //char 只能表示Unicode编码在65536之间的字符 超过的字符需要使用string
}
