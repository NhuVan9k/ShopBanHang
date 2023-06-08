package com.example.shopBanHang.api;


import com.example.shopBanHang.DTO.SanPhamReqDTO;
import com.example.shopBanHang.entity.SanPham;
import com.example.shopBanHang.service.DonHangService;
import com.example.shopBanHang.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SanPhamControllers {

    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private DonHangService donHangService;


    @CrossOrigin
    @GetMapping("/sanphams")
    public List<SanPham> getALL() {
        List<SanPham> listSanPham = sanPhamService.listAll();

        return listSanPham;
    }

    @CrossOrigin
    @GetMapping("/sanphams/{id}")
    public SanPham getSanPhamById(@PathVariable Long id) {
        SanPham sp = sanPhamService.get(id);
        return sp;

    }

    @CrossOrigin
    @PostMapping("/sanphams")
    public SanPham createSanPham(@RequestBody SanPhamReqDTO sanPham) throws Exception {
       return  this.sanPhamService.create(sanPham);

    }

    @CrossOrigin
    @PutMapping("/sanphams/{id}")
    public SanPham updateSanPham(@PathVariable long id,@RequestBody SanPhamReqDTO sanPham) throws Exception {
        return  this.sanPhamService.update(id,sanPham);
    }


    @CrossOrigin
    @DeleteMapping("/sanphams/{id}")
    public String deleteSanPham(@PathVariable Long id) {
        sanPhamService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return "deleted";
    }

}
