package lk.easycarrental.spring.service;

import lk.easycarrental.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    public void addCustomer(CustomerDTO dto);

    public void updateCustomer(CustomerDTO dto);

    public void deleteCustomer(String id);

    public ArrayList<CustomerDTO> getAllCustomer();

    public Boolean searchCustomerByUsernameAndPassword(String username, String password);

    public CustomerDTO getCustomerByUsername(String username);

    public CustomerDTO getCustomerByEmail(String email);
}
