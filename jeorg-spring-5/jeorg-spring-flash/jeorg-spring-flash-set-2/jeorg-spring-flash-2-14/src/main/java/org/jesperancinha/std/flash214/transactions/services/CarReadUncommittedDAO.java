package org.jesperancinha.std.flash214.transactions.services;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
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
public class CarReadUncommittedDAO implements CarDAO {

    private final CarRepository carRepository;

    public CarReadUncommittedDAO(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_UNCOMMITTED)
    public Car createCar(Car car) {
        final Car save = this.carRepository.save(car);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        ConsolerizerComposer.outSpace().green("Saving car %s", save).reset();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_UNCOMMITTED)
    @Override
    public Car getCarById(Long id) {
        final Car car = carRepository.findById(id).orElse(null);
        YELLOW.printGenericLn("This is the car I get -> %s", car);
        return car;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_UNCOMMITTED)
    public List<Car> getAllCars() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        final List<Car> all = carRepository.findAll();
        GREEN.printGenericLn("These are all cars -> %s", all);
        return all;
    }

    @Override
    public boolean deleteCarById(Long id) {
        carRepository.deleteById(id);
        ConsolerizerComposer.outSpace().red("Deleted car with id %d", id).reset();
        return true;
    }
}
