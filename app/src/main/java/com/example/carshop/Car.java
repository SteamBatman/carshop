package com.example.carshop;

public class Car {
    private String name;
    private int count;
    private int carResource; // ресурс машин
    private String description;

    Car(String name, String unit, int count, int car ) {
        this.name = name;
        this.count = count;
        this.description = unit;
        this.carResource=car;
    }

    public String getDescription() {
        return this.description;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public int getCarResource() {
        return this.carResource;
    }

    public void setCarResource(int carResource) {
        this.carResource = carResource;
    }
}
