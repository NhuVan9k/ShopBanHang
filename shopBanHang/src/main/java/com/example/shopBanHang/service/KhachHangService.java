package com.example.shopBanHang.service;

import com.example.shopBanHang.entity.KhachHang;
import com.example.shopBanHang.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class KhachHangService {
    @Autowired
    private KhachHangRepository repository;

    public List<KhachHang> listAll() {
        return repository.findAll();
    }

    public void save(KhachHang sanPham) {
        repository.save(sanPham);
    }

    public KhachHang get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
