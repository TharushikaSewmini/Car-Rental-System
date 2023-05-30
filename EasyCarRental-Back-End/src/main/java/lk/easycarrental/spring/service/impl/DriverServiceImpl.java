package lk.easycarrental.spring.service.impl;

import lk.easycarrental.spring.dto.CustomerDTO;
import lk.easycarrental.spring.dto.DriverDTO;
import lk.easycarrental.spring.entity.Customer;
import lk.easycarrental.spring.entity.Driver;
import lk.easycarrental.spring.repo.DriverRepo;
import lk.easycarrental.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepo repo;

    @Autowired
    ModelMapper mapper;

    public void addDriver(DriverDTO dto){
        if (repo.existsById(dto.getDriverId())){
            throw new RuntimeException("Driver "+dto.getDriverId()+" Already Exist..!");
        }
        Driver driver = mapper.map(dto, Driver.class);
        repo.save(driver);
    }

    public void updateDriver(DriverDTO dto){
        if (!repo.existsById(dto.getDriverId())){
            throw new RuntimeException("Driver "+dto.getDriverId()+" Not Available to Update..!");
        }
        Driver entity = mapper.map(dto,Driver.class);
        repo.save(entity);
    }

    public void deleteDriver(String driverId){
        if (!repo.existsById(driverId)){
            throw new RuntimeException("Driver "+driverId+" Not Available to Delete..!");
        }
        repo.deleteById(driverId);
    }

    public ArrayList<DriverDTO> getAllDriver(){
        List<Driver> all = repo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }

    @Override
    public DriverDTO getDriverById(String driverId) {
        return mapper.map( repo.findById(driverId),DriverDTO.class);
    }

    @Override
    public Boolean searchDriverByUsernameAndPassword(String driverUsername, String driverPassword) {
//        System.out.println("Controller"+username+""+password);
        Boolean aBoolean = repo.existsByDriverUsernameAndDriverPassword(driverUsername, driverPassword);
        System.out.println(aBoolean);
        if (!aBoolean){
            throw new RuntimeException("Wrong Username or password..!");
        }
        return true;
    }

    @Override
    public ArrayList<DriverDTO> getDriversByDriverStatus(String driverStatus){
        List<Driver> all = repo.getDriversByDriverStatus(driverStatus);
        return mapper.map(all,new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }
}
