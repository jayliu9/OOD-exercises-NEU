package problem2;

public class Time {
    private int hour;
    private int minutes;
    private int seconds;
    private static final int DEFAULT_VALUE = -1;
    private static final int MIN_TIME = 0;
    private static final int MAX_HOUR = 23;
    private static final int MAX_MINUTE_OR_SEC = 59;

    public Time(int hour, int minutes, int seconds) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    private int validateHour(int hour) {
        if (hour >= MIN_TIME && hour <= MAX_HOUR) {
            return hour;
        } else {
            return DEFAULT_VALUE;
        }
    }

    private int validateMinOrSec(int minOrSec) {
        if (minOrSec >= MIN_TIME && minOrSec <= MAX_MINUTE_OR_SEC) {
            return minOrSec;
        } else {
            return DEFAULT_VALUE;
        }
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }
}
