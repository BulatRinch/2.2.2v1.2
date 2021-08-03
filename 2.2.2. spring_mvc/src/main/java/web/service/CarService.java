package web.service;

import web.model.Car;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    List<Car> cars = new ArrayList<>();
    {
        cars.add(new Car(1, "BMW", "X5"));
        cars.add(new Car(2, "BMW", "X3"));
        cars.add(new Car(3, "Mercedes", "S300"));
        cars.add(new Car(4, "Audi", "Q5"));
        cars.add(new Car(5, "Toyota", "RAV4"));
    }

    public List<Car> showAll(String id) {
        int num;
        if (id==null) {
            id="5";
        }
        num=Integer.parseInt(id);
        return cars.stream().filter((p)->p.getId()<=num).collect(Collectors.toList());
    }



}
