package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.Car;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface CarService {

    List<Car> findAll();

    Car findById(int id);

    List<Car> findByCarName(String carName);

    void deleteById(int id);

    void updateById(Car car);

    void insertCar(Car car);

    boolean purchaseCar(int num, String carName);

    List<Car> searchByCarName(String carName, Integer currentPage, Integer pageSize);
}
