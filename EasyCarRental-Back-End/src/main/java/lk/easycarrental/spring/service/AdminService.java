package lk.easycarrental.spring.service;

import lk.easycarrental.spring.dto.AdminDTO;

public interface AdminService {

    public void addAdmin(AdminDTO dto);

    public Boolean searchAdminByUsernameAndPassword(String adminUsername, String adminPassword);
}
