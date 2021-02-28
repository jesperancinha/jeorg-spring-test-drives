package org.jesperancinha.std.flash214.transactions.sevices;

import org.jesperancinha.std.flash214.transactions.model.Car;
import org.jesperancinha.std.flash214.transactions.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;

@Service
@Transactional
public class CarReadUncommittedDAO {

    private final CarRepository carRepository;

    public CarReadUncommittedDAO(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = RuntimeException.class)
    public Car createCar(Car car) {
        final Car save = this.carRepository.save(car);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        GREEN.printGenericLn("Saving car %s", save);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_UNCOMMITTED)
    public Car getCarById(Long id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        final Car car = carRepository.findById(id).orElse(null);
        YELLOW.printGenericLn("This is the car I get -> %s", car);
        return car;
    }

    public List<Car> getAllCars() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        final List<Car> all = carRepository.findAll();
        YELLOW.printGenericLn("These are all cars -> %s", all);
        return all;
    }
}
