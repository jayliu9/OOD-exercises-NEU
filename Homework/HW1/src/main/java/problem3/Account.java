package problem3;

public class Account {
    private String firstName;
    private String lastName;
    private Amount accountBalance;
    private static final int DOLLAR_TO_CENT = 100;

    public Account(String firstName, String lastName, Amount accountBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountBalance = accountBalance;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Amount getAccountBalance() {
        return this.accountBalance;
    }

    public Account changeFirstName(String firstName) {
        return new Account(firstName, this.lastName, this.accountBalance);
    }

    public Account changeLastName(String lastName) {
        return new Account(this.firstName, lastName, this.accountBalance);
    }

    public Account changeAccountBalance(Amount accountBalance) {
        return new Account(this.firstName, lastName, accountBalance);
    }

    public Account deposit(Amount depositedMoney) {
        int dollarToAdd = depositedMoney.getDollar();
        int centToAdd = depositedMoney.getCent();
        int centOfIncreasedBalance = (centToAdd + this.accountBalance.getCent()) % DOLLAR_TO_CENT;
        int carryOfDollar = (centToAdd + this.accountBalance.getCent()) / DOLLAR_TO_CENT;
        int dollarOfIncreasedBalance = this.accountBalance.getDollar() + dollarToAdd + carryOfDollar;
        Amount increasedAccountBalance = this.accountBalance.changeCent(centOfIncreasedBalance)
                .changeDollar(dollarOfIncreasedBalance);
        return this.changeAccountBalance(increasedAccountBalance);
    }
}
