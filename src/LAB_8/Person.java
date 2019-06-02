package LAB_8;

class Person {
    private String name;
    private BankAccount bankAccount;
    private BankAccountImplProxy bankAccountProxy;
    public Person(String n) {
        name = n;
        bankAccount = new BankAccountImpl("PeDeMeia", 0);
        bankAccountProxy=new BankAccountImplProxy((BankAccountImpl) bankAccount);
    }
    public String getName() {
        return name;
    }
    public BankAccount getBankAccount() {
        if(Company.user==User.OWNER)
            return bankAccount;
        else if (Company.user==User.COMPANY)
            return bankAccountProxy;
        return bankAccount;
    }
}