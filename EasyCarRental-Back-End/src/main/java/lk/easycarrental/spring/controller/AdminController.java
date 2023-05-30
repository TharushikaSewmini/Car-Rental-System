package lk.easycarrental.spring.controller;

import lk.easycarrental.spring.dto.AdminDTO;
import lk.easycarrental.spring.service.AdminService;
import lk.easycarrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService service;

    @PostMapping
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO dto){
        service.addAdmin(dto);
        return new ResponseUtil("200",dto.toString()+" Successfully Added",null);
    }

    @GetMapping(params = {"adminUsername","adminPassword"})
    public ResponseUtil searchAdminByUsernameAndPassword(String adminUsername, String adminPassword){
        System.out.println("Controller: "+adminUsername+adminPassword);
        Boolean value = service.searchAdminByUsernameAndPassword(adminUsername,adminPassword);
        System.out.println("Controller: "+value);
        return new ResponseUtil("200"," Success.!",value);
    }
}
