package com.example.shopBanHang.api;

import com.example.shopBanHang.entity.DonHang;
import com.example.shopBanHang.entity.KhachHang;
import com.example.shopBanHang.repository.DonHangRepository;
import com.example.shopBanHang.service.DonHangService;
import com.example.shopBanHang.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DonHangControllers {
    private final DonHangRepository Repository;
    @Autowired
    private DonHangService service;


    public DonHangControllers(DonHangRepository repository) {
        Repository = repository;
    }

    @CrossOrigin
    @GetMapping("/DonHangs")
    public List<DonHang> getALL() {
        List<DonHang> listDonHang = service.listAll();

        return listDonHang;
    }

    @CrossOrigin
    @GetMapping("/getDonHangById/{id}")
    public DonHang getDonHangById(@PathVariable Long id){
        DonHang DonHang = service.get(id);
        return DonHang;

    }

    @CrossOrigin
    @PostMapping("/DonHangs")
    public DonHang createDonHang(@RequestBody DonHang donHang) throws Exception {
        try {
            service.save(donHang);
            return service.get(donHang.getId());
        } catch( Exception e) {
            throw new Exception("Đã có");
        }
    }

    @CrossOrigin
    @PutMapping("/DonHangs")
    public DonHang updateDonHang(@RequestBody DonHang donHang) throws Exception {
        try {
            service.save(donHang);
            return service.get(donHang.getId());
        } catch( Exception e) {
            throw new Exception("Đã có");
        }
    }
    @CrossOrigin
    @DeleteMapping("/DonHangs/{id}")
    public String  deleteDonHang(@PathVariable Long id) {
        service.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return "deleted";
    }
}
