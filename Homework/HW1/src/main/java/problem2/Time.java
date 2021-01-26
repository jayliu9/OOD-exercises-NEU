package problem2;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * This class represents Time with the hour, minute, and second.
 */
public class Time {
    private int hour;
    private int minutes;
    private int seconds;
    private static final int DEFAULT_VALUE = 0;
    private static final int MIN_TIME = 0;
    private static final int MAX_HOUR = 23;
    private static final int MAX_MINUTE_OR_SEC = 59;

    /**
     * Constructor that creates a new Time object with the specified hour, minute and second.
     * @param hour - hour of this Time, which is between 0 and 23, inclusive.
     * @param minutes - minute of this Time, which is between 0 and 59 inclusive.
     * @param seconds - second of this Time, which is between 0 and 59 inclusive
     */
    public Time(int hour, int minutes, int seconds) {
        this.hour = this.validateHour(hour);
        this.minutes = this.validateMinOrSec(minutes);
        this.seconds = this.validateMinOrSec(seconds);
    }

    /**
     * Helper method that ensures the hour is valid. If the hour is invalid, the default value is returned. The default
     * value is 0
     * @param hour - the hour to validate
     * @return the validated hour if the hour is valid. Otherwise the default value.
     */
    private int validateHour(int hour) {
        if (hour >= MIN_TIME && hour <= MAX_HOUR) {
            return hour;
        } else {
            return DEFAULT_VALUE;
        }
    }

    /**
     * Helper method that ensures the minute or the second is valid. If the minute or the second is invalid, the default
     * value is returned. The default value is 0
     * @param minOrSec - the minute or the second to validate
     * @return the validated minute or the validated second if the minute or the second is valid. Otherwise the default
     * value.
     */
    private int validateMinOrSec(int minOrSec) {
        if (minOrSec >= MIN_TIME && minOrSec <= MAX_MINUTE_OR_SEC) {
            return minOrSec;
        } else {
            return DEFAULT_VALUE;
        }
    }

    /**
     * Returns the hour of this Time
     * @return the hour of this Time
     */
    public int getHour() {
        return this.hour;
    }

    /**
     * Returns the minute of this Time
     * @return the minute of this Time
     */
    public int getMinutes() {
        return this.minutes;
    }

    /**
     * Returns the second of this Time
     * @return the second of this Time
     */
    public int getSeconds() {
        return this.seconds;
    }

    /**
     * Sets the hour of this Time
     * @param hour the new hour.
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * Sets the minute of this Time
     * @param minutes the new minute.
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * Sets the second of this Time
     * @param seconds the new second.
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
