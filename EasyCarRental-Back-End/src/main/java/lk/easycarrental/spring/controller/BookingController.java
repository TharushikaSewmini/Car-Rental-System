package lk.easycarrental.spring.controller;

import lk.easycarrental.spring.dto.BookingDTO;
import lk.easycarrental.spring.service.BookingService;
import lk.easycarrental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveBooking(@RequestBody BookingDTO dto){
        bookingService.addBooking(dto);
        System.out.println("RespData: "+dto);
        return new ResponseUtil("200",dto.toString()+" Successfully Added",null);
    }

    @PostMapping(path = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveLossDamageWaiver(@RequestPart("uploadLossDamageWaiverReceipt") MultipartFile myFile) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/booking");
            uploadsDir.mkdir();
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
            System.out.println(myFile.getOriginalFilename());
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping
    public ResponseUtil getAllBookings(){
        ArrayList<BookingDTO> allBookings = bookingService.getAllBookings();
        return new ResponseUtil("200", " Successfully Loaded",allBookings);
    }

    @GetMapping(params = "bookingStatus")
    public ResponseUtil getAllBookingsByStatus(String bookingStatus){
        ArrayList<BookingDTO> allBookings = bookingService.getAllBookingsByStatus(bookingStatus);
        ResponseUtil responseUtil = new ResponseUtil("200", " Successfully Loaded", allBookings);
        System.out.println(responseUtil);
        return responseUtil;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateBooking(@RequestBody BookingDTO dto){
        bookingService.updateBooking(dto);
        ResponseUtil responseUtil = new ResponseUtil("200", dto.toString() + " Successfully Updated", null);
        System.out.println(responseUtil);
        return responseUtil;
    }

    @GetMapping(path = "/email/{email}")
    public ResponseUtil getAllBookingsByCustomerEmail(@PathVariable String email){
        ArrayList<BookingDTO> allBookings = bookingService.getAllBookingsByCustomerEmail(email);
        ResponseUtil responseUtil = new ResponseUtil("200", " Successfully Loaded", allBookings);
        System.out.println(responseUtil);
        return responseUtil;
    }

    @GetMapping(params = "bookingId")
    public ResponseUtil getBookingsByBookingId(int bookingId){
        BookingDTO booking = bookingService.getBookingsByBookingId(bookingId);
        ResponseUtil responseUtil = new ResponseUtil("200", " Successfully Loaded", booking);
        System.out.println(responseUtil);
        return responseUtil;
    }
}
