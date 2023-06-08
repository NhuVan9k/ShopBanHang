package com.example.shopBanHang.service;

import com.example.shopBanHang.DTO.SanPhamReqDTO;
import com.example.shopBanHang.entity.DonHang;
import com.example.shopBanHang.entity.SanPham;
import com.example.shopBanHang.repository.DonHangRepository;
import com.example.shopBanHang.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private DonHangRepository donHangRepository;

    public List<SanPham> listAll() {
        return sanPhamRepository.findAll();
    }

    public void save(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    public SanPham get(long id) {
        return sanPhamRepository.findById(id).get();
    }

    public void delete(long id) {
        sanPhamRepository.deleteById(id);
    }

    public SanPham create(SanPhamReqDTO reqDTO) {
        Long donhangid = reqDTO.getDonHangId();
        Optional<DonHang> foundDH = this.donHangRepository.findById(donhangid);
        if (!foundDH.isPresent()) {
            return null;
        }
        SanPham sanPham = new SanPham();
        sanPham.setDonHang(foundDH.get());
        sanPham.setTenSanPham(reqDTO.getTenSanPham());
        sanPham.setMoTa(reqDTO.getMoTa());
        sanPham.setSoLuong(reqDTO.getSoLuong());
        sanPham.setGiaTien(reqDTO.getGiaTien());
        this.sanPhamRepository.save(sanPham);
        return sanPham;
    }

    public SanPham update(long id, SanPhamReqDTO reqDTO) {
        Optional<SanPham> foundsanpham = this.sanPhamRepository.findById(id);
        if (!foundsanpham.isPresent()) {
            return null;
        }
        foundsanpham.get().setTenSanPham(reqDTO.getTenSanPham());
        foundsanpham.get().setGiaTien(reqDTO.getGiaTien());
        foundsanpham.get().setSoLuong(reqDTO.getSoLuong());
        foundsanpham.get().setMoTa(reqDTO.getMoTa());
        this.sanPhamRepository.save(foundsanpham.get());
        return foundsanpham.get();
    }


}
