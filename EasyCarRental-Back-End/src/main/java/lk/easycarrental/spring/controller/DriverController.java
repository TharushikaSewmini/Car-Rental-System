package lk.easycarrental.spring.controller;

import lk.easycarrental.spring.dto.CustomerDTO;
import lk.easycarrental.spring.dto.DriverDTO;
import lk.easycarrental.spring.service.DriverService;
import lk.easycarrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    DriverService service;

    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto){
        service.addDriver(dto);
        return new ResponseUtil("200", dto.toString()+"Added",null);
    }

    @PutMapping
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        service.updateDriver(dto);
        return new ResponseUtil("200", dto.toString()+"Updated",null);
    }

    @DeleteMapping(params = "driverId")
    public ResponseUtil deleteDriver(String driverId){
        service.deleteDriver(driverId);
        return new ResponseUtil("200", driverId+"Deleted",null);
    }

    @GetMapping
    public ResponseUtil getAllDriver(){
        ArrayList<DriverDTO> allCustomer = service.getAllDriver();
        return new ResponseUtil("200", "Success",allCustomer);
    }

    @GetMapping(params ="driverId")
    public ResponseUtil getDriverById(String driverId){
        System.out.println(driverId);
        DriverDTO driver = service.getDriverById(driverId);
        System.out.println(driver);
        return new ResponseUtil("200"," Success.!",driver);
    }

    @GetMapping(params = {"username","password"})
    public ResponseUtil searchDriverByUsernameAndPassword(String username, String password){
        Boolean value = service.searchDriverByUsernameAndPassword(username,password);
        System.out.println(value);
        return new ResponseUtil("200"," Success.!",value);
    }

    @GetMapping(params ="driverStatus")
    public ResponseUtil getDriversByStatus(@RequestParam String driverStatus){
        ArrayList<DriverDTO> all = service.getDriversByDriverStatus(driverStatus);
        return new ResponseUtil("200", "Success",all);
    }
}
