package org.jesperancinha.std.flash214.transactions.repository;

import org.jesperancinha.std.flash214.transactions.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
