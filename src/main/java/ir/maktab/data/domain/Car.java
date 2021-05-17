package ir.maktab.data.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Car {
    private String tag;
    private String model;
    private String color;

    public Car(String tag, String model, String color) {
        this.tag = tag;
        this.model = model;
        this.color = color;
    }

    public Car() {

    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car: " + tag + " " + model + " " + color;
    }
}
