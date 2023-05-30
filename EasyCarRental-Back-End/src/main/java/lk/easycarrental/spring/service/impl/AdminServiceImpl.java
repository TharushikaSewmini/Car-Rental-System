package lk.easycarrental.spring.service.impl;

import lk.easycarrental.spring.dto.AdminDTO;
import lk.easycarrental.spring.entity.Admin;
import lk.easycarrental.spring.repo.AdminRepo;
import lk.easycarrental.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepo repo;

    @Autowired
    ModelMapper mapper;

    public void addAdmin(AdminDTO dto){
        if (repo.existsById(dto.getAdminEmail())){
            throw new RuntimeException("Admin "+dto.getAdminEmail()+" Already Exist..!");
        }
        Admin admin = mapper.map(dto,Admin.class);
        repo.save(admin);
    }

    @Override
    public Boolean searchAdminByUsernameAndPassword(String adminUsername, String adminPassword) {
        System.out.println("Service: "+adminUsername+""+adminPassword);
        Boolean aBoolean = repo.existsByAdminUsernameAndAdminPassword(adminUsername, adminPassword);
        System.out.println("Service: "+aBoolean);
        if (!aBoolean){
            throw new RuntimeException("Wrong Username or password..!");
        }
        return true;
    }
}
