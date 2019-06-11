package ExamePratico.Aula8;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ProxyBanckAccount implements  BankAccount{
    private BankAccount bk;

    public ProxyBanckAccount(BankAccount bk) {
        this.bk = bk;
    }

    @Override
    public void deposit(double amount) {
        bk.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        throw new NotImplementedException();
    }

    @Override
    public double balance() {
        throw new NotImplementedException();
    }
}
