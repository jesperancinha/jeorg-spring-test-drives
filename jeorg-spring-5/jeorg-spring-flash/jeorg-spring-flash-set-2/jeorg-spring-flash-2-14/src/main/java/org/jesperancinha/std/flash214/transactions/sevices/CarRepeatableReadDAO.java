package org.jesperancinha.std.flash214.transactions.sevices;

import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.jesperancinha.std.flash214.transactions.model.Car;
import org.jesperancinha.std.flash214.transactions.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Service
public class CarRepeatableReadDAO implements CarDAO{

    private final CarRepository carRepository;

    public CarRepeatableReadDAO(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car createCar(Car car) {
        final Car save = this.carRepository.save(car);
        GREEN.printGenericLn("Saving car %s", save);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.REPEATABLE_READ)
    @Override
    public Car getCarById(Long id) {
        final Car car = carRepository.findById(id).orElse(null);
        YELLOW.printGenericLn("This is the car I get -> %s", car);
        return car;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.REPEATABLE_READ)
    public List<Car> getAllCars() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        for (int i = 0; i < 20; i++) {
            final List<Car> allCars1 = carRepository.findAll();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                RED.printThrowableAndExit(e);
            }
            Consolerizer.printRandomColorGeneric("There are still %d cars available!", allCars1.size());
        }
        return carRepository.findAll();
    }

    @Override
    public boolean deleteCarById(Long id) {
        carRepository.deleteById(id);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        return true;
    }
}
