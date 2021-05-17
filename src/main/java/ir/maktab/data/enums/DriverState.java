package ir.maktab.data.enums;

public enum DriverState {
    WAITING_TO_TRAVEL("Waiting to trip"), DOING_THE_TRAVEL("Doing the trip");

    private String state;

    DriverState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
