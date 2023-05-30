package lk.easycarrental.spring.service.impl;

import lk.easycarrental.spring.dto.CarDTO;
import lk.easycarrental.spring.dto.ImageDTO;
import lk.easycarrental.spring.entity.Car;
import lk.easycarrental.spring.entity.Image;
import lk.easycarrental.spring.repo.CarRepo;
import lk.easycarrental.spring.repo.ImageRepo;
import lk.easycarrental.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepo carRepo;

    @Autowired
    ImageRepo imageRepo;

    @Autowired
    ModelMapper mapper;

    public void addCar(CarDTO dto){
        if (carRepo.existsById(dto.getRegNo())){
            throw new RuntimeException("Car "+dto.getRegNo()+" Already Exist..!");
        }
        Car car = mapper.map(dto,Car.class);
        carRepo.save(car);
    }

    public void updateCar(CarDTO dto){
        if (!carRepo.existsById(dto.getRegNo())){
            throw new RuntimeException("Car "+dto.getRegNo()+" Not Available to Update..!");
        }
        Car entity = mapper.map(dto,Car.class);
        carRepo.save(entity);
    }

    public void deleteCar(String regNo){
        if (!carRepo.existsById(regNo)){
            throw new RuntimeException("Car "+regNo+" Not Available to Delete..!");
        }
        carRepo.deleteById(regNo);
    }

    public ArrayList<CarDTO> getAllCar(){
        List<Car> all = carRepo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }


    public CarDTO searchCarByRegNo(String regNo){
        if (!carRepo.existsById(regNo)){
            throw new RuntimeException("Car "+regNo+" Not Exist..!");
        }
        return mapper.map(carRepo.findById(regNo),new TypeToken<CarDTO>(){}.getType());
    }

    @Override
    public ArrayList<CarDTO> findByTypeAndStatus(String type, String status){
        List<Car> all = carRepo.findByTypeAndStatus(type, status);
        return mapper.map(all,new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }



    @Override
    public ArrayList<CarDTO> findAllBrandsByType(String type){
        List<Car> all = carRepo.findAllBrandsByType(type);
        return mapper.map(all, new TypeToken<ArrayList<CarDTO>>() {}.getType());
    }

    @Override
    public ArrayList<CarDTO> findAllRegNoByBrand(String brand){
        List<Car> all = carRepo.findAllRegNoByBrand(brand);
        ArrayList<CarDTO> map = mapper.map(all, new TypeToken<ArrayList<CarDTO>>() {}.getType());
        System.out.println("ServiceImpl: "+map);
        return map;
    }




//    @Override
//    public void saveFileLocation(ImageDTO dto) {
//        Image img = new Image("");
//
//        try {
//            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//            File uploadsDir = new File(projectPath + "/car");
//            System.out.println(projectPath);
//            uploadsDir.mkdir();
//
//            dto.getImages().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getImages().getOriginalFilename()));
//
//            img.setImages("car/" + dto.getImages().getOriginalFilename());
//
//        } catch (IOException | URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(img);
//        imageRepo.save(img);
//
//    }


//    @Override
//    public void saveFileLocation(ImageDTO dto) {
//        System.out.println("Sout2: "+dto);
//        Image img = new Image("");
//
////        Image carImages = mapper.map(dto,Image.class);
//
//        try {
//            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//            File uploadsDir = new File(projectPath + "/car");
//            System.out.println(projectPath);
//            uploadsDir.mkdir();
//
//            dto.getFileString().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getFileString().getOriginalFilename()));
//
//            img.setFileString("car/" + dto.getFileString().getOriginalFilename());
//
//        } catch (IOException | URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(img);
//        imageRepo.save(img);
//
//    }



    @Override
    public void saveFileLocation(@ModelAttribute ArrayList<MultipartFile> allImages) {
        System.out.println("Sout2: "+allImages);
        for (MultipartFile images : allImages) {
        Image img = new Image("");

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/car");
            System.out.println(projectPath);
            uploadsDir.mkdir();

//            for (MultipartFile images : allImages) {

                images.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + images.getOriginalFilename()));

            img.setFileString("car/" + images.getOriginalFilename());


        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(img);
        imageRepo.save(img);
        }

    }




    @Override
    public ArrayList<String> getImagesByFileString(String fileString) {
        System.out.println("FS2: "+fileString);
        List<String> imageByFileString = imageRepo.findByFileStringContaining(fileString);
        System.out.println("OS2: "+imageByFileString);
//        return mapper.map(imageByFileString,new TypeToken<ArrayList<MultipartFile>>(){}.getType());
        return (ArrayList<String>) imageByFileString;
//        Image images = imageRepo.findByFileStringContaining(fileString);
//        System.out.println("OS2: "+images);
//        return mapper.map(images,new TypeToken<String>(){}.getType());
    }
}
