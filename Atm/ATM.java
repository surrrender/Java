package Atm;

/*
single-user-version
 */
class ATM {

    Account account;//only the account of one person
    public ATM(double x)
    {
        account = new Account();
        account.balance = x;
    }
    public void Deposit(double value)
    {
        if(value<0)
            System.out.println("存入金额必须大于0");
        else {
            account.balance+=value;
            account.record.transactionArrayList.add(new Transaction(1,value));
        }
    }
    public void Withdrawal(double value)
    {
        if(value<0){
            System.out.println("提取金额必须大于0");
        }
        if(value>account.balance)
        {
            System.out.println("提取金额超过存储的金额");
        }
        else
        {
            account.balance-=value;
            account.record.transactionArrayList.add(new Transaction(2,value));
        }
    }
    public void addInterest() {
        account.balance += account.interest*account.balance;
        account.record.transactionArrayList.add(new Transaction(3,account.interest*account.balance));
    }
}
