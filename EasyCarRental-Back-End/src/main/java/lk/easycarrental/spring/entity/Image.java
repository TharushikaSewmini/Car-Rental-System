package lk.easycarrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
//@IdClass(Car_Image.class)
public class Image {
//    @Id
//    private String regNo;
//    private String images;
//
//    public Image(String fileString) {
//        this.images = fileString;
//    }
//
////    @ManyToOne
////    @JoinColumn(name = "regNo",referencedColumnName = "regNo",insertable = false,updatable = false)
////    private Car cars;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fileString;

    public Image(String fileString) {
        this.fileString = fileString;
    }
}
