package problem3;

public class Account {
    private String firstName;
    private String lastName;
    private Amount accountBalance;

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
}
