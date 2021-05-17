package ir.maktab.data.enums;

public enum TripState {
    DOING("Doing"), FINISHED("Finished");

    private String state;

    TripState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
