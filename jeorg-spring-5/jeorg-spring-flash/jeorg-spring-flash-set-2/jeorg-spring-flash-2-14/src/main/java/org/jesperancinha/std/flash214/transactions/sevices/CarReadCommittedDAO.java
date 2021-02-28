package org.jesperancinha.std.flash214.transactions.sevices;

import org.jesperancinha.std.flash214.transactions.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class CarReadCommittedDAO {

    private final CarRepository carRepository;

    public CarReadCommittedDAO(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


}
