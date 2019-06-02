package LAB_8;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class BankAccountImplProxy implements BankAccount {
    private String bank;
    private double balance;
    private BankAccountImpl bankAcc;

    BankAccountImplProxy(BankAccountImpl bankAcc) {
        this.bank = bankAcc.getBank();
        this.balance=bankAcc.balance();
        this.bankAcc=bankAcc;
    }
    public String getBank() {
        return bank;
    }
    @Override public void deposit(double amount) {
        this.bankAcc.deposit(amount);
    }

    @Override public boolean withdraw(double amount) {
        throw new NotImplementedException();
    }
    @Override public double balance() {
        throw new NotImplementedException();
    }

}
