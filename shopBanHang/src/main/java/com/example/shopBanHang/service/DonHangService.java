package com.example.shopBanHang.service;

import com.example.shopBanHang.entity.DonHang;
import com.example.shopBanHang.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DonHangService {
     @Autowired
    private DonHangRepository donHangRepository;
    public List<DonHang> listAll() {
        return donHangRepository.findAll();
    }

    public void save(DonHang donHang) {
        donHangRepository.save(donHang);
    }

    public DonHang get(long id) {
        return donHangRepository.findById(id).get();
    }

    public void delete(long id) {
        donHangRepository.deleteById(id);
    }
}
