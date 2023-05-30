package lk.easycarrental.spring.repo;

import lk.easycarrental.spring.entity.Car;
import lk.easycarrental.spring.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepo extends JpaRepository<Image,String> {
//    @Query(value = "SELECT * FROM Image WHERE fileString LIKE 'car/'fileName'%';", nativeQuery = true)
//    Image getImageByFileString(String fileName);


    @Query("select i.fileString from Image i where i.fileString like %:fileString")
    List<String> findByFileStringContaining(@Param("fileString") String fileString);

//    Image getImageByFileStringIsLike(String fileName);
}
