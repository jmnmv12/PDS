package ExamePratico.Aula8;

public class Person {
    private String name;
    private BankAccount bankAccount;
    public Person(String n) {
        name = n;
        bankAccount = new BankAccountImpl("PeDeMeia", 0);
    }
    public String getName() {
        return name;
    }
    public BankAccount getBankAccount() {
        if(Company.user==User.COMPANY)
            return new ProxyBanckAccount(bankAccount);
        else
            return bankAccount;
    }

}
