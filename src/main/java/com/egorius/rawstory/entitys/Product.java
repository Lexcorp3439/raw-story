package com.egorius.rawstory.entitys;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String description;

    @Column(name = "image")
    private String imagePath;

    @Column
    @NotNull
    private BigDecimal cost;

    @Column
    @NotNull
    private int cal;

    @Column
    @NotNull
    private int squirrels;

    @Column
    @NotNull
    private int fats;

    @Column
    @NotNull
    private int carbohydrates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getSquirrels() {
        return squirrels;
    }

    public void setSquirrels(int squirrels) {
        this.squirrels = squirrels;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return squirrels == product.squirrels &&
                fats == product.fats &&
                carbohydrates == product.carbohydrates &&
                name.equals(product.name) &&
                description.equals(product.description) &&
                imagePath.equals(product.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, imagePath, squirrels, fats, carbohydrates);
    }
}
