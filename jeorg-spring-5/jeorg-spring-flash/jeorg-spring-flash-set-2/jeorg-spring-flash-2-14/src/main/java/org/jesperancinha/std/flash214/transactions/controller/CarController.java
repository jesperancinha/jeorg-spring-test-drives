package org.jesperancinha.std.flash214.transactions.controller;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.console.consolerizer.ConsolerizerColor;
import org.jesperancinha.std.flash214.transactions.model.Car;
import org.jesperancinha.std.flash214.transactions.sevices.CarReadCommittedDAO;
import org.jesperancinha.std.flash214.transactions.sevices.CarReadUncommittedDAO;
import org.jesperancinha.std.flash214.transactions.sevices.CarRepeatableReadDAO;
import org.jesperancinha.std.flash214.transactions.sevices.CarSerializableDAO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;

@RestController
public class CarController {

    private final CarReadUncommittedDAO carReadUncommittedDAO;

    private final CarReadCommittedDAO carReadCommittedDAO;

    private final CarRepeatableReadDAO carRepeatableReadDAO;

    private final CarSerializableDAO carSerializableDAO;


    public CarController(CarReadUncommittedDAO carReadUncommittedDAO,
                         CarReadCommittedDAO carReadCommittedDAO,
                         CarRepeatableReadDAO carRepeatableReadDAO,
                         CarSerializableDAO carSerializableDAO) {
        this.carReadUncommittedDAO = carReadUncommittedDAO;
        this.carReadCommittedDAO = carReadCommittedDAO;
        this.carRepeatableReadDAO = carRepeatableReadDAO;
        this.carSerializableDAO = carSerializableDAO;
    }

    @PostMapping(path = "/create/uncommitted",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car createCar(
            @RequestBody
                    Car car) {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        final Callable<Car> taskCreateCar = () -> {
            try {
                final Car car1 = carReadUncommittedDAO.createCar(car);
                ORANGE.printGenericLn(car1);
                return car1;
            } catch (final RuntimeException e) {
                RED.printExpectedException("We fail on purpose to allow the dirty read to happen", e);
            }
            return null;
        };
        final Callable<Car> taskDirtyReadCar = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                RED.printThrowableAndExit(e);
            }
            final Car carById = carReadUncommittedDAO.getCarById(1L);
            final List<Car> allCars = carReadUncommittedDAO.getAllCars();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                RED.printThrowableAndExit(e);
            }
            return carById;
        };
        executorService.submit(taskCreateCar);
        executorService.submit(taskDirtyReadCar);
        executorService.submit(taskDirtyReadCar);
        executorService.submit(taskDirtyReadCar);
        Car call1 = null;
        try {
            call1 = taskCreateCar.call();
        } catch (Exception exception) {
            RED.printThrowableAndExit(exception);
        }
        Car call2 = null;
        try {
            call2 = taskDirtyReadCar.call();
        } catch (Exception exception) {
            RED.printThrowableAndExit(exception);
        }
        GREEN.printGenericLn(call1);
        GREEN.printGenericLn(call2);
        executorService.shutdown();
        try {
            final boolean b = executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        return carReadUncommittedDAO.getCarById(1L);
    }

    @PostMapping(path = "/create/committed",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car createCarCommitted(
            @RequestBody
                    Car car) {
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        final Callable<Car> taskCreateCar = () -> {
            try {
                List<Long> idsToRemove = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    final Car car1 = carReadCommittedDAO.createCar(car.clone());
                    idsToRemove.add(car1.getId());
                }
                for (int i = 0; i < 10; i++) {
                    carReadCommittedDAO.deleteCarById(idsToRemove.get(i));
                }
                final Car car1 = carReadCommittedDAO.createCar(car.clone());
                ORANGE.printGenericLn(car);
                return car1;
            } catch (final RuntimeException e) {
                RED.printExpectedException("We fail on purpose to allow the dirty read to happen", e);
            }
            return null;
        };
        final Callable<Car> taskDirtyReadCar = () -> {
            final List<Car> allCars = carReadCommittedDAO.getAllCars();
            return allCars.get(0);
        };
        executorService.submit(taskCreateCar);
        executorService.submit(taskDirtyReadCar);
        Car call1 = null;
        try {
            call1 = taskCreateCar.call();
        } catch (Exception exception) {
            RED.printThrowableAndExit(exception);
        }
        Car call2 = null;
        try {
            call2 = taskDirtyReadCar.call();
        } catch (Exception exception) {
            RED.printThrowableAndExit(exception);
        }
        GREEN.printGenericLn(call1);
        GREEN.printGenericLn(call2);
        executorService.shutdown();
        try {
            final boolean b = executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        return carReadCommittedDAO.getCarById(1L);

    }
}
