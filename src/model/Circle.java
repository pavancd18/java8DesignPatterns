package model;

import java.awt.*;

public class Circle {

    private Color color;

    @Override
    public String toString() {
        return "Circle of color " + color;
    }


    public Circle() {
        this.color = Color.WHITE;
    }

    public Circle(Color color) {
        this.color = color;
    }
}
