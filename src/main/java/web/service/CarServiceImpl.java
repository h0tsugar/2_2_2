package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarDaoImpl;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarDaoImpl carDao;

    public CarServiceImpl(CarDaoImpl carDao) {
        this.carDao = carDao;
    }
    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCar();
    }

    @Override
    public List<Car> capacityCar(Integer count) {
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
