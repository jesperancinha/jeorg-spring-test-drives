package org.jesperancinha.std.flash214.transactions.sevices;

import org.jesperancinha.std.flash214.transactions.model.Car;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarDAO {
    Car createCar(Car car);

    Car getCarById(Long id);

    List<Car> getAllCars();

    boolean deleteCarById(Long id);
}
