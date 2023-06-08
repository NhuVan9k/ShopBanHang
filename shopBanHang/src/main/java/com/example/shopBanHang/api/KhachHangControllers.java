package com.example.shopBanHang.api;

import com.example.shopBanHang.entity.KhachHang;
import com.example.shopBanHang.repository.KhachHangRepository;
import com.example.shopBanHang.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class KhachHangControllers {

    private final KhachHangRepository hangRepository;
    @Autowired
    private KhachHangService service;

    public KhachHangControllers(KhachHangRepository hangRepository) {
        this.hangRepository = hangRepository;
    }

    @CrossOrigin
    @GetMapping("/khachhangs")
    public List<KhachHang> getALL() {
        List<KhachHang> listKhachHang = service.listAll();

        return listKhachHang;
    }

    @CrossOrigin
    @GetMapping("/getkhachhangById/{id}")
    public KhachHang getKhachHangById(@PathVariable Long id){
        KhachHang khachHang = service.get(id);
        return khachHang;

    }

    @CrossOrigin
    @PostMapping("/khachhangs")
    public KhachHang createKhachHang(@RequestBody KhachHang khachHang) throws Exception {
        try {
            service.save(khachHang);
            return service.get(khachHang.getId());
        } catch( Exception e) {
            throw new Exception("Đã có");
        }
    }

    @CrossOrigin
    @PutMapping("/khachhangs")
    public KhachHang updateKhachHang(@RequestBody KhachHang khachHang) throws Exception {
        try {
            service.save(khachHang);
            return service.get(khachHang.getId());
        } catch( Exception e) {
            throw new Exception("Đã có");
        }
    }
    @CrossOrigin
    @DeleteMapping("/khachhangs/{id}")
    public String  deleteKhachHang(@PathVariable Long id) {
        service.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return "deleted";
    }
}
