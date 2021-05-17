package ir.maktab.data.enums;

public enum TripConfirmationState {
    APPROVED("Approved"), NON_APPROVED("Non approved");

    private String state;

    TripConfirmationState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
