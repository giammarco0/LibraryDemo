package org.library.demo.models;

public class Magazine implements Title{
    private String name;
    private int lendingTime = 10;

    public Magazine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLendingTime() {
        return lendingTime;
    }
}
