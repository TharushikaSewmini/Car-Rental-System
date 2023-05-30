package lk.easycarrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
//    private String id;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String drivingLicenseNo;
    private String nic;
    private String username;
    private String password;
}
