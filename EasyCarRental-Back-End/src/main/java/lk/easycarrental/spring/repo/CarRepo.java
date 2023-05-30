package lk.easycarrental.spring.repo;

import lk.easycarrental.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {
    Car findCarByRegNo(String brand);

    ArrayList<Car> findByTypeAndStatus(String type, String status);

//    ArrayList<Car> findByType(String type);

    @Query(value = "select distinct i from Car i where i.type=:type group by i.brand")
    ArrayList<Car> findAllBrandsByType(@Param("type") String type);

    @Query(value = "select i from Car i where i.brand=:brand")
    ArrayList<Car> findAllRegNoByBrand(@Param("brand") String brand);

}
