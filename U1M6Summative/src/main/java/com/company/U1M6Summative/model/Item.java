package com.company.U1M6Summative.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    @Id
    @GeneratedValue
    private int itemId;
    private String name;
    private String description;
    private BigDecimal dailyRate;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getItemId() == item.getItemId() &&
                Objects.equals(getName(), item.getName()) &&
                Objects.equals(getDescription(), item.getDescription()) &&
                Objects.equals(getDailyRate(), item.getDailyRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getName(), getDescription(), getDailyRate());
    }
}
