package com.sayildiz.kbe_storage.backup_service.model;


import com.opencsv.bean.CsvBindByName;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Product {
    @Id
    //@GeneratedValue(generator = "uuid")
    //@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @CsvBindByName
    @NotNull
    private UUID uuid;

    @NotNull
    @CsvBindByName
    private BigDecimal price;

    @NotNull
    @CsvBindByName
    private String name;

    @NotNull
    @CsvBindByName
    private String description;

    @NotNull
    @CsvBindByName
    private String location;
    @NotNull
    @CsvBindByName
    private int amount;
    @NotNull
    @CsvBindByName
    private int deliveryTime;

    public Product(UUID uuid, BigDecimal price, String name, String description, String location, int amount, int deliveryTime) {
        this.uuid = uuid;
        this.price = price;
        this.name = name;
        this.description = description;
        this.location = location;
        this.amount = amount;
        this.deliveryTime = deliveryTime;
    }
    public Product() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return amount == product.amount && deliveryTime == product.deliveryTime && Objects.equals(uuid, product.uuid) && Objects.equals(price, product.price) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(location, product.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, price, name, description, location, amount, deliveryTime);
    }

    @Override
    public String toString() {
        return "Product{" +
                "uuid=" + uuid +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", amount=" + amount +
                ", deliveryTime=" + deliveryTime +
                '}';
    }
}
