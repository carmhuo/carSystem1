package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void updateById(Car car) {
        carDao.updateById(car);
    }

    @Override
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    @Transactional
    public synchronized boolean purchaseCar(int num, String carName) {
        List<Car> carList = findByCarName(carName);
        if (carList == null || carList.isEmpty() || carList.size() < num) return false;
        List<Car> newCars = carList.subList(0, num);
        newCars.forEach((newCar) -> deleteById(newCar.getId()));
        return true;
    }

    @Override
    public List<Car> searchByCarName(String carName, Integer start, Integer pageSize) {
        List<Car> list = carDao.searchByCarName(carName, start, pageSize);
        return list;
    }
}
