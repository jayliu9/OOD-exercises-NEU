package problem2;

public class Trip {
    private String startingLocation;
    private String endLocation;
    private Time startTime;
    private Time endTime;
    private static final int DEFAULT_VALUE = -1;
    private static final int SEC_PER_MIN = 60;
    private static final int SEC_PER_HOUR = 3600;

    public Trip(String startingLocation, String endLocation, Time startTime, Time endTime) {
        this.startingLocation = startingLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartingLocation() {
        return this.startingLocation;
    }

    public String getEndLocation() {
        return this.endLocation;
    }

    public Time getStartTime() {
        return this.startTime;
    }

    public Time getEndTime() {
        return this.endTime;
    }


     private boolean areValidStartEnd(Time startTime, Time endTime) {
         int startHour = this.startTime.getHour();
         int startMin = this.startTime.getMinutes();
         int startSec = this.startTime.getSeconds();
         int endHour = this.endTime.getHour();
         int endMin = this.endTime.getMinutes();
         int endSec = this.endTime.getSeconds();
        return startHour != DEFAULT_VALUE
                && startMin != DEFAULT_VALUE
                && startSec != DEFAULT_VALUE
                && endHour != DEFAULT_VALUE
                && endMin != DEFAULT_VALUE
                && endSec != DEFAULT_VALUE;
     }

    public Time getDuration() {
        if (this.areValidStartEnd(this.startTime, this.endTime)) {
            int startTimeInSec = this.expressTimeAsSec(startTime);
            int endTimeInSec = this.expressTimeAsSec(endTime);
            int totalSecDifference = calculateDifference(startTimeInSec, endTimeInSec);
            if (totalSecDifference != DEFAULT_VALUE) {
                int durationHour = totalSecDifference / SEC_PER_HOUR;
                int durationMin = (totalSecDifference % SEC_PER_HOUR) / SEC_PER_MIN;
                int durationSec = totalSecDifference % SEC_PER_HOUR % SEC_PER_MIN;
                return new Time(durationHour, durationMin, durationSec);
            }
        }
        return new Time(DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);
    }

    private int expressTimeAsSec (Time timeToCalculate) {
        int hour = timeToCalculate.getHour();
        int min = timeToCalculate.getMinutes();
        int sec = timeToCalculate.getSeconds();

        int totalTime = hour * SEC_PER_HOUR + min * SEC_PER_MIN + sec;
        return totalTime;
    }

    private int validateDifference(int timeDifference) {
        if (timeDifference >= 0) {
            return timeDifference;
        } else {
            return DEFAULT_VALUE;
        }
    }

    private int calculateDifference(int startTimeInSec, int endTimeInSec) {
        int timeDifference = endTimeInSec - startTimeInSec;
        return this.validateDifference(timeDifference);
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
