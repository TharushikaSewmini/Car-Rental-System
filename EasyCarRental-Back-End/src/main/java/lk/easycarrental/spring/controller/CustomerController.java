package lk.easycarrental.spring.controller;

import lk.easycarrental.spring.dto.CustomerDTO;
import lk.easycarrental.spring.service.CustomerService;
import lk.easycarrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService service;

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto){
        service.addCustomer(dto);
        return new ResponseUtil("200", dto.toString()+"Added",null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
        service.updateCustomer(dto);
        return new ResponseUtil("200", dto.toString()+"Updated",null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteCustomer(String email){
        service.deleteCustomer(email);
        return new ResponseUtil("200", email+"Deleted",null);
    }

    @GetMapping
    public ResponseUtil getAllCustomer(){
        ArrayList<CustomerDTO> allCustomer = service.getAllCustomer();
        return new ResponseUtil("200", "Success",allCustomer);
    }

    @GetMapping(params = {"username","password"})
    public ResponseUtil searchCustomerByUsernameAndPassword(String username, String password){
        Boolean value = service.searchCustomerByUsernameAndPassword(username,password);
        System.out.println(value);
        return new ResponseUtil("200"," Success.!",value);
    }

    @GetMapping(params ="username")
    public ResponseUtil getCustomerByUsername(String username){
        System.out.println(username);
        CustomerDTO customer = service.getCustomerByUsername(username);
        System.out.println(customer);
        return new ResponseUtil("200"," Success.!",customer);
    }
    
    @GetMapping(params = "email")
    public ResponseUtil getCustomerByEmail(String email){
        CustomerDTO customer = service.getCustomerByEmail(email);
        return new ResponseUtil("200", "Success",customer);
    }





    @PostMapping(path = "/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveNICAndLicenseFiles(@RequestPart("formNIC") MultipartFile myFile, @RequestPart("formDrivingLicense") MultipartFile licenseFile) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/customer");
            uploadsDir.mkdir();
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
            licenseFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + licenseFile.getOriginalFilename()));
            System.out.println(myFile.getOriginalFilename());
            System.out.println(licenseFile.getOriginalFilename());
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
