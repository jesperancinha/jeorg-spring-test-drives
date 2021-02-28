package org.jesperancinha.std.flash214.transactions.sevices;

import org.jesperancinha.std.flash214.transactions.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class CarRepeatableReadDAO {

    private final CarRepository carRepository;

    public CarRepeatableReadDAO(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
