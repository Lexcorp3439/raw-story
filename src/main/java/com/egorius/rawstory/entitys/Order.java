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

    public Order(List<Cake> cakes, String phone, String date, String place, String comment, BigDecimal cost) {
        this.cakes = cakes;
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
        return "Заказ: " +
                "\nНомер заказа: " + id +
                "\nНомер телефона: " + phone  +
                "\nДата: " + date  +
                "\nКуда доставлять: " + comment +
                "\nКомментарий: " + comment +
                "\nИтоговая цена: " + cost +
                "\nСписок тортов:" + cakes.toString();
    }
}
