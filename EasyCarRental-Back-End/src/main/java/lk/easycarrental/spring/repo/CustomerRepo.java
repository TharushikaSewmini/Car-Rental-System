package lk.easycarrental.spring.repo;

import lk.easycarrental.spring.dto.CustomerDTO;
import lk.easycarrental.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    Boolean existsByUsernameAndPassword(String username,String password);

    Customer getCustomerByUsername(String username);

    Customer getCustomerByEmail(String email);
}
