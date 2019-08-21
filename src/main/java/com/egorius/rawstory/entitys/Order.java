package com.egorius.rawstory.entitys;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

//@Entity
//@Table(name = "orders")
public class Order {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    @Column(name = "cakes")
    private List<Cake> cakes;

    @Column(name = "custom_cakes")
    private List<CustomCake> custom;

    @Column(name = "phone")
    private String phone;

    @Column(name = "date")
    private String date;

    @Column(name = "place")
    private String place;

    @Column(name = "comment")
    private String comment;

    @Column(name = "cost")
    private BigDecimal cost;

    public Order() {
    }

    public Order(List<Cake> cakes, List<CustomCake> custom, String phone, String date, String place, String comment, BigDecimal cost) {
        this.cakes = cakes;
        this.custom = custom;
        this.phone = phone;
        this.date = date;
        this.place = place;
        this.comment = comment;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Cake> getCakes() {
        return cakes;
    }

    public void setCakes(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public List<CustomCake> getCustom() {
        return custom;
    }

    public void setCustom(List<CustomCake> custom) {
        this.custom = custom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Заказ: " + "\nНомер заказа: ").append(id)
                .append("\nНомер телефона: ").append(phone)
                .append("\nДата: ").append(date)
                .append("\nКуда доставлять: ").append(place)
                .append("\nКомментарий: ").append(comment)
                .append("\nИтоговая цена: ").append(cost);
        if (cakes != null) {
            builder.append("\nСписок тортов из каталога:").append(cakes.toString());
        }
        if (custom != null) {
            builder.append("\nСписок собранных тортов:").append(custom.toString());
        }
        return  builder.toString();
    }
}
