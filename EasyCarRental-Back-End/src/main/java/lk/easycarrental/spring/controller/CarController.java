package lk.easycarrental.spring.controller;

import lk.easycarrental.spring.dto.CarDTO;
import lk.easycarrental.spring.dto.ImageDTO;
import lk.easycarrental.spring.entity.Image;
import lk.easycarrental.spring.service.CarService;
import lk.easycarrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto){
        carService.addCar(dto);
        return new ResponseUtil("200",dto.toString()+" Successfully Added",null);
    }

    @PutMapping
    public ResponseUtil updateCar(@RequestBody CarDTO dto){
        carService.updateCar(dto);
        return new ResponseUtil("200", dto.toString()+" Successfully Updated",null);
    }

    @DeleteMapping(params = "regNo")
    public ResponseUtil deleteCar(String regNo){
        carService.deleteCar(regNo);
        return new ResponseUtil("200", regNo+" Successfully Deleted",null);
    }

    @GetMapping
    public ResponseUtil getAllCar(){
        ArrayList<CarDTO> allCar = carService.getAllCar();
        return new ResponseUtil("200", " Successfully Loaded",allCar);
    }


    @GetMapping(path = "/search/{regNo}")
    public ResponseUtil searchCarByRegNo(@PathVariable String regNo){
        CarDTO car = carService.searchCarByRegNo(regNo);
        return new ResponseUtil("200"," Success.!",car);
    }

    @GetMapping(params = {"type","status"})
    public ResponseUtil getAllCarByTypeAndStatus(String type, String status){
        ArrayList<CarDTO> all = carService.findByTypeAndStatus(type,status);
        return new ResponseUtil("200"," Success.!",all);
    }





    @GetMapping(params = "type")
    public ResponseUtil getAllCarBrandsByType(@RequestParam String type){
        ArrayList<CarDTO> all = carService.findAllBrandsByType(type);
        return new ResponseUtil("200", " Success.!", all);
    }

    @GetMapping(params = "brand")
    public ResponseUtil getAllCarsByBrand(@RequestParam String brand){
        ArrayList<CarDTO> all = carService.findAllRegNoByBrand(brand);
        return new ResponseUtil("200", " Success.!", all);
    }





//    @PostMapping(path = "/images")
//    public ResponseUtil uploadFileWithSpringWay(@ModelAttribute ImageDTO dto) {
//        System.out.println("Sout1: "+dto);
//        carService.saveFileLocation(dto);
//        return new ResponseUtil("ok","Successfully",null);
//    }


    @PostMapping(path = "/images")
    public ResponseUtil uploadFileWithSpringWay(@RequestParam("fileString[]") ArrayList<MultipartFile> allImages) {
        System.out.println("Sout1: "+allImages);
        carService.saveFileLocation(allImages);
        return new ResponseUtil("ok","Successfully",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(params = "regNo")
    public ResponseUtil getCarImages(String regNo) {
        System.out.println("FS1: "+regNo);
        ArrayList<String> carImages = carService.getImagesByFileString(regNo);
        System.out.println("OS1: "+carImages);
        return new ResponseUtil("OK", "Successfully Loaded. :", carImages);
    }


//    @PostMapping(path = "/images",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public boolean saveFile(@RequestPart("car") MultipartFile carFile) {
//
//        try {
//            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//            File uploadsDir = new File(projectPath + "/car");
//            uploadsDir.mkdir();
//            carFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + carFile.getOriginalFilename()));
//            return true;
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//            return false;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
