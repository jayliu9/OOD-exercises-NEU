package problem3;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * This class represents an Account with the holder, and the account balance.
 */
public class Account {
    private Name holder;
    private Amount accountBalance;
    private static final int DOLLAR_TO_CENT = 100;

    /**
     * Constructor that creates a new Account object with the specified holder and account balance.
     * @param holder The holder of this Account
     * @param accountBalance The balance of this Account
     */
    public Account(Name holder, Amount accountBalance) {
        this.holder = holder;
        this.accountBalance = accountBalance;
    }

    /**
     * Returns the holder of this Account
     * @return The holder of this Account
     */
    public Name getHolder() {
        return this.holder;
    }

    /**
     * Returns the balance of this Account
     * @return The balance of this Account
     */
    public Amount getAccountBalance() {
        return this.accountBalance;
    }

    /**
     * Creates a new Account object with a different holder but the same account balance.
     * @param holder The new holder
     * @return A new Account object.
     */
    public Account changeHolder(Name holder) {
        return new Account(holder, this.accountBalance);
    }


    /**
     * Creates a new Account object with a different account balance but the same holder.
     * @param accountBalance The new account balance
     * @return A new Account object.
     */
    public Account changeAccountBalance(Amount accountBalance) {
        return new Account(this.holder, accountBalance);
    }

    /**
     * Helper function that expresses the given Amount in cents.
     * @param amountToCalculate The given Amount
     * @return The total cents of the given Amount
     */
    private int calculateTotalCents(Amount amountToCalculate) {
        int totalCents = amountToCalculate.getCent() + amountToCalculate.getDollar() * DOLLAR_TO_CENT;
        return totalCents;

    }

    /**
     * Helper function that expresses the total cents as an Amount object for account balance.
     * @param totalCents The total cents to express
     * @return A new Amount object with the changed dollar and cent.
     */
    private Amount centsToBalance(int totalCents) {
        int centOfChangedAmount = totalCents % DOLLAR_TO_CENT;
        int dollarOfChangedAmount = totalCents / DOLLAR_TO_CENT;
        return this.accountBalance.changeCent(centOfChangedAmount).changeDollar(dollarOfChangedAmount);
    }

    /**
     * Handles a deposit event, in which money is added to the account balance.
     * @param amountToDeposit The Amount to deposit
     * @return A new Account object with the increased account balance.
     */
    public Account deposit(Amount amountToDeposit) {
        int totalCentsToDeposit = this.calculateTotalCents(amountToDeposit);
        int balanceInCents = this.calculateTotalCents(this.accountBalance);
        int totalAfterDeposit = balanceInCents + totalCentsToDeposit;

        Amount increasedAccountBalance = this.centsToBalance(totalAfterDeposit);
        return this.changeAccountBalance(increasedAccountBalance);
    }

    /**
     * Handles a withdrawal event, in which money is withdrawn from the account balance.
     * @param withdrawal The Amount to withdraw
     * @return A new Account object with the decreased account balance.
     */
    public Account withdraw(Amount withdrawal) {
        int totalCentsToWithdraw = this.calculateTotalCents(withdrawal);
        int balanceInCents = this.calculateTotalCents(this.accountBalance);
        int totalAfterWithdraw = balanceInCents - totalCentsToWithdraw;

        Amount decreasedAccountBalance = this.centsToBalance(totalAfterWithdraw);
        return this.changeAccountBalance(decreasedAccountBalance);

    }
}
