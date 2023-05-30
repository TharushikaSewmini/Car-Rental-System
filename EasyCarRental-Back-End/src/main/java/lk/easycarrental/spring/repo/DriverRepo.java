package lk.easycarrental.spring.repo;

import lk.easycarrental.spring.entity.Customer;
import lk.easycarrental.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {
    Boolean existsByDriverUsernameAndDriverPassword(String username,String password);

    List<Driver> getDriversByDriverStatus(String status);
}
