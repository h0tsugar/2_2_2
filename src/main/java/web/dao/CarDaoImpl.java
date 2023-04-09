package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {

    @Override
    public List<Car> getAllCar() {
        List<Car> list = new ArrayList<>();
        list.add(new Car("Honda", "Accord", "Red"));
        list.add(new Car("BMW", "X7", "Black"));
        list.add(new Car("Lada", "Vesta", "White"));
        list.add(new Car("Kia", "Optima", "Blue"));
        list.add(new Car("Toyota", "Camry", "Orange"));
        return list;
    }

    @Override
    public List<Car> capacityCar(Integer count) {
        CarDaoImpl carDao = new CarDaoImpl();
        if (count <= 0) {
            count = 0;
        }
        if (count >= 5) {
            return carDao.getAllCar();
        }
        return carDao.getAllCar().stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
