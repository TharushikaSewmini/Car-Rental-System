package lk.easycarrental.spring.service.impl;

import lk.easycarrental.spring.dto.CustomerDTO;
import lk.easycarrental.spring.entity.Customer;
import lk.easycarrental.spring.repo.CustomerRepo;
import lk.easycarrental.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    public void addCustomer(CustomerDTO dto){
        if (repo.existsById(dto.getEmail())){
            throw new RuntimeException("Customer "+dto.getEmail()+" Already Exist..!");
        }
        Customer customer = mapper.map(dto, Customer.class);
        repo.save(customer);
    }

    public void updateCustomer(CustomerDTO dto){
        if (!repo.existsById(dto.getEmail())){
            throw new RuntimeException("Customer "+dto.getEmail()+" Not Available to Update..!");
        }
        Customer entity = mapper.map(dto,Customer.class);
        repo.save(entity);
    }

    public void deleteCustomer(String email){
        if (!repo.existsById(email)){
            throw new RuntimeException("Customer "+email+" Not Available to Delete..!");
        }
        repo.deleteById(email);
    }

    public ArrayList<CustomerDTO> getAllCustomer(){
        List<Customer> all = repo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }

    @Override
    public Boolean searchCustomerByUsernameAndPassword(String username, String password) {
//        System.out.println("Controller"+username+""+password);
        Boolean aBoolean = repo.existsByUsernameAndPassword(username, password);
        System.out.println(aBoolean);
        if (!aBoolean){
            throw new RuntimeException("Wrong Username or password..!");
        }
        return true;
    }

    @Override
    public CustomerDTO getCustomerByUsername(String username) {
        return mapper.map(repo.getCustomerByUsername(username),CustomerDTO.class);
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        CustomerDTO customer = mapper.map(repo.getCustomerByEmail(email), CustomerDTO.class);
        return customer;
    }
}
