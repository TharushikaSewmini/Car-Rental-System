package lk.easycarrental.spring.service;

import lk.easycarrental.spring.dto.CarDTO;
import lk.easycarrental.spring.dto.ImageDTO;
import lk.easycarrental.spring.entity.Image;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface CarService {
    public void addCar(CarDTO dto);

    public void updateCar(CarDTO dto);

    public void deleteCar(String regNo);

    public ArrayList<CarDTO> getAllCar();

    public CarDTO searchCarByRegNo(String regNo);

    public ArrayList<CarDTO> findByTypeAndStatus(String type, String status);



    public ArrayList<CarDTO> findAllBrandsByType(String type);

    public ArrayList<CarDTO> findAllRegNoByBrand(String brand);


//    public void saveFileLocation(@ModelAttribute ImageDTO allImages);

    public void saveFileLocation(@ModelAttribute ArrayList<MultipartFile> allImages);

    public ArrayList<String> getImagesByFileString(String fileString);
}
