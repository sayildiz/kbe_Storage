package com.sayildiz.kbe_storage.product_api.model;

import com.opencsv.bean.CsvBindByName;
import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ProductInfo {
    @Id
    //@GeneratedValue(generator = "uuid")
    //@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @CsvBindByName
    private UUID uuid;
    @NotNull
    @CsvBindByName
    private String location;
    @NotNull
    @CsvBindByName
    private int amount;
    @NotNull
    @CsvBindByName
    private int deliveryTime;

    public ProductInfo(UUID uuid, String location, int amount, int deliveryTime) {
        this.uuid = uuid;
        this.location = location;
        this.amount = amount;
        this.deliveryTime = deliveryTime;
    }

    public ProductInfo() {

    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getLocation() {
        return location;
    }

    public int getAmount() {
        return amount;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo that = (ProductInfo) o;
        return amount == that.amount && deliveryTime == that.deliveryTime && Objects.equals(uuid, that.uuid) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, location, amount, deliveryTime);
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + uuid +
                ", location='" + location + '\'' +
                ", amount=" + amount +
                ", deliveryTime=" + deliveryTime +
                '}';
    }
}
