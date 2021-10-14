package com.xyh.boot.bean;

/**
 * @author xyh
 * @date 2021/10/14 13:38
 */
public class Pet {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "pet{" +
                "name='" + name + '\'' +
                '}';
    }

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {
    }
}
