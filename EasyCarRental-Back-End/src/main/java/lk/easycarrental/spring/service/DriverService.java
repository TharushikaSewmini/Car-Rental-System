package lk.easycarrental.spring.service;

import lk.easycarrental.spring.dto.DriverDTO;
import lk.easycarrental.spring.entity.Driver;
import org.modelmapper.TypeToken;

import java.util.ArrayList;
import java.util.List;

public interface DriverService {

    public void addDriver(DriverDTO dto);

    public void updateDriver(DriverDTO dto);

    public void deleteDriver(String driverId);

    public ArrayList<DriverDTO> getAllDriver();

    public DriverDTO getDriverById(String driverId);

    public Boolean searchDriverByUsernameAndPassword(String driverUsername, String driverPassword);

    public ArrayList<DriverDTO> getDriversByDriverStatus(String driverStatus);
}
