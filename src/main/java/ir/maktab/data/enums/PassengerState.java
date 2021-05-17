package ir.maktab.data.enums;

public enum PassengerState {
    ATTEND_THE_TRIP("Attend the trip"), NON_ATTENDANCE_THE_TRIP("Non Attend the trip");

    private String state;

    PassengerState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
