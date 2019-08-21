package com.egorius.rawstory.entitys;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@Entity
public class CustomCake {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    @Column(name = "count")
    @NotNull
    private int count;

    @Column(name = "weight")
    @NotNull
    private double weight;

    @Column(name = "main")
    @NotNull
    private String main;

    @Column(name = "layer1")
    @NotNull
    private String layer1;

    @Column(name = "layer2")
    private String layer2;

    @Column(name = "filling")
    private String filling;

    public CustomCake() {
    }

    public CustomCake(@NotNull int count, @NotNull double weight, @NotNull String main, @NotNull String layer1, String layer2, String filling) {
        this.count = count;
        this.weight = weight;
        this.main = main;
        this.layer1 = layer1;
        this.layer2 = layer2;
        this.filling = filling;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getLayer1() {
        return layer1;
    }

    public void setLayer1(String layer1) {
        this.layer1 = layer1;
    }

    public String getLayer2() {
        return layer2;
    }

    public void setLayer2(String layer2) {
        this.layer2 = layer2;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("\n------")
                .append("\nТорт: ")
                .append("\nКоличество: ").append(count)
                .append("\nВес: ").append(weight)
                .append("\nОснова: ").append(main)
                .append("\nПервый слой: ").append(layer1);
        if (layer2 != null) {
            builder.append("\nВторой слой: ").append(layer2);
        }
        builder.append("\nНачинка: ").append(filling).append("\n");
        return builder.toString();
    }
}
