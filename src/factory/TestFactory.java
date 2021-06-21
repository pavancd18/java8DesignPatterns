package factory;

import model.Circle;

import java.awt.*;
import java.util.List;

public class TestFactory {

    public static void main(String[] args) {

        Factory<Circle> factory = Circle::new;

        Circle c1 = factory.get();

        System.out.println(c1);

        Circle c2 = factory.newInstance();

        System.out.println(c2);

        List<Circle> circleList = factory.get5Circles();

        System.out.println(circleList);

        Factory<Circle> circleFactory2 = Factory.getFactory(factory);

        Circle c3 = circleFactory2.newInstance();

        System.out.println(c3);
        //Partial Application - take a funtion and make it a supplier by fixing the parameter taken by this function
        Factory<Circle> circleFactory3 = Factory.getFactory(Circle::new, Color.RED);

        Circle c4 = circleFactory3.newInstance();
        System.out.println(c4);

        Factory<Circle> singletonFactory = Factory.getSingletonFactory(Circle::new);
        System.out.println(singletonFactory.newInstance() == singletonFactory.newInstance());


    }
}
