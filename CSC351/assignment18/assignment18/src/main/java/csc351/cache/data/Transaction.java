package csc351.cache.data;

import java.util.Objects;

public class Transaction {
    private Integer deviceId;
    private Integer productId;
    private Integer statusId;
    private String amount;
    private String date;
    private String time;

    public Integer getDeviceId() {
        return deviceId;
    }

    public Transaction setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public Transaction setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public Transaction setStatusId(Integer statusId) {
        this.statusId = statusId;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public Transaction setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Transaction setDate(String date) {
        this.date = date;
        return this;
    }

    public String getTime() {
        return time;
    }

    public Transaction setTime(String time) {
        this.time = time;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(deviceId, that.deviceId) && Objects.equals(productId, that.productId) && Objects.equals(statusId, that.statusId) && Objects.equals(amount, that.amount) && Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, productId, statusId, amount, date, time);
    }
}
