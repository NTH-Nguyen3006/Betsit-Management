package entity;

public class ContractDetail {
    private String id;
    private String roomId;
    private String tenant;
    private String startDate;
    private String endDate;
    private String depositAmount;
    private int paymentCycleMonths;
    private String fileScanUrl;
    private String notes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getPaymentCycleMonths() {
        return paymentCycleMonths;
    }

    public void setPaymentCycleMonths(int paymentCycleMonths) {
        this.paymentCycleMonths = paymentCycleMonths;
    }

    public String getFileScanUrl() {
        return fileScanUrl;
    }

    public void setFileScanUrl(String fileScanUrl) {
        this.fileScanUrl = fileScanUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
