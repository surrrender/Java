package Basic_FileIO_Homework;

import java.io.File;
import java.util.Scanner;

public class FrontEnd {
    public static void main(String[]args){
        ControllerToReadAndWrite machine = new ControllerToReadAndWrite();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要保存的文件路径");
        File file = new File(scanner.next());
        int Index;
        do {
            try{System.out.println("请依次输入新添加学生的学号 姓名 分数(直接输入-1停止)");
                Index = scanner.nextInt();
                if(Index!=-1) {
                    machine.addRecord(Index, scanner.next(), scanner.nextDouble());
                }
            }catch (Exception e){System.out.println("输入信息存在不合法");Index=1;}
        }while(Index!=-1);
        machine.writeToFile(file);
        machine.display(file);
    }
}
