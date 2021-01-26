package problem2;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * This class represents a Trip with starting location, end location, and start and end time.
 */
public class Trip {
    private String startingLocation;
    private String endLocation;
    private Time startTime;
    private Time endTime;
    private static final int DEFAULT_VALUE = 0;
    private static final int SEC_PER_MIN = 60;
    private static final int SEC_PER_HOUR = 3600;

    /**
     * Constructor that creates a new Trip object with the specified starting location, end location, start time
     * and end time.
     * @param startingLocation - starting location of this Trip.
     * @param endLocation - end location of this Trip.
     * @param startTime - start time of this Trip
     * @param endTime - end time of this Trip
     */
    public Trip(String startingLocation, String endLocation, Time startTime, Time endTime) {
        this.startingLocation = startingLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the starting location of this Trip
     * @return the starting location of this Trip
     */
    public String getStartingLocation() {
        return this.startingLocation;
    }

    /**
     * Returns the end location of this Trip
     * @return the end location of this Trip
     */
    public String getEndLocation() {
        return this.endLocation;
    }

    /**
     * Returns the start time of this Trip
     * @return the start time of this Trip
     */
    public Time getStartTime() {
        return this.startTime;
    }

    /**
     * Returns the end time of this Trip
     * @return the end time of this Trip
     */
    public Time getEndTime() {
        return this.endTime;
    }

    /**
     * Helper method that expresses a given Time object in seconds.
     * @param timeToExpress - the Time object to express
     * @return the total seconds of the Time object
     */
    private int expressTimeAsSec (Time timeToExpress) {
        int hour = timeToExpress.getHour();
        int min = timeToExpress.getMinutes();
        int sec = timeToExpress.getSeconds();

        int totalTime = hour * SEC_PER_HOUR + min * SEC_PER_MIN + sec;
        return totalTime;
    }

    /**
     * Helper method that calculates the difference between a trip's end time and start time.
     * @param startTimeInSec - the start time expressed in seconds
     * @param endTimeInSec - the end time expressed in seconds
     * @return the time difference of the trip expressed in seconds
     */
    private int calculateDifference(int startTimeInSec, int endTimeInSec) {
        int timeDifference = endTimeInSec - startTimeInSec;
        return timeDifference;
    }

    /**
     * Helper method that checks whether the difference between a trip's end time and start time is valid, which means
     * the start time is earlier than the end time.
     * @param timeDifference - the time difference expressed in seconds
     * @return True if the time difference is valid, False otherwise.
     */
    private boolean isValidDifference(int timeDifference) {
        return timeDifference > 0;
    }

    /**
     * Gets the duration of this Trip. The duration is the difference between a trip's end time and start time and
     * expressed in a Time object. If the duration is invalid, the default Time object, a Time object created with
     * all fields of default value, is returned.
     * @return the duration of this Trip.
     */
    public Time getDuration() {
        int startTimeInSec = this.expressTimeAsSec(this.startTime);
        int endTimeInSec = this.expressTimeAsSec(this.endTime);
        int totalSecDifference = calculateDifference(startTimeInSec, endTimeInSec);
        if (this.isValidDifference(totalSecDifference)) {
            int durationHour = totalSecDifference / SEC_PER_HOUR;
            int durationMin = (totalSecDifference % SEC_PER_HOUR) / SEC_PER_MIN;
            int durationSec = totalSecDifference % SEC_PER_HOUR % SEC_PER_MIN;
            return new Time(durationHour, durationMin, durationSec);
        }
        return new Time(DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);
    }

    /**
     * Sets the starting location of this Trip
     * @param startingLocation the new starting location.
     */
    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    /**
     * Sets the end location of this Trip
     * @param endLocation the new end location.
     */
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * Sets the start time of this Trip
     * @param startTime the new start time.
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * Sets the end time of this Trip
     * @param endTime the new end time.
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
