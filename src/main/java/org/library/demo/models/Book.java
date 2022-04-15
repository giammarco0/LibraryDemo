package org.library.demo.models;

public class Book implements Title{
    private String name;
    private int lendingTime = 30;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLendingTime() {
        return lendingTime;
    }
}
