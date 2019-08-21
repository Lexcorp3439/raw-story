package com.egorius.rawstory.entitys;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class Cake {
    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "count")
    @NotNull
    private int count;

    public Cake() {
    }

    public Cake(@NotNull String name, @NotNull int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "\n------" +
                "\nТорт: " + name +
                "\nКоличество:" + count;
    }
}
