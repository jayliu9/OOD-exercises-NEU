package problem3;

public class Amount {
    private int dollar;
    private int cent;
    private static final int MIN_DOLLAR = 0;
    private static final int MIN_CENT = 0;
    private static final int MAX_CENT = 99;
    private static final int DEFAULT_VALUE = 0;

    public Amount(int dollar, int cent) {
        this.dollar = this.validateDollar(dollar);
        this.cent = this.validateCent(cent);
    }

    private int validateDollar(int dollar) {
        if (dollar >= MIN_DOLLAR) {
            return dollar;
        } else {
            return DEFAULT_VALUE;
        }
    }

    private int validateCent(int cent) {
        if (cent >= MIN_CENT && cent <= MAX_CENT) {
            return cent;
        } else {
            return DEFAULT_VALUE;
        }
    }

    public int getDollar() {
        return this.dollar;
    }

    public int getCent() {
        return this.cent;
    }

    public Amount changeDollar(int dollar) {
        return new Amount(dollar, this.cent);
    }

    public Amount changeCent(int cent) {
        return new Amount(this.dollar, cent);
    }
}
