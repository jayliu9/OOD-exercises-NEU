package problem3;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * This class represents an Amount with the dollar amount and cent amount.
 */
public class Amount {
    private int dollar;
    private int cent;
    private static final int MIN_DOLLAR = 0;
    private static final int MIN_CENT = 0;
    private static final int MAX_CENT = 99;
    private static final int DEFAULT_VALUE = 0;

    /**
     * Constructor that creates a new Amount object with the specified dollar and cent.
     * @param dollar Dollar amount of this Amount, which is greater than or equal to 0.
     * @param cent Cent amount of this Amount, which is between 0 and 99 inclusive.
     */
    public Amount(int dollar, int cent) {
        this.dollar = this.validateDollar(dollar);
        this.cent = this.validateCent(cent);
    }

    /**
     * Helper method that ensures the dollar amount is valid. If the dollar amount is invalid,
     * the default value is returned. The default value is 0
     * @param dollar The dollar amount to validate
     * @return The validated dollar amount if the dollar is valid. Otherwise the default value.
     */
    private int validateDollar(int dollar) {
        if (dollar >= MIN_DOLLAR) {
            return dollar;
        } else {
            return DEFAULT_VALUE;
        }
    }

    /**
     * Helper method that ensures the cent amount is valid. If the cent amount is invalid,
     * the default value is returned. The default value is 0
     * @param cent The cent amount to validate
     * @return The validated cent amount if the cent is valid. Otherwise the default value.
     */
    private int validateCent(int cent) {
        if (cent >= MIN_CENT && cent <= MAX_CENT) {
            return cent;
        } else {
            return DEFAULT_VALUE;
        }
    }

    /**
     * Returns the dollar amount of this Amount
     * @return The dollar amount of this Amount
     */
    public int getDollar() {
        return this.dollar;
    }

    /**
     * Returns the cent amount of this Amount
     * @return The cent amount of this Amount
     */
    public int getCent() {
        return this.cent;
    }

    /**
     * Creates a new Amount object with a different dollar amount but the same cent amount.
     * @param dollar The new dollar amount
     * @return A new Amount object.
     */
    public Amount changeDollar(int dollar) {
        return new Amount(dollar, this.cent);
    }

    /**
     * Creates a new Amount object with a different cent amount but the same dollar amount.
     * @param cent The new dollar amount
     * @return A new Amount object.
     */
    public Amount changeCent(int cent) {
        return new Amount(this.dollar, cent);
    }
}
