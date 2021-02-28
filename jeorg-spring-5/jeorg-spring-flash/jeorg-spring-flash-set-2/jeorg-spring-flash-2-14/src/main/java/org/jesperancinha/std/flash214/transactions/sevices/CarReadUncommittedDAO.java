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

@Service
public class CarReadUncommittedDAO {

    private final CarRepository carRepository;

    public CarReadUncommittedDAO(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = RuntimeException.class)
    public Car createCar(Car car) {
        final Car save = this.carRepository.save(car);
        GREEN.printGenericLn("Saving car %s", save);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_UNCOMMITTED)
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
