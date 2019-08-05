package com.egorius.rawstory.entitys;

import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("unused")
@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String description;

    @Type( type = "string-array" )
    @Column(
            name = "images",
            columnDefinition = "text[]"
    )
    private String[] paths;

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

    public String[] getPaths() {
        return paths;
    }

    public void setPaths(String[] paths) {
        this.paths = paths;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return cal == product.cal &&
                squirrels == product.squirrels &&
                fats == product.fats &&
                carbohydrates == product.carbohydrates &&
                name.equals(product.name) &&
                description.equals(product.description) &&
                Arrays.equals(paths, product.paths) &&
                cost.equals(product.cost);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, description, cost, cal, squirrels, fats, carbohydrates);
        result = 31 * result + Arrays.hashCode(paths);
        return result;
    }
}
