package Atm;

import java.util.Scanner;

public class FrontEnd {
    private ATM atm = new ATM(0);
    public void menu()
    {
        int choice=0;
        Scanner scan = new Scanner(System.in);
        System.out.println("please select your choice");
        System.out.println("1: Deposit");
        System.out.println("2: Withdrawal");
        System.out.println("3: Query Balance");
        choice=scan.nextInt();
        while(choice==1||choice==2||choice==3)
        {
            if(choice==1)
            {
                System.out.println("please enter the amount of money");
                double value=scan.nextDouble();
                atm.Deposit(value);
            }
            if(choice==2)
            {
                System.out.println("please enter the amount of money");
                double value=scan.nextDouble();
                atm.Withdrawal(value);
            }
            if(choice==3)
            {
                System.out.println(atm.account.balance);
            }
            System.out.println("please select your choice");
            System.out.println("1: Deposit");
            System.out.println("2: Withdrawal");
            System.out.println("3: Query Balance");
            choice=scan.nextInt();

        }
        //实现此时record的文件写入，以及当前的balance等信息
    }
    public static void main(String[] args)
    {
        FrontEnd me = new FrontEnd();
        me.menu();
        //固定一段时间来加利息
    }

}
