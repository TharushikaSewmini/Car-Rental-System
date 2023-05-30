package lk.easycarrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ImageDTO {
//    private String carRegNo;
//    private MultipartFile images;
//
//    public ImageDTO(MultipartFile fileString) {
//        this.images = fileString;
//    }


    private String id;
    private MultipartFile fileString;

    public ImageDTO(MultipartFile fileString) {
        this.fileString = fileString;
    }
}
