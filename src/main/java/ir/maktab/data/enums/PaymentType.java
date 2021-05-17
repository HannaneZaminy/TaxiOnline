package ir.maktab.data.enums;

public enum PaymentType {
    PAY_BY_CASH("Pay by cash"), PAY_BY_ACCOUNT_BALANCE("Pay by account balance");

    private String paymentType;

    PaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
