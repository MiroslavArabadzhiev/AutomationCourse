package Homeworks.Lecture8_HW;

public class Circle extends Shape {
    @Override
    Double getArea(Double radius) {
        return Math.PI * (radius * radius);
    }

    @Override
    Double getPerimeter(Double radius) {
        return 2 * Math.PI * radius;
    }
}
